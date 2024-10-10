package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.ElectronicDevice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IElectronicDeviceService {
    @Transactional(readOnly = true)
    ElectronicDevice findElectronicDeviceById(int id);

    @Transactional(readOnly = true)
    List<ElectronicDevice> findAllElectronicDevices();

    @Transactional
    void createElectronicDevice(ElectronicDevice electronicDevice);

    @Transactional
    void deleteElectronicDevice(int id);
}
