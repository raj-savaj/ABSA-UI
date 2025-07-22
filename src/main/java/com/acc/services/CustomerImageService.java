package com.acc.services;


import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.Customer.CustomerImageRequestDTO;
import com.acc.soap.CustomerImageInquiryResponse;
import com.acc.soap.FatalException_Exception;
import com.acc.soap.SessionContext;
import com.acc.soapclient.CustomerImageManagerSoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImageService {

    @Autowired
    private CustomerImageManagerSoapClient soapClient;

    public CustomerImageInquiryResponse getCustomerImageRequest(CustomerImageRequestDTO customerImageRequestDTO) throws FatalException_Exception {
        return soapClient.getCustomerImage(convertSessionContentToSoap(customerImageRequestDTO.getSessionContext()), customerImageRequestDTO.getImageType(), customerImageRequestDTO.getCustomerId());
    }

    private SessionContext convertSessionContentToSoap(SessionContextDTO sessionContextDTO){
        SessionContext sessionContext = new SessionContext();
        sessionContext.setBankCode(sessionContextDTO.getBankCode());
        sessionContext.setChannel(sessionContextDTO.getChannel());
        sessionContext.setTransactionBranch(sessionContextDTO.getTransactionBranch());
        sessionContext.setUserId(sessionContextDTO.getUserId());
        return sessionContext;
    }

}
