package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.ApplianceType;
import com.uptc.frw.devicesstore.repository.ApplianceTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplianceTypeService implements com.uptc.frw.devicesstore.service.IApplianceTypeService {
    @Autowired
    private ApplianceTypeRepository applianceTypeRepository;

    @Transactional(readOnly = true)
    @Override
    public ApplianceType findApplianceTypeById(int id) {
        return applianceTypeRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ApplianceType> findAllApplianceTypes() {
        return (List<ApplianceType>) applianceTypeRepository.findAll();
    }

    @Transactional
    @Override
    public void createApplianceType(ApplianceType applianceType) {
        applianceTypeRepository.save(applianceType);
    }

    @Transactional
    @Override
    public void deleteApplianceType(int id) {
        applianceTypeRepository.deleteById(findApplianceTypeById(id).getId());
    }
}
