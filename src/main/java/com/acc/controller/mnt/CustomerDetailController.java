package com.acc.controller.mnt;

import com.acc.model.dto.Customer.CustomerDetailRequest;
import com.acc.model.dto.Customer.CustomerDetailResponse;
import com.acc.services.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerDetailController {

    @Autowired
    private CustomerDetailService custService;

    @Autowired
    private CustomerDetailService service;

    @GetMapping("inquiry/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Integer id) {
        CustomerDetailResponse response = service.getCustomerById(id);

        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer with ID '" + id + "' not found");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("addNewRecord")
    public ResponseEntity<Map<String, String>> addCustomer(@RequestBody CustomerDetailRequest request) {
        boolean added = service.addCustomer(request);

        Map<String, String> response = new HashMap<>();
        if (!added) {
            response.put("code", "409");
            response.put("message", "Customer " + request.getCustomerId() + " already exists");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        response.put("code", "201");
        response.put("message", "Customer " + request.getCustomerId() + " added successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("updateCustomer")
    public ResponseEntity<Map<String, String>> updateCustomer(@RequestBody CustomerDetailRequest request) {
        boolean updated = service.updateCustomer(request);
        Map<String, String> response = new HashMap<>();

        if (updated) {
            response.put("code", "200");
            response.put("message", "Customer updated successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "404");
            response.put("message", "Customer not found or inactive");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("deleteCustomer/{id}")
    public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable("id") Integer customerId) {
        boolean deleted = service.deleteCustomer(customerId);
        Map<String, String> response = new HashMap<>();

        if (deleted) {
            response.put("code", "200");
            response.put("message", "Customer deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "404");
            response.put("message", "Customer not found or already deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
