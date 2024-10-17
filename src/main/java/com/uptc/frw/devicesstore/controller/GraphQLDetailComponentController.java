package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.model.DetailComponent;
import com.uptc.frw.devicesstore.service.implementation.ComponentService;
import com.uptc.frw.devicesstore.service.implementation.DetailComponentService;
import com.uptc.frw.devicesstore.service.implementation.ElectronicDeviceService;
import com.uptc.frw.devicesstore.service.implementation.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLDetailComponentController {
    @Autowired
    private DetailComponentService detailComponentService;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private ComponentService componentService;

    @QueryMapping(name = "findDetailComponentById")
    public DetailComponent findDetailComponentById(@Argument(name = "detailComponentId") String id){
        return detailComponentService.findDetailComponentById(Integer.parseInt(id));
    }
    @QueryMapping(name = "findAllDetailComponent")
    public List<DetailComponent> findAllDetailComponent(){
        return detailComponentService.findAllDetailComponent();
    }
    @MutationMapping(name = "createDetailComponent")
    public DetailComponent createDetailComponent(@Argument(name = "detailComponent") DetailComponent detailComponent){
        DetailComponent newDC = null;
        if (detailComponent != null){
            newDC = new DetailComponent();
            newDC.setId(detailComponent.getId());
            newDC.setComponentId(detailComponent.getComponentId());
            newDC.setComponent(componentService.findComponentById(detailComponent.getComponentId()));
            newDC.setDeviceId(detailComponent.getDeviceId());
            newDC.setElectronicDevice(electronicDeviceService.findElectronicDeviceById(detailComponent.getDeviceId()));
            newDC.setFactoryId(detailComponent.getFactoryId());
            newDC.setFactory(factoryService.findFactoryById(detailComponent.getFactoryId()));
            newDC.setQuantity(detailComponent.getQuantity());
            newDC.setPrice(detailComponent.getPrice());
            detailComponentService.createDetailComponent(newDC);
        }
        return newDC;
    }
    @MutationMapping(name = "updateDetailComponent")
    public DetailComponent updateDetailComponent(@Argument(name = "detailComponentId") String id,@Argument(name = "detailComponent") DetailComponent detailComponent){
        DetailComponent newDC = null;
        if (detailComponent != null){
            newDC = detailComponentService.findDetailComponentById(Integer.parseInt(id));
            newDC.setComponent(componentService.findComponentById(detailComponent.getComponentId()));
            newDC.setComponentId(detailComponent.getComponentId());
            newDC.setElectronicDevice(electronicDeviceService.findElectronicDeviceById(detailComponent.getDeviceId()));
            newDC.setDeviceId(detailComponent.getDeviceId());
            newDC.setFactoryId(detailComponent.getFactoryId());
            newDC.setFactory(factoryService.findFactoryById(detailComponent.getFactoryId()));
            newDC.setQuantity(detailComponent.getQuantity());
            newDC.setPrice(detailComponent.getPrice());
            detailComponentService.createDetailComponent(newDC);
        }
        return newDC;
    }
    @MutationMapping(name = "deleteDetailComponent")
    public String deleteDetailComponent(@Argument(name = "detailComponentId") String id){
        detailComponentService.deleteDetailComponent(Integer.parseInt(id));
        return "The detail component with id " + id + "has been deleted";
    }
}
