package com.rbc.goTrainSchedule.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "GoTrainSchedule")
@NoArgsConstructor
public class GoTrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column

    public Integer id;
    @Column
    public String line;
    @Column
    public String departure;
    @Column
    public String arrival;


}
