package com.help.metrology.controllers.v2;

import com.help.metrology.controllers.dto.UnitCreateDto;
import com.help.metrology.controllers.dto.UnitDto;
import com.help.metrology.entitites.Unit;
import com.help.metrology.services.v2.UnitJpaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jpa/unit")
public class UnitJpaController {

    private final UnitJpaService unitJpaService;
    private final ModelMapper modelMapper;

    public UnitJpaController(UnitJpaService unitJpaService, ModelMapper modelMapper) {
        this.unitJpaService = unitJpaService;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Get unit by id - JPA")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the unit", content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = UnitDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Unit not found", content = @Content) })
    @GetMapping("/{id}")
    public Unit getUnit(@PathVariable Long id) { return unitJpaService.findById(id); }

    @Operation(summary = "Get all units - JPA")
    @GetMapping("/all")
    public List<Unit> getAllUnits() { return unitJpaService.findAll(); }

    @Operation(summary = "Create new unit - JPA")
    @PostMapping
    public UnitDto createUnit(@RequestBody UnitCreateDto createDto) {
        Unit unit = unitJpaService.save(createDto);
        return modelMapper.map(unit, UnitDto.class);
    }

}
