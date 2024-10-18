package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputApplianceType;
import com.uptc.frw.devicesstore.model.ApplianceType;
import com.uptc.frw.devicesstore.service.implementation.ApplianceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLApplianceTypeController {


    @Autowired
    private ApplianceTypeService applianceTypeService;

    @QueryMapping(name = "findApplianceTypeById")
    public ApplianceType findApplianceTypeById(@Argument(name = "applianceTypeId") String id) {
        int applianceTypeId = Integer.parseInt(id);
        return applianceTypeService.findApplianceTypeById(applianceTypeId);
    }

    @QueryMapping(name = "findAllApplianceTypes")
    public List<ApplianceType> findAllApplainceTypes() {
        return applianceTypeService.findAllApplianceTypes();
    }

    @MutationMapping(name = "createApplianceType")
    public ApplianceType createApplianceType(@Argument(name = "inputApplianceType") InputApplianceType inputApplianceType) {

        ApplianceType type = new ApplianceType();
        if(inputApplianceType.getIdSupType()!=0){
            ApplianceType superType = applianceTypeService.findApplianceTypeById(inputApplianceType.getIdSupType());
            type.setSuperType(superType);
        }
        type.setName(inputApplianceType.getName());
        type.setCharacteristic(inputApplianceType.getCharacteristic());
        applianceTypeService.createApplianceType(type);
        return type;

    }

    @MutationMapping(name = "deleteApplianceTypeById")
    public String deleteApplianceTypeByID(@Argument(name = "applianceTypeId") String id) {
        try {
            applianceTypeService.deleteApplianceType(Integer.parseInt(id));
            return "The appliance type with ID " + id + ", was deleted";
        }catch (Exception e){
            return "Error while deleting component";
        }
    }


    @MutationMapping(name = "updateApplianceType")
    public ApplianceType updateApplianceTyoe(@Argument(name = "applianceTypeId") String id, @Argument(name = "inputApplianceType") InputApplianceType inputApplianceType) {

        ApplianceType type = applianceTypeService.findApplianceTypeById(Integer.parseInt(id));
        if(inputApplianceType.getIdSupType()!=0) {
            ApplianceType superType = applianceTypeService.findApplianceTypeById(inputApplianceType.getIdSupType());
            type.setSuperType(superType);
        }
        type.setName(inputApplianceType.getName());
        type.setCharacteristic(inputApplianceType.getCharacteristic());
        applianceTypeService.createApplianceType(type);

        return type;
    }
}
