package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.Repair;
import com.uptc.frw.devicesstore.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepairService implements com.uptc.frw.devicesstore.service.IRepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Transactional(readOnly = true)
    @Override
    public Repair findRepairById(int id) {
        return repairRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Repair> findAllRepairs() {
        return (List<Repair>) repairRepository.findAll();
    }

    @Transactional
    @Override
    public void createRepair(Repair repair) {
        repairRepository.save(repair);
    }

    @Transactional
    @Override
    public void deleteRepair(int id) {
        repairRepository.deleteById(id);
    }
}
