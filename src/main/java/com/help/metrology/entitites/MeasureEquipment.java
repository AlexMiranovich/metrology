package com.help.metrology.entitites;

import com.help.metrology.entitites.enums.EquipmentType;
import lombok.Data;

import java.util.List;

@Data
public class MeasureEquipment {

    private String id;
    private String name;
    private String description;
    private EquipmentType type;
    private List<Unit> units;
    private Vendor vendor;
    private Double price;
    private Double precision;
    private Boolean isCalibrated;
}
