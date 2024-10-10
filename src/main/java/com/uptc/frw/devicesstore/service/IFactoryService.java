package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.Factory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IFactoryService {
    @Transactional(readOnly = true)
    Factory findFactoryById(int id);

    @Transactional(readOnly = true)
    List<Factory> findAllFactories();

    @Transactional
    void createFactory(Factory factory);

    @Transactional
    void deleteFactory(int id);
}
