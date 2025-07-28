package com.acc.controller.mnt;

import com.acc.model.dto.Customer.CustomerImageRequestDTO;
import com.acc.services.CustomerImageService;
import com.acc.soap.customer.image.CustomerImageInquiryResponse;
import com.acc.soap.customer.image.FatalException_Exception;
import com.acc.soap.customer.image.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerImageController {
    @Autowired
    private CustomerImageService service;

    @PostMapping("customerImageInquiry")
    public ResponseEntity<?> findCustomerImage(@RequestBody CustomerImageRequestDTO request){
        try {
            return ResponseEntity.ok().body(service.getCustomerImageRequest(request));
        } catch (FatalException_Exception e) {
            return ResponseEntity.ok().body(e.getFaultInfo());
        }
    }

    @PostMapping("addCustomerImage")
    public ResponseEntity<?> addCustomerImage(@RequestBody CustomerImageRequestDTO request){
        try {
            return ResponseEntity.ok().body(service.addCustomerImage(request));
        } catch (FatalException_Exception e) {
            return ResponseEntity.ok().body(e.getFaultInfo());
        }
    }

    @PostMapping("modifyCustomerImage")
    public ResponseEntity<?> modifyCustomerImage(@RequestBody CustomerImageRequestDTO request){
        try {
            return ResponseEntity.ok().body(service.modifyCustomerImage(request));
        } catch (FatalException_Exception e) {
            return ResponseEntity.ok().body(e.getFaultInfo());
        }
    }


}
