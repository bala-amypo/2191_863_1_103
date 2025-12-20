package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {

    private final ShiftTemplateService shiftTemplateService;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService) {
        this.shiftTemplateService = shiftTemplateService;
    }

    @PostMapping("/department/{departmentId}")
    public ResponseEntity<ShiftTemplate> createTemplate(
            @PathVariable Long departmentId, @RequestBody ShiftTemplate template) {
        // department ID is already bound in ShiftTemplate entity if posted properly
        return ResponseEntity.ok(shiftTemplateService.create(template));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<ShiftTemplate>> getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(departmentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftTemplate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(shiftTemplateService.getByDepartment(id)
                .stream().findFirst().orElse(null));
    }
}
