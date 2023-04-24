package com.rbc.goTrainSchedule.model;


import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoTrainSchedule {

    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String line;
    @CsvBindByPosition(position = 2)
    private String departure;
    @CsvBindByPosition(position = 3)
    private String arrival;
}
