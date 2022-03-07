package com.help.metrology.repositories.v2.impl;

import com.help.metrology.entitites.Vendor;
import com.help.metrology.repositories.v2.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class VendorRepositoryImpl implements VendorRepository {

    private final EntityManager manager;

    @Override
    public Vendor save(Vendor vendor) {
        manager.persist(vendor);
        return findById(vendor.getId());
    }

    @Override
    public Vendor findById(Long id) {
        return manager.find(Vendor.class, id);
    }

    @Override
    public List<Vendor> findAll() {
        return manager.createQuery("SELECT v FROM Vendor v", Vendor.class).getResultList();
    }
}
