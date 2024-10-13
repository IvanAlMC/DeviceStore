package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ELECTRONIC_DEVICES")
public class ElectronicDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_ID")
    private int id;
    @Column(name = "TYPE_ID", insertable = false, updatable = false)
    private int idType;
    @Column(name = "DEVICE_NAME")
    private String name;
    @Column(name = "DEVICE_DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  ApplianceType.class)
    @JoinColumn(name = "TYPE_ID")
    private ApplianceType applianceType;

    @OneToMany(mappedBy = "electronicDevice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = DetailComponent.class)
    private List<DetailComponent> details;
}
