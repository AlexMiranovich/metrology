package com.help.metrology.services.v2;

import com.help.metrology.controllers.dto.UnitCreateDto;
import com.help.metrology.entitites.Unit;

import java.util.List;

public interface UnitJpaService {

    Unit findById(Long id);

    List<Unit> findAll();

    Unit save(UnitCreateDto unitCreateDto);
}
