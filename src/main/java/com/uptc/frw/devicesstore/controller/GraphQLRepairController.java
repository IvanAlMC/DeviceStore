package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputRepair;
import com.uptc.frw.devicesstore.model.Customer;
import com.uptc.frw.devicesstore.model.ElectronicDevice;
import com.uptc.frw.devicesstore.model.Repair;
import com.uptc.frw.devicesstore.service.IRepairService;
import com.uptc.frw.devicesstore.service.implementation.CustomerService;
import com.uptc.frw.devicesstore.service.implementation.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class GraphQLRepairController {

    @Autowired
    private IRepairService repairService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;

    @QueryMapping(name = "findRepairById")
    public Repair findRepairById(@Argument(name = "repairId") String repairId) {
        int repairIdInt = Integer.parseInt(repairId);
        return repairService.findRepairById(repairIdInt);
    }

    @QueryMapping(name = "findAllRepairs")
    public List<Repair> findAllRepairs() {
        return repairService.findAllRepairs();
    }

    @MutationMapping(name = "createRepair")
    public Repair createRepair(@Argument(name = "inputRepair") InputRepair inputRepair) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(inputRepair.getRepairDate());
        Customer customer = customerService.findCustomerById(inputRepair.getIdCustomer());
        ElectronicDevice electronicDevice = electronicDeviceService.findElectronicDeviceById(inputRepair.getIdDevice());

        Repair repair = new Repair();
        repair.setRepairDate(date);
        repair.setRepairDescription(inputRepair.getRepairDescription());
        repair.setCustomer(customer);
        repair.setElectronicDevice(electronicDevice);
        repairService.createRepair(repair);
        return repair;
    }

    @MutationMapping(name = "deleteRepairId")
    public String deleteRepairId(@Argument(name = "repairId") String repairId) {
        if (repairId == null||repairId.isBlank()) {
            return "Repair ID is required.";
        }
        int repairIdInt = Integer.parseInt(repairId);
        repairService.deleteRepair(repairIdInt);
        return "Repair ID with ID" + repairIdInt + " was successfully deleted";
    }

    @MutationMapping(name = "updateRepair")
    public Repair updateRepair(@Argument(name = "inputRepair") InputRepair inputRepair, @Argument(name = "repairId") String repairId) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatter.parse(inputRepair.getRepairDate());

        if (repairId == null||repairId.isBlank()) {
            return null;
        }
        int repairIdInt = Integer.parseInt(repairId);
        Repair repair = repairService.findRepairById(repairIdInt);
        if(repair == null){
            return null;
        }
        Customer customer = customerService.findCustomerById(inputRepair.getIdCustomer());
        ElectronicDevice electronicDevice = electronicDeviceService.findElectronicDeviceById(inputRepair.getIdDevice());
        if (customer == null || electronicDevice == null) {
            return null;  // Si alguno de los dos no existe, no se actualiza la reparación
        }
        repair.setRepairDate(date);
        repair.setRepairDescription(inputRepair.getRepairDescription());
        repair.setCustomer(customer);
        repair.setElectronicDevice(electronicDevice);
        repairService.createRepair(repair);
        return repair;
    }
}

