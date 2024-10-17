package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "component",fetch = FetchType.LAZY, cascade = CascadeType.ALL,targetEntity = ComponentChange.class)
    private List<ComponentChange> componentsChanges;

    @OneToMany(mappedBy = "component", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = DetailComponent.class)
    private List<DetailComponent> details;

}
