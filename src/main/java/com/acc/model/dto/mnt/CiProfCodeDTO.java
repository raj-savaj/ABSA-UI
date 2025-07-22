package com.acc.model.dto.mnt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiProfCodeDTO {

    private String txtProfessCat;
    private String txtProfession;
    private int ctrUpdatSrlno;
    private String message;

    public CiProfCodeDTO(String txtProfessCat, String txtProfession, int ctrUpdatSrlno, String message) {
        this.txtProfessCat = txtProfessCat;
        this.txtProfession = txtProfession;
        this.ctrUpdatSrlno = ctrUpdatSrlno;
        this.message = message;
    }
}
