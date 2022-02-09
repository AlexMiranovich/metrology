package com.help.metrology.repositories.v1.impl;

import com.help.metrology.entitites.Unit;
import com.help.metrology.repositories.v1.UnitRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnitRepositoryImpl implements UnitRepository {

    private final JdbcTemplate jdbcTemplate;

    public UnitRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Unit findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM unit WHERE id=" + id + "", new BeanPropertyRowMapper<>(Unit.class));
    }

    @Override
    public List<Unit> findAll() {
        return jdbcTemplate.query("SELECT * FROM unit", new BeanPropertyRowMapper<>(Unit.class));
    }

    @Override
    public Unit findLastAdded() {
        return jdbcTemplate.queryForObject("SELECT * FROM unit ORDER BY ID DESC LIMIT 1", new BeanPropertyRowMapper<>(Unit.class));
    }

    @Override
    public void save(Unit unit) {
        jdbcTemplate.update(
            "INSERT INTO unit VALUES (?, ?, ?, ?, ?)", unit.getId(), unit.getName(),
            unit.getDescription(), unit.getStatus().toString(), unit.getCreated());
    }
}
