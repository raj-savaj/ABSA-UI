package com.acc.controller.inquiry;

import com.acc.model.dto.Customer.CustomerSearchRequest;
import com.acc.model.dto.Customer.CustomerSearchResponseDTO;
import com.acc.services.CustomerSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerSearchController {

    @Autowired
    private CustomerSearchService customerService;

    @PostMapping("searchCustomer")
    public ResponseEntity<List<CustomerSearchResponseDTO>> searchCustomers(@RequestBody CustomerSearchRequest request) {
        List<CustomerSearchResponseDTO> result = customerService.searchCustomers(request);
        return ResponseEntity.ok(result);
    }
}
