package com.acc.controller.mnt;

import com.acc.model.dto.Customer.CustomerImageRequestDTO;
import com.acc.repository.CustomerImageRepository;
import com.acc.services.CustomerImageService;
import com.acc.soap.customer.image.CustomerImageInquiryResponse;
import com.acc.soap.customer.image.FatalException_Exception;
import com.acc.soap.customer.image.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerImageController {

    @Autowired
    private CustomerImageService service;

    @Autowired
    private CustomerImageRepository imageRepository;

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
            int existingCount = imageRepository.countByCustomerId(request.getCustomerId());

            if (existingCount > 0) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("message", "Record Already Exists!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse); // Use 409 Conflict for existing record
            }

            TransactionResponse response = service.addCustomerImage(request);
            return ResponseEntity.ok(response);

        } catch (FatalException_Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
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

    @DeleteMapping("deleteCustomerImage")
    public ResponseEntity<?> deleteCustomerImage(@RequestParam String customerId, @RequestParam Long imageType) {
        try {
            boolean deleted = service.deleteCustomerImage(customerId,imageType);
            if (deleted) {
                return ResponseEntity.ok().body(Map.of("message", "Record deleted successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "No matching active record found"));
            }
        } catch (Exception e) {
            log.error("Error deleting customer image: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Failed to delete record"));
        }
    }

}
