package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.DetailComponent;
import com.uptc.frw.devicesstore.repository.DetailComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetailComponentService implements com.uptc.frw.devicesstore.service.IDetailComponentService{
    @Autowired
    private DetailComponentRepository detailComponentRepository;

    @Override
    @Transactional(readOnly = true)
    public DetailComponent findDetailComponentById(int id) {
        return detailComponentRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetailComponent> findAllDetailComponent() {
        return (List<DetailComponent>) detailComponentRepository.findAll();
    }

    @Override
    @Transactional
    public void createDetailComponent(DetailComponent detailComponent) {
        detailComponentRepository.save(detailComponent);
    }

    @Override
    @Transactional
    public void deleteDetailComponent(int id) {
        detailComponentRepository.deleteById(id);
    }

}
