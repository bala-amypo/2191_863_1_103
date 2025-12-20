package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/generate/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> generateForDate(@PathVariable String date) {
        LocalDate parsed = LocalDate.parse(date);
        return ResponseEntity.ok(scheduleService.generateForDate(parsed));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> getByDate(@PathVariable String date) {
        LocalDate parsed = LocalDate.parse(date);
        return ResponseEntity.ok(scheduleService.getByDate(parsed));
    }
}
