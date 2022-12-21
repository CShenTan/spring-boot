package com.codejam.demo;

import com.codejam.demo.model.Idol;
import com.codejam.demo.repository.IdolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private IdolRepository idolRepository;

    @Test
    void contextLoads() {
        Idol u = idolRepository.save(Idol.builder()
                .id(2L)
                .idol_name("Hello")
                .real_name("Hello World")
                .address("KL")
                .idol_status("Active")
                .build());
        idolRepository.save(u);
    }

    @Test
    void contextLoads2() {
        Idol u = idolRepository.save(Idol.builder()
                .id(2L)
                .idol_name("Hello")
                .real_name("Hello World")
                .address("KL")
                .idol_status("In-Active")
                .build());

        Idol u2 = idolRepository.save(Idol.builder()
                .id(3L)
                .idol_name("Hello")
                .real_name("Hello World")
                .address("KL")
                .idol_status("Active")
                .build());
        idolRepository.save(u);
        idolRepository.save(u2);
//        System.out.println(idolRepository.findAll().size());
        int a = (int) Math.floor(Math.random() * (idolRepository.findAll().size() - 1 + 1)) + 1;
//        System.out.println(a);
        assertThat(idolRepository.findById((long) a).get().getIdol_status()).isNotEqualTo("In-Active");
    }

}
