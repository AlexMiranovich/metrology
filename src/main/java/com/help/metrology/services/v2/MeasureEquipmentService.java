package com.help.metrology.services.v2;

import com.help.metrology.entitites.MeasureEquipment;

import java.util.List;

public interface MeasureEquipmentService {

    MeasureEquipment findById(Long id);

    List<MeasureEquipment> findAll();

    MeasureEquipment save(MeasureEquipment measureEquipment);

    MeasureEquipment update(MeasureEquipment measureEquipment);

    void delete(Long id);
}
