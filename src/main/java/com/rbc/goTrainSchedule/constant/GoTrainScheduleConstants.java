package com.rbc.goTrainSchedule.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class GoTrainScheduleConstants {

    public static final String FILEPATH = "src/main/resources/goTrainSchedule.csv";
    public static final String API_REQUEST_MAPPING = "/goTrain-schedule-ms";
    public static final int FIRST_LINE = 1;

    //Error code
    public static final String INTERNALSERVER_ERROR_CODE = "1000";
    public static final String INTERNALSERVER_ERROR_REASON = "Something went wrong";

    public static final String NOT_FOUND_ERROR_CODE = "2000";
    public static final String NOT_FOUND_ERROR_REASON = "Record not found";


    public static final String BAD_REQUEST_ERROR_CODE = "20100";
    public static final String BAD_REQUEST_ERROR_REASON = "Bad Request";
    public static final String SERVICE_NAME = "goTrain-schedule-ms";


}
