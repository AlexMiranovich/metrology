package com.help.metrology.repositories.v2;

import com.help.metrology.entitites.Vendor;

import java.util.List;

public interface VendorRepository {

    Vendor save(Vendor vendor);

    Vendor findById(Long id);

    List<Vendor> findAll();
}
