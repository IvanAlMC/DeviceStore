package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.ElectronicDevice;
import com.uptc.frw.devicesstore.repository.ElectronicDevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElectronicDeviceService implements com.uptc.frw.devicesstore.service.IElectronicDeviceService {

    @Autowired
    private ElectronicDevicesRepository electronicDeviceRepository;

    @Transactional(readOnly = true)
    @Override
    public ElectronicDevice findElectronicDeviceById(int id) {
        return electronicDeviceRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ElectronicDevice> findAllElectronicDevices() {
        return (List<ElectronicDevice>) electronicDeviceRepository.findAll();
    }

    @Transactional
    @Override
    public void createElectronicDevice(ElectronicDevice electronicDevice) {
        electronicDeviceRepository.save(electronicDevice);
    }

    @Transactional
    @Override
    public void deleteElectronicDevice(int id) {
        electronicDeviceRepository.deleteById(findElectronicDeviceById(id).getId());
    }
}
