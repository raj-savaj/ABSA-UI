package com.acc.controller.mnt;

import com.acc.model.dto.mnt.CiProfCodeDTO;
import com.acc.services.ProfessionalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfessionalCodeController {

    @Autowired
    private ProfessionalCodeService codeService;

    // Get active profession details by category
    @GetMapping("/getDetails/{cat}")
    public ResponseEntity<CiProfCodeDTO> get(@PathVariable Long cat) {
        try {
            CiProfCodeDTO dto = codeService.getRecord(cat);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    // Add new profession
    @PostMapping("/addDetails")
    public ResponseEntity<?> add(@RequestBody CiProfCodeDTO dto) {
        try {
            CiProfCodeDTO created = codeService.addRecord(dto, "makerId", "checkerId");
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Record Already Exists");
        }
    }

    // Modify profession
    @PutMapping("/modifyDetails")
    public ResponseEntity<?> modify(@RequestBody CiProfCodeDTO dto) {
        try {
            CiProfCodeDTO updated = codeService.updateRecord(dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Update failed or stale data");
        }
    }

    // Delete profession
    @DeleteMapping("/deleteDetails")
    public ResponseEntity<String> delete(@RequestParam String cat, @RequestParam int srlno) {
        try {
            String msg = codeService.deleteRecord(cat, srlno);
            return ResponseEntity.ok(msg);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
