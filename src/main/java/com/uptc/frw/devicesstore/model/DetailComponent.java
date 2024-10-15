package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DETAILS_COMPONENTS")
public class DetailComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAILS_ID")
    private int id;
    @Column(name = "COMPONENT_ID", insertable = false, updatable = false)
    private int componentId;
    @Column(name = "DEVICE_ID", insertable = false, updatable = false)
    private int deviceId;
    @Column(name = "FACTORY_ID", insertable = false, updatable = false)
    private int factoryId;
    @Column(name = "COMPONENT_QUANTITY")
    private int quantity;
    @Column(name = "COMPONENT_PRICE")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  Component.class)
    @JoinColumn(name = "COMPONENT_ID")
    private Component component;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  ElectronicDevice.class)
    @JoinColumn(name = "DEVICE_ID")
    private ElectronicDevice electronicDevice;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity =  Factory.class)
    @JoinColumn(name = "FACTORY_ID")
    private Factory factory;
}
