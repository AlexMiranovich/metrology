package com.help.metrology.controllers.v1.dto;

import com.help.metrology.entitites.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto {

    private String id;
    private String name;
    private String description;
    private Status status;
}
