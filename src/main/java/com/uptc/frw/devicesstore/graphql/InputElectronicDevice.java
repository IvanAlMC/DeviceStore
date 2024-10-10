package com.uptc.frw.devicesstore.graphql;

import lombok.Data;

@Data
public class InputElectronicDevice {

    private int id;
    private int idType;
    private String name;
    private String description;

}
