package com.rbc.goTrainSchedule.controller;

import com.rbc.goTrainSchedule.model.GoTrainScheduleResponse;
import com.rbc.goTrainSchedule.service.GoTrainSchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.rbc.goTrainSchedule.constant.GoTrainScheduleConstants.API_REQUEST_MAPPING;
import static com.rbc.goTrainSchedule.util.DateUtil.validateDepartureTime;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(API_REQUEST_MAPPING)
@Validated
public class GoTrainSchedulerController {


    private final GoTrainSchedulerService goTrainSchedulerService;

    @GetMapping("/schedule")
    public CompletionStage<ResponseEntity<List<GoTrainScheduleResponse>>> getGoTrainSchedule() {
        List<GoTrainScheduleResponse> response = goTrainSchedulerService.getGoTrainSchedule();
        return CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.OK));
    }

    @GetMapping("/schedule/{line}")
    public CompletionStage<ResponseEntity<List<GoTrainScheduleResponse>>> getGoTrainLineSchedule(@PathVariable String line) {
        List<GoTrainScheduleResponse> response = goTrainSchedulerService.getGoTrainLineSchedule(line);
        return CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.OK));
    }

    // @Size(min = 3, max = 8, I have increased the max limit to 8 as for 12h format it will be 8 -> 10:10 am

    @GetMapping("/schedule/{line}/departure={time}")
    public CompletionStage<ResponseEntity<List<GoTrainScheduleResponse>>> getGoTrainBydepartureTime(@PathVariable("line") String line, @PathVariable("time")
    @Size(min = 3, max = 8, message = "value must be between 3 to 8 digits") String time) {
        validateDepartureTime(time);
        List<GoTrainScheduleResponse> response = goTrainSchedulerService.getGoTrainBydepartureTime(line, time);
        return CompletableFuture.completedFuture(new ResponseEntity<>(response, HttpStatus.OK));
    }
}
