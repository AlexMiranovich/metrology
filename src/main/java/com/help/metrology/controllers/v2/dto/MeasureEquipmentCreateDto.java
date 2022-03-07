package com.help.metrology.controllers.v2.dto;

import com.help.metrology.entitites.Vendor;
import com.help.metrology.entitites.enums.EquipmentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeasureEquipmentCreateDto {

    private String name;
    private String description;
    private EquipmentType type;
    private Vendor vendor;
    private Double price;
    private Double precision;
    private Boolean isCalibrated;
}
