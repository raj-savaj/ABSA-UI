package com.acc.services;

import com.acc.entity.CiCustMast;
import com.acc.entity.CiCustMemo;
import com.acc.inf.context.SessionContextDTO;
import com.acc.model.dto.memo.*;
import com.acc.repository.CiCustMastRepo;
import com.acc.repository.CiCustMemoRepository;
import com.acc.repository.CustomerMemoRepository;

import com.acc.soap.memo.CustomerMemoDTO;
import com.acc.soap.memo.SessionContext;
import com.acc.soapclient.MemoManagerSoapClient;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemoManagerService {

    @Autowired
    private CiCustMastRepo ciCustMastRepo;

    @Autowired
    private CustomerMemoRepository customerMemoRepository;

    @Autowired
    private MemoManagerSoapClient memoManagerSoapClient;

    @Autowired
    private CiCustMemoRepository repository;

    public List<CustomerSearchResponseDTO> findCustomerIds(CustomerSearchRequestDTO  customerSearchRequestDTO){
        List<CiCustMast> customerIdList = null;
        List<CustomerSearchResponseDTO> searchResponseDTOList = new ArrayList<>();

        if(customerSearchRequestDTO.getSearchCriteria().equals("Customer Short Name")){
            customerIdList = ciCustMastRepo.findCustomersByShortName(customerSearchRequestDTO.getSearchString());
        }
        else  if(customerSearchRequestDTO.getSearchCriteria().equals("Customer ID")){
            customerIdList = ciCustMastRepo.findCustomerById(Long.parseLong(customerSearchRequestDTO.getSearchString()));
        }
        else if(customerSearchRequestDTO.getSearchCriteria().equals("Customer IC")){
            customerIdList = ciCustMastRepo.findCustomerByNationalId(customerSearchRequestDTO.getSearchString());
        }
        if(customerIdList != null){
            for(CiCustMast custMast:customerIdList){
                CustomerSearchResponseDTO customerSearchResponseDTO = new CustomerSearchResponseDTO();
                customerSearchResponseDTO.setCustomerIc(custMast.getNationalId());
                customerSearchResponseDTO.setCustomerId(custMast.getCustomerId());
                customerSearchResponseDTO.setCustomerName(custMast.getFullName());
                searchResponseDTOList.add(customerSearchResponseDTO);
            }
        }
        return searchResponseDTOList;
    }

    public List<Long> getMemos(CustomerMemoRequest request) {
        return customerMemoRepository.findMemoNumbersByCustomerId(request.getCustomerId());
    }

    public List<CiCustMemo> getActiveMemos(Long custId) {
        return repository.findActiveMemosByCustId(custId);
    }

    public CiCustMemo addMemo(CiCustMemo memo) {
        memo.setCtrUpdatSrlNo(1L);
        memo.setDatLastMnt(new Date());
        return repository.save(memo);
    }

    @Transactional
    public int updateMemo(Long custId, Long srlNo, String memoText, String severity, Integer reason) {
        return repository.updateMemo(custId, memoText, severity, reason, srlNo);
    }

    @Transactional
    public int deleteMemo(Long custId, Long srlNo) {
        return repository.deleteMemo(custId, srlNo);
    }

    public MemoDetailsResponseDTO getMemoDetails(MemoDetailsRequest request) {
        MemoDetailsResponseDTO memoDetailsResponseDTO = new MemoDetailsResponseDTO();
        List<CustomerMemoDTO> customerMemoDTOS = memoManagerSoapClient.fetchMemoDetails(convertSessionContentToSoap(request.getSessionContext()), request.getCustomerId());
        if(customerMemoDTOS != null){
            for(CustomerMemoDTO memo:customerMemoDTOS){
                if(request.getCustomerMemoNumber().equals(memo.getMemoNumber())){
                    memoDetailsResponseDTO.setMemoText(memo.getMemoText());
                    return memoDetailsResponseDTO;
                }
            }
        }
        return memoDetailsResponseDTO;
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
