package com.help.metrology.entitites;

import com.help.metrology.entitites.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Unit {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private LocalDate created;
}
