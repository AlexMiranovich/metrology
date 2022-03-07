package com.help.metrology.services.v2.impl;

import com.help.metrology.entitites.MeasureEquipment;
import com.help.metrology.repositories.v2.MeasureEquipmentRepository;
import com.help.metrology.services.v2.MeasureEquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MeasureEquipmentServiceImpl implements MeasureEquipmentService {

    private final MeasureEquipmentRepository repository;

    @Override
    public MeasureEquipment findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MeasureEquipment> findAll() { return repository.findAll(); }

    @Override
    public MeasureEquipment save(MeasureEquipment measureEquipment) { return repository.save(measureEquipment); }

    @Override
    public MeasureEquipment update(MeasureEquipment measureEquipment) { return repository.update(measureEquipment); }

    @Override
    public void delete(Long id) {
        MeasureEquipment measureEquipment = findById(id);
        repository.delete(measureEquipment);
    }
}
