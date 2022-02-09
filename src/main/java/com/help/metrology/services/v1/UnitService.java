package com.help.metrology.services.v1;

import com.help.metrology.controllers.dto.UnitCreateDto;
import com.help.metrology.entitites.Unit;

import java.util.List;

public interface UnitService {

    Unit findById(Long id);

    List<Unit> findAll();

    Unit findLastAdded();

    Unit save(UnitCreateDto unitCreateDto);
}
