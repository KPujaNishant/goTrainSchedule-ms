package com.example.goTrainSchedulems.controller;

import com.rbc.goTrainSchedule.controller.GoTrainSchedulerController;
import com.rbc.goTrainSchedule.service.GoTrainSchedulerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class GoTrainSchedulerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GoTrainSchedulerService goTrainSchedulerService;

    @InjectMocks
    private GoTrainSchedulerController goTrainSchedulerController;

    @BeforeEach
    public void setup()
    {
        mockMvc= MockMvcBuilders.standaloneSetup(goTrainSchedulerController).build();
    }

   @Test
    void testGetSchedule() throws Exception {
       MvcResult  mcvResult= mockMvc.perform(get("http://localhost:8080/goTrain-schedule-ms/schedule").contentType(MediaType.APPLICATION_JSON)
       ).andReturn();

       Assertions.assertEquals(HttpStatus.OK.value(), mcvResult.getResponse().getStatus());
    }

    @Test
    void testGoTrainLineSchedule() throws Exception {
        MvcResult  mcvResult= mockMvc.perform(get("http://localhost:8080/goTrain-schedule-ms/schedule/Kitchener").contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mcvResult.getResponse().getStatus());
    }

    @Test
    void testGetGoTrainBydepartureTime() throws Exception {
        MvcResult  mcvResult= mockMvc.perform(get("http://localhost:8080/goTrain-schedule-ms/schedule/Kitchener?departure=1215").contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(HttpStatus.OK.value(), mcvResult.getResponse().getStatus());
    }

    @Test
    void testInvalidUrl() throws Exception {
        MvcResult  mcvResult= mockMvc.perform(get("http://localhost:8080/goTrain-schedule-ms/schedulee").contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), mcvResult.getResponse().getStatus());
    }
}
