package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Enabled
@Table(name = "COMPONENTS_CHANGE")
public class ComponentChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHANGE_ID")
    private int id;
    @Column(name = "REPAIR_ID", insertable = false, updatable = false)
    private int repairId;
    @Column(name = "COMPONENT_ID", insertable = false, updatable = false)
    private int componentId;
    @Column(name = "COMPONENTS_QUANTITY")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Repair.class)
    @JoinColumn(name = "REPAIR_ID")
    private Repair repair;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Component.class)
    @JoinColumn(name = "COMPONENT_ID")
    private Component component;

}
