package com.help.metrology.repositories.v2;

import com.help.metrology.entitites.MeasureEquipment;

import java.util.List;

public interface MeasureEquipmentRepository {

    MeasureEquipment findById(Long id);

    List<MeasureEquipment> findAll();

    MeasureEquipment save(MeasureEquipment measureEquipment);

    MeasureEquipment update(MeasureEquipment measureEquipment);

    void delete(MeasureEquipment measureEquipment);
}
