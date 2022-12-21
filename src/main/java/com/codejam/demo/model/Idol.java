package com.codejam.demo.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PERSONAL_INFORMATION")
public class Idol {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    private String real_name;

    @Lob
    private String idol_name;

    @Lob
    private String address;

    @Lob
    private String idol_status;
}
