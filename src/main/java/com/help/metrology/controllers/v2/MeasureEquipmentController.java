package com.help.metrology.controllers.v2;

import com.help.metrology.controllers.v2.dto.MeasureEquipmentCreateDto;
import com.help.metrology.entitites.MeasureEquipment;
import com.help.metrology.services.v2.MeasureEquipmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/hibernate/equipment")
@RequiredArgsConstructor
public class MeasureEquipmentController {

    private final MeasureEquipmentService service;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public MeasureEquipment save(@RequestBody MeasureEquipmentCreateDto createDto) {
        MeasureEquipment equipment = modelMapper.map(createDto, MeasureEquipment.class);
        return service.save(equipment);
    }

    @GetMapping("/{id}")
    public MeasureEquipment find(@PathVariable Long id) { return service.findById(id); }

    @GetMapping("/all")
    public List<MeasureEquipment> findAll() { return service.findAll(); }
}
