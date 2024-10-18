package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputFactory;
import com.uptc.frw.devicesstore.model.Factory;
import com.uptc.frw.devicesstore.service.IFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLFactoryController {

    @Autowired
    private IFactoryService factoryService;

    @QueryMapping(name = "findFactoryById")
    public Factory findFactoryById(@Argument(name = "factoryId") String id) {
        int factoryId = Integer.parseInt(id);
        return factoryService.findFactoryById(factoryId);
    }

    @QueryMapping(name = "findAllFactories")
    public List<Factory> findAllFactories() {
        return factoryService.findAllFactories();
    }

    @MutationMapping(name = "createFactory")
    public Factory createFactory(@Argument(name = "inputFactory") InputFactory inputFactory) {

        Factory factory = new Factory();
        factory.setRif(inputFactory.getRif());
        factory.setName(inputFactory.getName());
        factory.setTaxDomicile(inputFactory.getTaxDomicile());

        factoryService.createFactory(factory);

        return factory;
    }

    @MutationMapping(name = "deleteFactoryById")
    public String deleteFactoryByID(@Argument(name = "factoryId") String id) {
        factoryService.deleteFactory(Integer.parseInt(id));
        return "The factory with ID " + id + " was deleted";
    }


    @MutationMapping(name = "updateFactory")
    public Factory updateFactory(@Argument(name = "factoryId") String id, @Argument(name = "inputFactory") InputFactory inputFactory) {

        Factory factory = factoryService.findFactoryById(Integer.parseInt(id));
        factory.setRif(inputFactory.getRif());
        factory.setName(inputFactory.getTaxDomicile());
        factory.setTaxDomicile(inputFactory.getTaxDomicile());
        factoryService.createFactory(factory);

        return factory;
    }
}
