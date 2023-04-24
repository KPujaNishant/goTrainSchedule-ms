package com.rbc.goTrainSchedule.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoTrainScheduleResponse {


    @JsonProperty("id")
    private Integer id;

    @JsonProperty("line")
    private String line;

    @JsonProperty("departure")
    private Long departure;

    @JsonProperty("arrival")
    private Long arrival;
}
