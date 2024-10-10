package com.uptc.frw.devicesstore.graphql;

import lombok.Data;

@Data
public class InputApplianceType {

    private int id;
    private int idSupType;
    private String name;
    private String characteristic;

}
