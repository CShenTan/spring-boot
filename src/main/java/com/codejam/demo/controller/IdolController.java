package com.codejam.demo.controller;

import com.codejam.demo.exception.NotFoundException;
import com.codejam.demo.model.Idol;
import com.codejam.demo.repository.IdolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IdolController {
    @Autowired
    private IdolRepository idolRepository;

    @GetMapping("/idols")
    List<Idol> getAllIdol() {
        return idolRepository.findAll();
    }

    @PostMapping("/add-idol")
    Idol newIdol(@RequestBody Idol newIdol) {
        return idolRepository.save(newIdol);
    }

    @GetMapping("/idols/{id}")
    Idol newIdol(@PathVariable Long id) {
        return idolRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/update-idols/{id}")
    Idol updateIdol(@RequestBody Idol updateIdol, @PathVariable Long id) {
        return idolRepository.findById(id)
                .map(idol -> {
                    idol.setReal_name(updateIdol.getReal_name());
                    idol.setIdol_name(updateIdol.getIdol_name());
                    idol.setAddress(updateIdol.getAddress());
                    idol.setIdol_status(updateIdol.getIdol_status());
                    return idolRepository.save(idol);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    @DeleteMapping("/delete-idols/{id}")
    String deleteIdol(@PathVariable Long id){
        if(!idolRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        idolRepository.deleteById(id);
        return "ID of " + id + " has been deleted successfully.";
    }
}
