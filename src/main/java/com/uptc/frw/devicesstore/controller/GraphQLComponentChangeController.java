package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.model.Component;
import com.uptc.frw.devicesstore.model.ComponentChange;
import com.uptc.frw.devicesstore.service.implementation.ComponentChangeService;
import com.uptc.frw.devicesstore.service.implementation.ComponentService;
import com.uptc.frw.devicesstore.service.implementation.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLComponentChangeController {
    @Autowired
    private ComponentChangeService componentChangeService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private ComponentService componentService;


    @QueryMapping(name = "findComponentChangeById")
    public ComponentChange findComponentChangeById(@Argument(name = "componentChangeId") String id) {
        return componentChangeService.findComponentChangeById(Integer.parseInt(id));
    }

    @QueryMapping(name = "findAllComponentChanges")
    public List<ComponentChange> findAllComponentChanges() {
        return componentChangeService.findAllComponentChanges();
    }
    @MutationMapping(name = "createComponentChange")
    public ComponentChange createComponentChange(@Argument(name = "inputComponentChange") ComponentChange componentChange) {
        ComponentChange newComp = null;
        if(componentChange != null) {
            newComp = new ComponentChange();
            newComp.setId(componentChange.getId());
            newComp.setComponent(componentService.findComponentById(componentChange.getComponentId()));
            newComp.setComponentId(componentChange.getComponentId());
            newComp.setRepair(repairService.findRepairById(componentChange.getRepairId()));
            newComp.setRepairId(componentChange.getRepairId());
            newComp.setQuantity(componentChange.getQuantity());
            componentChangeService.createComponentChange(newComp);
        }
        return newComp;
    }
    @MutationMapping(name = "updateComponentChange")
    public ComponentChange updateComponentChange(@Argument(name = "componentChangeId") String id,@Argument(name = "inputComponentChange") ComponentChange componentChange) {
        ComponentChange newComp = null;
        if(componentChange != null) {
            newComp = componentChangeService.findComponentChangeById(Integer.parseInt(id));
            newComp.setComponentId(componentChange.getComponentId());
            newComp.setComponent(componentService.findComponentById(componentChange.getComponentId()));
            newComp.setRepairId(componentChange.getRepairId());
            newComp.setRepair(repairService.findRepairById(componentChange.getRepairId()));
            newComp.setQuantity(componentChange.getQuantity());
            componentChangeService.createComponentChange(newComp);
        }
        return newComp;
    }
    @MutationMapping(name = "deleteComponentChange")
    public String deleteComponentChange(@Argument(name = "componentChangeId") String id) {
        componentChangeService.deleteComponentChange(Integer.parseInt(id));
        return "The component change with ID " + id + " was deleted";
    }
}
