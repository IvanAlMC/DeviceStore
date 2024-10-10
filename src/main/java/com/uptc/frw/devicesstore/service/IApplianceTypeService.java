package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.ApplianceType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IApplianceTypeService {
    @Transactional(readOnly = true)
    ApplianceType findApplianceTypeById(int id);

    @Transactional(readOnly = true)
    List<ApplianceType> findAllApplianceTypes();

    @Transactional
    void createApplianceType(ApplianceType applianceType);

    @Transactional
    void deleteApplianceType(int id);
}
