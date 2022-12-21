package com.codejam.demo.repository;

import com.codejam.demo.model.Idol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdolRepository extends JpaRepository<Idol, Long> {
}
