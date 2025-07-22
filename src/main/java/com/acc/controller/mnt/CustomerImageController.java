package com.acc.controller.mnt;

import com.acc.model.dto.Customer.CustomerImageRequestDTO;
import com.acc.services.CustomerImageService;
import com.acc.soap.CustomerImageInquiryResponse;
import com.acc.soap.FatalException_Exception;
import com.acc.soap.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CustomerImageInquiryResponse findCustomerImage(@RequestBody CustomerImageRequestDTO request){
        try {
            return service.getCustomerImageRequest(request);
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("addCustomerImage")
    public TransactionResponse addCustomerImage(@RequestBody CustomerImageRequestDTO request){
        try {
            return service.addCustomerImage(request);
        } catch (FatalException_Exception e) {
            throw new RuntimeException(e);
        }
    }
}
