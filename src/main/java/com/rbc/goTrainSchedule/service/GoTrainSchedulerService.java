package com.rbc.goTrainSchedule.service;

import com.rbc.goTrainSchedule.entity.GoTrainSchedule;
import com.rbc.goTrainSchedule.exception.NotFoundException;
import com.rbc.goTrainSchedule.model.GoTrainScheduleResponse;
import com.rbc.goTrainSchedule.repository.GoTrainScheduleRepository;
import com.rbc.goTrainSchedule.util.GoTrainScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@ComponentScan("com.rbc.goTrainSchedule.mapper.GoTrainScheduleMapper")
public class GoTrainSchedulerService {

    private final GoTrainScheduleRepository goTrainScheduleRepository;

    /**
     * Get  go train schedule details
     *
     * @return List of go train schedules
     */
    public List<GoTrainScheduleResponse> getGoTrainSchedule() {

        //Getting all list from database
        var getScheduleList = goTrainScheduleRepository.findAll();
        List<GoTrainScheduleResponse> goTrainScheduleList = new ArrayList<>();

        for (GoTrainSchedule goTrainSchedule : getScheduleList) {
            //Using mapper to map the entity to response model
            var goTrainScheduleResponse = GoTrainScheduleMapper.mapEntityToResponse(goTrainSchedule);
            goTrainScheduleList.add(goTrainScheduleResponse);
        }
        return goTrainScheduleList;
    }

    /**
     * @param line : Requested line
     *             Get  go train schedule details as per requested line
     * @return List of go train line schedules
     */
    public List<GoTrainScheduleResponse> getGoTrainLineSchedule(String line) {
        var getScheduleList = goTrainScheduleRepository.findAll();
        List<GoTrainScheduleResponse> goTrainScheduleList = new ArrayList<>();

        //filtering the response only for requested line
        var getScheduleListByLine = getScheduleList.stream().filter(response -> response.getLine().equalsIgnoreCase(line)).collect(Collectors.toList());
        if (getScheduleListByLine.isEmpty())
            throw new NotFoundException(line + " line not found, Please enter valid line");
        else {
            for (GoTrainSchedule goTrainSchedule : getScheduleListByLine) {
                //Using mapper to map the entity to response model
                var goTrainScheduleResponse = GoTrainScheduleMapper.mapEntityToResponse(goTrainSchedule);

                goTrainScheduleList.add(goTrainScheduleResponse);

            }
            return goTrainScheduleList;
        }

    }

    /**
     * @param line : Requested line
     * @param time : Requested departure time
     * @return : Return the response as per requested line and time
     */
    public List<GoTrainScheduleResponse> getGoTrainBydepartureTime(String line, String time) {
        var getScheduleList = goTrainScheduleRepository.findAll();


        //filtering the response only for requested line
        var goTrainScheduleList = getScheduleList.stream().filter(response -> response.getLine().equalsIgnoreCase(line)).collect(Collectors.toList());
        if (goTrainScheduleList.isEmpty())
            throw new NotFoundException(line + " line not found, Please enter other line");
        else {
            //filtering the request as per requested departure time
            var goTrainSchedule = goTrainScheduleList.stream().filter(res -> res.getDeparture().equalsIgnoreCase(time)).collect(Collectors.toList());
            var goTrainScheduleResponseList = new ArrayList<GoTrainScheduleResponse>();
            for (GoTrainSchedule entity : goTrainSchedule) {
                var goTrainScheduleResponse = GoTrainScheduleMapper.mapEntityToResponse(entity);
                goTrainScheduleResponseList.add(goTrainScheduleResponse);
            }
            return goTrainScheduleResponseList;

        }


    }


}
