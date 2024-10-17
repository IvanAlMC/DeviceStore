package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.Factory;
import com.uptc.frw.devicesstore.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FactoryService implements com.uptc.frw.devicesstore.service.IFactoryService {
    @Autowired
    private FactoryRepository factoryRepository;

    @Transactional(readOnly = true)
    @Override
    public Factory findFactoryById(int id) {

        return factoryRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Factory> findAllFactories() {
        return (List<Factory>) factoryRepository.findAll();
    }

    @Transactional
    @Override
    public void createFactory(Factory factory) {
        factoryRepository.save(factory);
    }

    @Transactional
    @Override
    public void deleteFactory(int id) {
        factoryRepository.deleteById(findFactoryById(id).getId());
    }
}
