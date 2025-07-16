package com.acc.services;

import com.acc.model.dto.Customer.CustomerAccountInfoDTO;
import com.acc.model.dto.Customer.CustomerSearchRequest;
import com.acc.model.dto.Customer.CustomerSearchResponseDTO;

import com.acc.repository.ChAcctMastRepo;
import com.acc.repository.CustomerSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerSearchService {

    @Autowired
    private CustomerSearchRepository customerRepository;

    @Autowired
    private ChAcctMastRepo acctMastRepo;

    public List<CustomerSearchResponseDTO> searchCustomers(CustomerSearchRequest request) {

            List<CustomerSearchResponseDTO> customerDetailDto = new ArrayList<>();
        List<Object[]> result = new ArrayList<>();
        if(request.getSearchCriteria().equals("Customer Short Name")){
            result = customerRepository.searchByCustomerShortName(request.getSearchString());
        }
        else  if(request.getSearchCriteria().equals("Customer ID")){
            result = customerRepository.searchCustomerById(Long.parseLong(request.getSearchString()));
        }
        else if(request.getSearchCriteria().equals("Customer IC")){
            result = customerRepository.searchCustomerByCustomerIc(request.getSearchString());
        }
        if (result != null)
        {
            for (Object[] row : result) {
                customerDetailDto.add(new CustomerSearchResponseDTO(
                        (String) row[0].toString(),
                        (String) row[1].toString(),
                        (String) row[2].toString(),
                        (String) row[3].toString(),
                        (String) row[4].toString(),
                        (String) row[5].toString(),
                        (String) row[6].toString(),
                        (String) row[7].toString(),
                        (String) row[8].toString()
                ));
            }
        }
                return customerDetailDto;
        }

    public List<CustomerAccountInfoDTO> getAccountInfo(String accountNo) {
        System.out.print("**************************************");
        List<CustomerAccountInfoDTO> result = acctMastRepo.findAccountInfoByAccountNo(accountNo);

        if (result.isEmpty()) {
            throw new RuntimeException("Account not found");
        }
        return result;
    }
}

