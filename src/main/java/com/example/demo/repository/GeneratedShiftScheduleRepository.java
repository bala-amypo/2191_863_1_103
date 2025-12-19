package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.GeneratedShiftSchedule;

@Repository
import java.util.Optional;
import java.util.List;

@Repository
public interface GeneratedShiftScheduleRepository extends JpaRepository<Gene,Long>
{
    Optional<GeneratedShiftScheduleRepository >findByShiftDate(LocalDate date);
    boolean existsByName(String name);
    List<Department> findAll();
}
