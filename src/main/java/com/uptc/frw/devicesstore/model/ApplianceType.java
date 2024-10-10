package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "appliance_types")
public class ApplianceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private int id;

    @Column(name = "SUP_TYPE_ID", insertable = false, updatable = false)
    private Integer supTypeid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUP_TYPE_ID") // Esto manejará el ID del supertipo en la base de datos
    private ApplianceType superType;

    @OneToMany(mappedBy = "superType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ApplianceType> subTypes;


    @Column(name = "TYPE_NAME")
    private String name;
    @Column(name = "TYPE_CHARACTERISTICS")
    private String characteristic;

    @OneToMany(mappedBy = "applianceType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ElectronicDevice.class)
    private List<ElectronicDevice> devices;
}
