package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputComponent;
import com.uptc.frw.devicesstore.model.Component;
import com.uptc.frw.devicesstore.service.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLComponentController {


    @Autowired
    private IComponentService componentService;

    @QueryMapping(name = "findComponentById")
    public Component findComponentById(@Argument(name = "componentId") String componentId) {
        int componentIdInt = Integer.parseInt(componentId);
        return componentService.findComponentById(componentIdInt);
    }

    @QueryMapping(name = "findAllComponents")
    public List<Component> findAllComponents() {
        return componentService.findAllComponents();
    }

    @QueryMapping(name = "createComponent")
    public Component createComponent(@Argument(name = "inputComponent") InputComponent inputComponent) {
        Component component = new Component();
        component.setNameComponent(inputComponent.getNameComponent());
        component.setSpecsComponent(inputComponent.getSpecsComponent());
        componentService.createComponent(component);
        return component;
    }

    @MutationMapping(name = "deleteComponentById")
    public String deleteComponentById(@Argument(name = "componentId") String componentId) {
        if (componentId == null || componentId.isBlank()) {
            return "Component ID is required";
        }
        int componentIdInt = Integer.parseInt(componentId);
        componentService.deleteComponent(componentIdInt);
        return "The component with ID"+ componentIdInt + " was deleted";
    }

    @MutationMapping(name = "updateComponent")
    public Component updateComponent(@Argument(name = "componentId") String componentId, @Argument(name = "inputComponent") InputComponent inputComponent) {
        if (componentId == null || componentId.isBlank()) {
            return null;
        }
        int componentIdInt = Integer.parseInt(componentId);
        Component component = componentService.findComponentById(componentIdInt);
        if (component == null) {
            return null;
        }

        component.setNameComponent(inputComponent.getNameComponent());
        component.setSpecsComponent(inputComponent.getSpecsComponent());

        componentService.createComponent(component);
        return component;
    }
}
