package com.rbc.goTrainSchedule.util;

import com.rbc.goTrainSchedule.entity.GoTrainSchedule;
import com.rbc.goTrainSchedule.model.GoTrainScheduleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface GoTrainScheduleMapper {

    static GoTrainScheduleResponse mapEntityToResponse(GoTrainSchedule GoTrainSchedule) {
        var goTrainScheduleResponse = new GoTrainScheduleResponse();
        goTrainScheduleResponse.setId(GoTrainSchedule.getId());
        goTrainScheduleResponse.setLine(GoTrainSchedule.getLine());
        goTrainScheduleResponse.setDeparture(Long.parseLong(GoTrainSchedule.getDeparture()));
        goTrainScheduleResponse.setArrival(Long.parseLong(GoTrainSchedule.getArrival()));
        return goTrainScheduleResponse;
    }

}
