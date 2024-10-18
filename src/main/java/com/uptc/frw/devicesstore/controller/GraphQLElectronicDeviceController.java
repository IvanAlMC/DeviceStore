package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputElectronicDevice;
import com.uptc.frw.devicesstore.model.ApplianceType;
import com.uptc.frw.devicesstore.model.ElectronicDevice;
import com.uptc.frw.devicesstore.service.IElectronicDeviceService;
import com.uptc.frw.devicesstore.service.implementation.ApplianceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class GraphQLElectronicDeviceController {

    @Autowired
    private IElectronicDeviceService electronicDeviceService;
    @Autowired
    private ApplianceTypeService applianceTypeService;

    @QueryMapping(name = "findElectronicDeviceById")
    public ElectronicDevice findElectronicDeviceById(@Argument(name = "electronicDeviceId") String id) {
        int electronicDeviceId = Integer.parseInt(id);
        return electronicDeviceService.findElectronicDeviceById(electronicDeviceId);
    }

    @QueryMapping(name = "findAllElectronicDevices")
    public List<ElectronicDevice> findAllElectronicDevices() {
        return electronicDeviceService.findAllElectronicDevices();
    }

    @MutationMapping(name = "createElectronicDevice")
    public ElectronicDevice createElectronicDevice(@Argument(name = "inputElectronicDevice")InputElectronicDevice inputElectronicDevice) {

        ApplianceType type = applianceTypeService.findApplianceTypeById(inputElectronicDevice.getIdType());
        ElectronicDevice electronicDevice = new ElectronicDevice();
        electronicDevice.setApplianceType(type);
        electronicDevice.setName(inputElectronicDevice.getName());
        electronicDevice.setDescription(inputElectronicDevice.getDescription());
        electronicDeviceService.createElectronicDevice(electronicDevice);

        return electronicDevice;
    }

    @MutationMapping(name = "deleteElectronicDeviceById")
    public String deleteElectronicDeviceByID(@Argument(name = "electronicDeviceId") String id) {
        try {
            electronicDeviceService.deleteElectronicDevice(Integer.parseInt(id));
            return "The electronic device with ID " + id + " was deleted";
        }catch (Exception e) {
            return "Error while deleting component";
        }
    }


    @MutationMapping(name = "updateElectronicDevice")
    public ElectronicDevice updateElecronicDevice(@Argument(name = "electronicDeviceId") String id, @Argument(name = "inputElectronicDevice") InputElectronicDevice inputElectronicDevice) {

        ApplianceType type = applianceTypeService.findApplianceTypeById(inputElectronicDevice.getIdType());
        ElectronicDevice electronicDevice = electronicDeviceService.findElectronicDeviceById(Integer.parseInt(id));
        electronicDevice.setApplianceType(type);
        electronicDevice.setName(inputElectronicDevice.getName());
        electronicDevice.setDescription(inputElectronicDevice.getDescription());

        electronicDeviceService.createElectronicDevice(electronicDevice);

        return electronicDevice;
    }
}
