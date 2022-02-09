package com.help.metrology.services.impl;

import com.help.metrology.controllers.v1.dto.UnitCreateDto;
import com.help.metrology.entitites.Unit;
import com.help.metrology.repositories.UnitRepository;
import com.help.metrology.services.UnitService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.help.metrology.entitites.enums.Status.ACTIVE;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Unit findById(Long id) { return unitRepository.findById(id); }

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit findLastAdded() {
        return unitRepository.findLastAdded();
    }

    @Override
    public Unit save(UnitCreateDto unitCreateDto) {
        Unit lastUnit = findLastAdded();
        Long id = Optional.ofNullable(lastUnit)
            .map(Unit::getId)
            .map(it -> it + 1)
            .orElse(1L);
        Unit newUnit = Unit.builder()
            .id(id)
            .name(unitCreateDto.getName())
            .description(unitCreateDto.getDescription())
            .status(ACTIVE)
            .created(LocalDate.now())
            .build();
        unitRepository.save(newUnit);
        return findLastAdded();
    }
}
