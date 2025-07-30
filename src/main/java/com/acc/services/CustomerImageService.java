package com.acc.services;


import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.Customer.CustomerImageRequestDTO;
import com.acc.repository.CustomerImageRepository;
import com.acc.soap.customer.image.*;
import com.acc.soapclient.CustomerImageManagerSoapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerImageService {

    @Autowired
    private CustomerImageManagerSoapClient soapClient;

    @Autowired
    private CustomerImageRepository imageRepository;

    public CustomerImageInquiryResponse getCustomerImageRequest(CustomerImageRequestDTO customerImageRequestDTO) throws FatalException_Exception {
        return soapClient.getCustomerImage(convertSessionContentToSoap(customerImageRequestDTO.getSessionContext()), customerImageRequestDTO.getImageType(), customerImageRequestDTO.getCustomerId());
    }

    public TransactionResponse addCustomerImage(CustomerImageRequestDTO customerImageRequestDTO) throws FatalException_Exception {
        CustomerImageDTO  customerImageDTO = new CustomerImageDTO();
        customerImageDTO.setCustomerImage(customerImageRequestDTO.getCustomerImage());
        customerImageDTO.setCustomerID(customerImageRequestDTO.getCustomerId());
        customerImageDTO.setImageType(customerImageRequestDTO.getImageType());
        return soapClient.addCustomerImage(convertSessionContentToSoap(customerImageRequestDTO.getSessionContext()),customerImageDTO);
    }

    public TransactionResponse modifyCustomerImage(CustomerImageRequestDTO customerImageRequestDTO) throws FatalException_Exception {
        return soapClient.modifyCustomerImage(convertSessionContentToSoap(customerImageRequestDTO.getSessionContext()),customerImageRequestDTO.getImageType(),customerImageRequestDTO.getCustomerId(),customerImageRequestDTO.getCustomerImage(),customerImageRequestDTO.getVersionTicket());
    }

    private SessionContext convertSessionContentToSoap(SessionContextDTO sessionContextDTO){
        SessionContext sessionContext = new SessionContext();
        sessionContext.setBankCode(sessionContextDTO.getBankCode());
        sessionContext.setChannel(sessionContextDTO.getChannel());
        sessionContext.setTransactionBranch(sessionContextDTO.getTransactionBranch());
        sessionContext.setUserId(sessionContextDTO.getUserId());
        return sessionContext;
    }
        public boolean deleteCustomerImage(String customerId,Long imageType) {
            int deletedCount = imageRepository.deleteActiveImageByCustomerIdAndSerialNo(customerId,imageType);
            log.info("Deleted rows: {}", deletedCount);
            return deletedCount > 0;
        }
}
