package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "REPAIRS")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPAIR_ID")
    private int id;
    @Column(name = "CUSTOMER_ID")
    private int idCustomer;
    @Column(name = "DEVICE_ID")
    private int idDevice;
    @Column(name = "REPAIR_DESCRIPTION")
    private String repairDescription;
    @Column(name = "REPAIR_DATE")
    private Date repairDate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Repair.class)
    @JoinColumn(name = "DEVICE_ID")
    private ElectronicDevice electronicDevice;

}
