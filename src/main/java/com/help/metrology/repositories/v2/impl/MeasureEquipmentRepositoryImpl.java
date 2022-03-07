package com.help.metrology.repositories.v2.impl;

import com.help.metrology.entitites.MeasureEquipment;
import com.help.metrology.repositories.v2.MeasureEquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class MeasureEquipmentRepositoryImpl implements MeasureEquipmentRepository {

    private final EntityManager entityManager;
    
    @Override
    public MeasureEquipment findById(Long id) { return entityManager.find(MeasureEquipment.class, id); }
/*
    @Override
    public List<MeasureEquipment> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MeasureEquipment> cq = cb.createQuery(MeasureEquipment.class);
        Root<MeasureEquipment> rootEntry = cq.from(MeasureEquipment.class);
        CriteriaQuery<MeasureEquipment> all = cq.select(rootEntry);
        TypedQuery<MeasureEquipment> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
*/
    @Override
    public List<MeasureEquipment> findAll() {
        TypedQuery<MeasureEquipment> query = entityManager.createQuery("SELECT m FROM MeasureEquipment m", MeasureEquipment.class);
        return query.getResultList();
    }



    @Override
    public MeasureEquipment save(MeasureEquipment measureEquipment) {
        entityManager.persist(measureEquipment);
        return measureEquipment;
    }

    @Override
    public MeasureEquipment update(MeasureEquipment measureEquipment) {
        entityManager.merge(measureEquipment);

        entityManager.flush();

        return measureEquipment;
    }

    @Override
    public void delete(MeasureEquipment measureEquipment) { entityManager.remove(measureEquipment); }
}
