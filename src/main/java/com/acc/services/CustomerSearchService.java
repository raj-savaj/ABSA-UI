package com.acc.services;

import com.acc.model.dto.Customer.CustomerSearchRequest;
import com.acc.model.dto.Customer.CustomerSearchResponseDTO;

import com.acc.repository.CustomerSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerSearchService {

    @Autowired
    private CustomerSearchRepository customerRepository;

    public List<CustomerSearchResponseDTO> searchCustomers(CustomerSearchRequest request) {
        List<CustomerSearchResponseDTO> result = new ArrayList<>();
        if ("Customer Short Name".equalsIgnoreCase(request.getSearchCriteria())) {
            for (Object[] row : customerRepository.searchByCustomerShortName(request.getSearchString())) {
                result.add(new CustomerSearchResponseDTO(
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
            return result;
        }
        else {
            throw new IllegalArgumentException("Unsupported search criteria");
        }
    }
}
