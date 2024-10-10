package com.uptc.frw.devicesstore.repository;

import com.uptc.frw.devicesstore.model.ElectronicDevice;
import org.springframework.data.repository.CrudRepository;

public interface ElectronicDevicesRepository extends CrudRepository<ElectronicDevice, Integer> {
}
