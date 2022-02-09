package com.help.metrology.repositories;

import com.help.metrology.entitites.Unit;

import java.util.List;

public interface UnitRepository {

    Unit findById(Long id);

    List<Unit> findAll();

    Unit findLastAdded();

    void save(Unit unit);
}
