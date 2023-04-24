package com.rbc.goTrainSchedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private static final long serialVersionID = 1L;

    @JsonProperty("code")
    private String code;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("message")
    private String message;
    @JsonProperty("service")
    private String service;
}
