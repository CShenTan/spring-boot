package com.codejam.demo.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SCHEDULE ")
public class Schedule {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    private String venue;

    @Lob
    private String event_name;

    @Lob
    private String date_time;

}
