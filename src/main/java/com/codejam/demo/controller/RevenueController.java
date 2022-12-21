package com.codejam.demo.controller;

import com.codejam.demo.exception.NotFoundException;
import com.codejam.demo.model.Revenue;
import com.codejam.demo.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RevenueController {
    @Autowired
    private RevenueRepository revenueRepository;

    @GetMapping("/revenues")
    List<Revenue> getAllRevenue() {
        return revenueRepository.findAll();
    }

    @PostMapping("/add-revenue")
    Revenue newRevenue(@RequestBody Revenue newRevenue) {
        return revenueRepository.save(newRevenue);
    }

    @GetMapping("/revenues/{id}")
    Revenue newRevenue(@PathVariable Long id) {
        return revenueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/update-revenues/{id}")
    Revenue updateRevenue(@RequestBody Revenue updateRevenue, @PathVariable Long id) {
        return revenueRepository.findById(id)
                .map(revenue -> {
                    revenue.setMonthly_rate(updateRevenue.getMonthly_rate());
                    revenue.setEvent_name(updateRevenue.getEvent_name());
                    revenue.setDate_time(updateRevenue.getDate_time());
                    return revenueRepository.save(revenue);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    @DeleteMapping("/delete-revenues/{id}")
    String deleteRevenue(@PathVariable Long id){
        if(!revenueRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        revenueRepository.deleteById(id);
        return "ID of " + id + " has been deleted successfully.";
    }
}
