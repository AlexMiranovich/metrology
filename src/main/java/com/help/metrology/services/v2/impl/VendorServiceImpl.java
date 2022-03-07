package com.help.metrology.services.v2.impl;

import com.help.metrology.entitites.Vendor;
import com.help.metrology.repositories.v2.VendorRepository;
import com.help.metrology.services.v2.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    @Override
    public Vendor save(Vendor vendor) {
        return repository.save(vendor);
    }

    @Override
    public Vendor findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Vendor> findAll() { return repository.findAll(); }
}
