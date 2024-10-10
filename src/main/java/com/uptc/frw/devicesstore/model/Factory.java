package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FACTORIES")
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACTORY_ID")
    private int id;
    @Column(name = "FACTORY_RIF")
    private String rif;
    @Column(name = "FACTORY_NAME")
    private String name;
    @Column(name = "FACTORY_TAX_DOM")
    private String taxDomicile;
}
