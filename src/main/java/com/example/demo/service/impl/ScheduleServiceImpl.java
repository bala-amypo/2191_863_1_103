package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository generatedShiftScheduleRepository;

    public ScheduleServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                               AvailabilityRepository availabilityRepository,
                               EmployeeRepository employeeRepository,
                               GeneratedShiftScheduleRepository generatedShiftScheduleRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.generatedShiftScheduleRepository = generatedShiftScheduleRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<ShiftTemplate> templates = shiftTemplateRepository.findAll();
        List<EmployeeAvailability> available = availabilityRepository.findByAvailableDateAndAvailable(date, true);
        List<Employee> employees = employeeRepository.findAll();

        List<GeneratedShiftSchedule> generated = new ArrayList<>();

        for (ShiftTemplate template : templates) {
            Optional<Employee> matched = employees.stream()
                    .filter(emp -> emp.getSkillsSet().containsAll(
                            Arrays.asList(template.getRequiredSkills().split(","))))
                    .filter(emp -> available.stream().anyMatch(av ->
                            av.getEmployee().getId().equals(emp.getId())))
                    .findFirst();

            matched.ifPresent(employee -> {
                GeneratedShiftSchedule schedule = new GeneratedShiftSchedule(
                        date, template.getStartTime(), template.getEndTime(),
                        template.getDepartment(), employee, template);
                generated.add(schedule);
            });
        }

        return generatedShiftScheduleRepository.saveAll(generated);
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return generatedShiftScheduleRepository.findByShiftDate(date);
    }
}
