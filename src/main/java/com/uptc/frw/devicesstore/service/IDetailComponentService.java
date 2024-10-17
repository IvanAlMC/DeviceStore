package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.DetailComponent;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDetailComponentService {

    @Transactional(readOnly = true)
    DetailComponent findDetailComponentById(int id);

    @Transactional(readOnly = true)
    List<DetailComponent> findAllDetailComponent();

    @Transactional
    void createDetailComponent(DetailComponent detailComponent);

    @Transactional
    void deleteDetailComponent(int id);
}
