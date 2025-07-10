package com.acc.controller.mnt;

import com.acc.entity.CiCustMemo;
import com.acc.services.MemoManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memos")
@Slf4j
public class CiCustMemoController {

    @Autowired
    private MemoManagerService service;

    // Fetch active memos for a customer
    @GetMapping("/getMemoDetails/{custId}")
    public ResponseEntity<List<CiCustMemo>> getActiveMemos(@PathVariable Long custId) {
        List<CiCustMemo> memos = service.getActiveMemos(custId);
        if (memos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(memos);
    }

    // Add a new memo
    @PostMapping("/addMemoDetails")
    public ResponseEntity<CiCustMemo> addMemo(@RequestBody CiCustMemo memo) {
        CiCustMemo savedMemo = service.addMemo(memo);
        return ResponseEntity.ok(savedMemo);
    }

    // Update an existing memo
    @PutMapping("/modifyMemoDetails/{custId}/{srlNo}")
    public ResponseEntity<String> updateMemo(
            @PathVariable Long custId,
            @PathVariable Long srlNo,
            @RequestParam String memoText,
            @RequestParam String severity,
            @RequestParam Integer reason) {

        int updated = service.updateMemo(custId, srlNo, memoText, severity, reason);
        if (updated > 0) {
            return ResponseEntity.ok("Memo updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a memo
    @DeleteMapping("/deleteMemoDetails/{custId}/{srlNo}")
    public ResponseEntity<String> deleteMemo(@PathVariable Long custId, @PathVariable Long srlNo) {
        int deleted = service.deleteMemo(custId, srlNo);
        if (deleted > 0) {
            return ResponseEntity.ok("Memo deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}