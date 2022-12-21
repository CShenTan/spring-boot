package com.codejam.demo.controller;

import com.codejam.demo.exception.NotFoundException;
import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/schedules")
    List<Schedule> getAllScehdule() {
        return scheduleRepository.findAll();
    }

    @PostMapping("/add-schedule")
    Schedule newScehdule(@RequestBody Schedule newScehdule) {
        return scheduleRepository.save(newScehdule);
    }

    @GetMapping("/schedules/{id}")
    Schedule newScehdule(@PathVariable Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/update-schedules/{id}")
    Schedule updateScehdule(@RequestBody Schedule updateScehdule, @PathVariable Long id) {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setVenue(updateScehdule.getVenue());
                    schedule.setEvent_name(updateScehdule.getEvent_name());
                    schedule.setDate_time(updateScehdule.getDate_time());
                    return scheduleRepository.save(schedule);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    @DeleteMapping("/delete-schedules/{id}")
    String deleteSchedule(@PathVariable Long id){
        if(!scheduleRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        scheduleRepository.deleteById(id);
        return "ID of " + id + " has been deleted successfully.";
    }
}
