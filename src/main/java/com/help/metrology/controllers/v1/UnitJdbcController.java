package com.help.metrology.controllers.v1;

import com.help.metrology.controllers.v1.dto.UnitCreateDto;
import com.help.metrology.controllers.v1.dto.UnitDto;
import com.help.metrology.entitites.Unit;
import com.help.metrology.services.v1.UnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jdbc/unit")
public class UnitJdbcController {

    private final UnitService unitService;
    private final ModelMapper modelMapper;

    public UnitJdbcController(UnitService unitService, ModelMapper modelMapper) {
        this.unitService = unitService;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Get unit by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the unit", content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = UnitDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Unit not found", content = @Content) })
    @GetMapping("/{id}")
    public Unit getUnit(@PathVariable Long id) { return unitService.findById(id); }

    @Operation(summary = "Get all units")
    @GetMapping("/all")
    public List<Unit> getAllUnits() { return unitService.findAll(); }

    @Operation(summary = "Create new unit")
    @PostMapping
    public UnitDto createUnit(@RequestBody UnitCreateDto createDto) {
        Unit unit = unitService.save(createDto);
        return modelMapper.map(unit, UnitDto.class);
    }

}
