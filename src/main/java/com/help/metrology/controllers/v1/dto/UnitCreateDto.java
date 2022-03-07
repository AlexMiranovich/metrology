package com.help.metrology.controllers.v1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class UnitCreateDto {

    @NotBlank
    private String name;
    private String description;
}
