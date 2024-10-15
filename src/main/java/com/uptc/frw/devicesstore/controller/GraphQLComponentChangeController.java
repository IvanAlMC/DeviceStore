package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.model.ComponentChange;
import com.uptc.frw.devicesstore.service.implementation.ComponentChangeService;
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


    @QueryMapping(name = "findComponentChangeById")
    public ComponentChange findComponentChangeById(@Argument(name = "componentChangeId") String id) {
        return componentChangeService.findComponentChangeById(Integer.parseInt(id));
    }

    @QueryMapping(name = "findAllComponentChanges")
    public List<ComponentChange> findAllComponentChanges() {
        return componentChangeService.findAllComponentChanges();
    }
    //To do
    @MutationMapping(name = "createComponentChange")
    public ComponentChange createComponentChange(@Argument(name = "componentChange") ComponentChange componentChange) {
        if(componentChange != null) {
            ComponentChange newComp = new ComponentChange();
            newComp.setQuantity(componentChange.getQuantity());
            componentChangeService.createComponentChange(newComp);
            return newComp;
        }
        return null;
    }
    @MutationMapping(name = "updateComponentChange")
    public ComponentChange updateComponentChange(@Argument(name = "componentChangeId") String id,@Argument(name = "componentChange") ComponentChange componentChange) {
        if(componentChange != null) {
            ComponentChange newComp = new ComponentChange();
            newComp.setQuantity(componentChange.getQuantity());
            return newComp;
        }
        return null;
    }
    @MutationMapping(name = "deleteComponentChange")
    public String deleteComponentChange(@Argument(name = "componentChangeId") String id) {
        componentChangeService.deleteComponentChange(Integer.parseInt(id));
        return "The component change with id " + id + " was deleted";
    }
}
