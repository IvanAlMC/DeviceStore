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

    @Override
    @Transactional(readOnly = true)
    public ComponentChange findComponentChangeById(int componentId) {
        return componentChangeRepository.findById(componentId).orElseThrow();
    }
    @Override
    @Transactional(readOnly = true)
    public List<ComponentChange> findAllComponentChanges() {
        return (List<ComponentChange>)componentChangeRepository.findAll();
    }
    @Override
    @Transactional
    public void createComponentChange(ComponentChange componentChange) {
        componentChangeRepository.save(componentChange);
    }
    @Override
    @Transactional
    public void deleteComponentChange(int componentId) {
        componentChangeRepository.deleteById(findComponentChangeById(componentId).getId());
    }
}

