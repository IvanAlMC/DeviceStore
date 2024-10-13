package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;

@Entity
public class DetailComponent {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  ElectronicDevice.class)
    @JoinColumn(name = "DEVICE_ID")
    private ElectronicDevice electronicDevice;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  Factory.class)
    @JoinColumn(name = "FACTORY_ID")
    private Factory factory;
}
