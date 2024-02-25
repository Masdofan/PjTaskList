package com.taskManager.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "Tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private String summary;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date expDate;

    @ManyToOne
    private UserEntity executor;



}
