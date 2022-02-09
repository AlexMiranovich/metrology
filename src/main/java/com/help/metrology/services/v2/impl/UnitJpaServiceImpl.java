package com.help.metrology.services.v2.impl;

import com.help.metrology.controllers.dto.UnitCreateDto;
import com.help.metrology.entitites.Unit;
import com.help.metrology.repositories.v2.UnitJpaRepository;
import com.help.metrology.services.v2.UnitJpaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.help.metrology.entitites.enums.Status.ACTIVE;

@Service
public class UnitJpaServiceImpl implements UnitJpaService {

    private final UnitJpaRepository unitJpaRepository;

    public UnitJpaServiceImpl(UnitJpaRepository unitJpaRepository) {
        this.unitJpaRepository = unitJpaRepository;
    }

    @Override
    public Unit findById(Long id) {
        Optional<Unit> unit = unitJpaRepository.findById(id);
        return Optional.of(unit).get().orElse(null);
    }

    @Override
    public List<Unit> findAll() {
        return unitJpaRepository.findAll();
    }

    @Override
    public Unit save(UnitCreateDto unitCreateDto) {
        Unit newUnit = Unit.builder()
            .name(unitCreateDto.getName())
            .description(unitCreateDto.getDescription())
            .status(ACTIVE)
            .created(LocalDate.now())
            .build();
        return unitJpaRepository.save(newUnit);
    }


}
