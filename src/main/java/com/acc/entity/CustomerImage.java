package com.acc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CS_HO_CUST_IMAGEMAST")
public class CustomerImage {

    @Id
    @Column(name = "cod_cust_id")
    private long customerID;

    @Column(name = "cust_image")
    private String customerImage;

    @Column(name = "cod_image_type")
    private String imageType;
}
