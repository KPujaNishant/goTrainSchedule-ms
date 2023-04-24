package com.example.goTrainSchedulems.mocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbc.goTrainSchedule.model.GoTrainScheduleResponse;

import java.io.File;
import java.io.IOException;

public class GoTrainSchedulerControllerMocks {

    private static final ObjectMapper mapper =new ObjectMapper();

    public static GoTrainScheduleResponse response =null;

    static {
        GoTrainScheduleResponse response1 = null;
        try{
            response1 = mapper.readValue(new File("src/test/java/com/example/goTrainSchedulems/testdata/SuccessResponse.json"), GoTrainScheduleResponse.class);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        response = response1;
    }


}
