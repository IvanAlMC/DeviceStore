package com.uptc.frw.devicesstore.graphql;

import lombok.Data;

import java.util.Date;

@Data
public class InputRepair {
    private int id;
    private int idCustomer;
    private int idDevice;
    private String repairDescription;
    private String repairDate;
}
