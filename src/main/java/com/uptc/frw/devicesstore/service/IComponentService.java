package com.uptc.frw.devicesstore.service;
import com.uptc.frw.devicesstore.model.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IComponentService {
    @Transactional(readOnly = true)
    Component findComponentById(int id);

    @Transactional(readOnly = true)
    List<Component> findAllComponents();

    @Transactional
    void createComponent(Component component);

    @Transactional
    void deleteComponent(int id);

}
