package com.help.metrology.services.v2;

import com.help.metrology.entitites.Vendor;

import java.util.List;

public interface VendorService {

    Vendor save(Vendor vendor);

    Vendor findById(Long id);

    List<Vendor> findAll();
}
