package com.uptc.frw.devicesstore.graphql;

import lombok.Data;

@Data
public class InputCustomer {
    private int id;
    private String nameCustomer;
    private String codeDocument;
    private String address;
    private String phone;
    private String email;
}
