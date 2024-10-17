package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.Repair;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRepairService {
    @Transactional(readOnly = true)
    Repair findRepairById(int id);

    @Transactional(readOnly = true)
    List<Repair> findAllRepairs();

    @Transactional
    void createRepair(Repair repair);

    @Transactional
    void deleteRepair(int id);
}
