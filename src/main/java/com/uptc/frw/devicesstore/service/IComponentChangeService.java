package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.ComponentChange;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IComponentChangeService {
    @Transactional(readOnly = true)
    ComponentChange findComponentChangeById(int id);

    @Transactional(readOnly = true)
    List<ComponentChange> findAllComponentChanges();

    @Transactional
    void createComponentChange(ComponentChange componentChange);

    @Transactional
    void deleteComponentChange(int id);
}
