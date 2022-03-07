package com.help.metrology.controllers.v2;

import com.help.metrology.controllers.v2.dto.VendorCreateDto;
import com.help.metrology.entitites.Vendor;
import com.help.metrology.services.v2.VendorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/hibernate/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService service;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public Vendor save(@RequestBody VendorCreateDto createDto) {
        Vendor vendor = modelMapper.map(createDto, Vendor.class);
        return service.save(vendor);
    }

    @GetMapping("/{id}")
    public Vendor find(@PathVariable Long id) { return service.findById(id); }

    @GetMapping("/all")
    public List<Vendor> findAll() { return service.findAll(); }

}
