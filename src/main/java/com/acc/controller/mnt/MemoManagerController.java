package com.acc.controller.mnt;

import com.acc.model.dto.memo.*;
import com.acc.services.MemoManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class MemoManagerController {

    @Autowired
    private MemoManagerService memoManagerService;

    @PostMapping("findCustomerId")
    public List<CustomerSearchResponseDTO> findCustomerId(@RequestBody CustomerSearchRequestDTO customerSearchRequestDTO){
        return memoManagerService.findCustomerIds(customerSearchRequestDTO);
    }

    @PostMapping("findCustomerMemo")
    public List<Long> getCustomerMemos(@RequestBody CustomerMemoRequest request) {
        return memoManagerService.getMemos(request);
    }

    @PostMapping("getMemoDetails")
    public MemoDetailsResponseDTO getMemoDetails(@RequestBody MemoDetailsRequest request) {
        return memoManagerService.getMemoDetails(request);
    }

}
