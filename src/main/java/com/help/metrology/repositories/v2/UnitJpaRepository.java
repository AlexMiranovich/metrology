package com.help.metrology.repositories.v2;

import com.help.metrology.entitites.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitJpaRepository extends JpaRepository<Unit, Long> {

//    Unit findById(Long id);
}
