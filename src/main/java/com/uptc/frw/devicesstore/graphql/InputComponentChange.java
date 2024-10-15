package com.uptc.frw.devicesstore.graphql;

import lombok.Data;

@Data
public class InputComponentChange {
    private int id;
    private int repairId;
    private int componentId;
    private int quantity;
}
