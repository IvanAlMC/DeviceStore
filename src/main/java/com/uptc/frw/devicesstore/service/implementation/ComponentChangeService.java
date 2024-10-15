package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.ComponentChange;
import com.uptc.frw.devicesstore.repository.ComponentChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComponentChangeService implements com.uptc.frw.devicesstore.service.IComponentChangeService {

    @Autowired
    private ComponentChangeRepository componentChangeRepository;

    @Transactional(readOnly = true)
    @Override
    public ComponentChange findComponentChangeById(int componentId) {
        return componentChangeRepository.findById(componentId).orElseThrow();
    }
    @Transactional(readOnly = true)
    @Override
    public List<ComponentChange> findAllComponentChanges() {
        return (List<ComponentChange>)componentChangeRepository.findAll();
    }
    @Transactional
    @Override
    public void createComponentChange(ComponentChange componentChange) {
        componentChangeRepository.save(componentChange);
    }
    @Transactional
    @Override
    public void deleteComponentChange(int componentId) {
        componentChangeRepository.deleteById(componentId);
    }
}

