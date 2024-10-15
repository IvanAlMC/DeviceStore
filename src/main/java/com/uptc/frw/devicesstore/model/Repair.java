package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "REPAIRS")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPAIR_ID")
    private int id;
    @Column(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private int idCustomer;
    @Column(name = "DEVICE_ID", insertable = false, updatable = false)
    private int idDevice;
    @Column(name = "REPAIR_DESCRIPTION")
    private String repairDescription;
    @Column(name = "REPAIR_DATE")
    private Date repairDate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ElectronicDevice.class)
    @JoinColumn(name = "DEVICE_ID")
    private ElectronicDevice electronicDevice;

    @OneToMany(mappedBy = "repair",fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = ComponentChange.class)
    private List<ComponentChange> componentsChanges;

}
