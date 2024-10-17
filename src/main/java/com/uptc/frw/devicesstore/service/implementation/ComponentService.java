package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.Component;
import com.uptc.frw.devicesstore.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComponentService implements com.uptc.frw.devicesstore.service.IComponentService{
    @Autowired
    private ComponentRepository componentRepository;

    @Transactional(readOnly = true)
    @Override
    public Component findComponentById(int id) {
        return componentRepository.findById(id).orElseThrow();

    }

    @Transactional(readOnly = true)
    @Override
    public List<Component> findAllComponents() {
        return (List<Component>) componentRepository.findAll();
    }

    @Transactional
    @Override
    public void createComponent(Component component) {
        componentRepository.save(component);
    }

    @Transactional
    @Override
    public void deleteComponent(int id) {
        componentRepository.deleteById(findComponentById(id).getId());
    }
}
