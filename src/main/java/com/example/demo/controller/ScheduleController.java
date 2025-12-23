package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedules", description = "Shift schedule operations")
public class ScheduleController {
    
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/generate/{date}")
    @Operation(summary = "Generate schedule", description = "Generate shift schedule for a specific date")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Schedule generated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid date or generation failed")
    })
    public ResponseEntity<List<GeneratedShiftSchedule>> generate(@Parameter(description = "Date (YYYY-MM-DD)") @PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.generateForDate(date));
    }

    @GetMapping("/date/{date}")
    @Operation(summary = "Get schedule by date", description = "Retrieve shift schedule for a specific date")
    @ApiResponse(responseCode = "200", description = "Schedule retrieved successfully")
    public ResponseEntity<List<GeneratedShiftSchedule>> getByDate(@Parameter(description = "Date (YYYY-MM-DD)") @PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.getByDate(date));
    }
}