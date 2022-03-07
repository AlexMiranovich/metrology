package com.help.metrology.controllers.v2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorCreateDto {

    private String name;
    private String subArea;
    private String address;
    private String info;
}
