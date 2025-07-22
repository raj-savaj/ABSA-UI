package com.acc.services;

import com.acc.entity.CiProfCode;
import com.acc.model.dto.mnt.CiProfCodeDTO;
import com.acc.repository.ProfessionalCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProfessionalCodeService {

    @Autowired
    private ProfessionalCodeRepository repo;

    public CiProfCodeDTO getRecord(Long cat) {
        Optional<CiProfCode> result = repo.findActiveByTxtProfessCat(cat);

        System.out.print("************");

        if (result.isPresent()) {
            CiProfCode view = result.get();
            return new CiProfCodeDTO(
                    view.getTxtProfessCat(),
                    view.getTxtProfession(),
                    view.getCtrUpdatSrlno(),
                    "Record found"
            );
        } else {
            throw new RuntimeException("Record not found");
        }
    }

    public CiProfCodeDTO addRecord(CiProfCodeDTO dto, String makerId, String checkerId) {
        if (repo.existsByTxtProfessCatAndFlgMntStatus(dto.getTxtProfessCat(), "A")) {
            throw new RuntimeException("Record Already Exists");
        }

        CiProfCode entity = new CiProfCode();
        entity.setTxtProfessCat(dto.getTxtProfessCat());
        entity.setTxtProfession(dto.getTxtProfession());
        entity.setFlgMntStatus("A");
        entity.setCtrUpdatSrlno(0);
        entity.setCodLastMntMakerid(makerId);
        entity.setCodLastMntChkrid(checkerId);
        entity.setDatLastMnt(LocalDate.now());

        repo.save(entity);

        dto.setCtrUpdatSrlno(0);
        dto.setMessage("Record added");
        return dto;
    }

    public CiProfCodeDTO updateRecord(CiProfCodeDTO dto) {
        int updated = repo.updateProfession(dto.getTxtProfession(), dto.getTxtProfessCat(), dto.getCtrUpdatSrlno());
        if (updated == 0) {
            throw new RuntimeException("Update failed or stale data");
        }

        dto.setCtrUpdatSrlno(dto.getCtrUpdatSrlno() + 1);
        dto.setMessage("Record updated");
        return dto;
    }

    public String deleteRecord(String cat, int srlno) {
        int deleted = repo.deleteByCatAndSrl(cat, srlno);
        if (deleted == 0) {
            throw new RuntimeException("Delete failed");
        }
        return "Record deleted successfully";
    }
}
