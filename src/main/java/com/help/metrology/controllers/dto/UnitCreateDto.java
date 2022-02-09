package com.help.metrology.controllers.dto;

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
