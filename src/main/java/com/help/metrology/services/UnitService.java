package com.help.metrology.services;

import com.help.metrology.controllers.v1.dto.UnitCreateDto;
import com.help.metrology.entitites.Unit;

import java.util.List;

public interface UnitService {

    Unit findById(Long id);

    List<Unit> findAll();

    Unit findLastAdded();

    Unit save(UnitCreateDto unitCreateDto);
}
