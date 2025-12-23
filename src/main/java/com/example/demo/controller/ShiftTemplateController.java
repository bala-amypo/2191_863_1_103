package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Shift Templates", description = "Shift template operations")
public class ShiftTemplateController {
    
    private final ShiftTemplateService shiftTemplateService;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService) {
        this.shiftTemplateService = shiftTemplateService;
    }

    @PostMapping("/department/{departmentId}")
    @Operation(summary = "Create shift template", description = "Create a new shift template for a department")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Shift template created successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    public ResponseEntity<ShiftTemplate> create(@Parameter(description = "Department ID") @PathVariable Long departmentId, @RequestBody ShiftTemplate template) {
        return ResponseEntity.ok(shiftTemplateService.create(template));
    }

    @GetMapping
    @Operation(summary = "Get all templates", description = "Retrieve all shift templates from the system")
    @ApiResponse(responseCode = "200", description = "List of shift templates retrieved successfully")
    public ResponseEntity<List<ShiftTemplate>> getAll() {
        return ResponseEntity.ok(shiftTemplateService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get template by ID", description = "Retrieve a specific shift template by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Shift template found"),
        @ApiResponse(responseCode = "404", description = "Shift template not found")
    })
    public ResponseEntity<ShiftTemplate> getById(@Parameter(description = "Template ID") @PathVariable Long id) {
        return ResponseEntity.ok(shiftTemplateService.getById(id));
    }

    @GetMapping("/department/{departmentId}")
    @Operation(summary = "Get templates by department", description = "Retrieve all shift templates for a specific department")
    @ApiResponse(responseCode = "200", description = "Department shift templates retrieved successfully")
    public ResponseEntity<List<ShiftTemplate>> getByDepartment(@Parameter(description = "Department ID") @PathVariable Long departmentId) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(departmentId));
    }
}