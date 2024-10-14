package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPONENTS" )
public class Component {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPONENT_ID")
    private int id;
    @Column(name = "COMPONENT_NAME")
    private String nameComponent;
    @Column(name = "COMPONENT_SPECS")
    private String specsComponent;



}
