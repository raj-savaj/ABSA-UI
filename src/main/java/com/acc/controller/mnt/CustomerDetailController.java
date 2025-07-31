package com.acc.controller.mnt;

import com.acc.model.dto.Customer.CustomerDetailRequest;
import com.acc.model.dto.Customer.CustomerDetailResponse;
import com.acc.services.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerDetailController {

    @Autowired
    private CustomerDetailService custService;

    @Autowired
    private CustomerDetailService service;

    @GetMapping("inquiry/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        CustomerDetailResponse response = service.getCustomerById(id);

        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with ID '" + id + "' not found");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("addNewRecord")
    public ResponseEntity<CustomerDetailResponse> addCustomer(@RequestBody CustomerDetailRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCustomer(request));
    }
}
