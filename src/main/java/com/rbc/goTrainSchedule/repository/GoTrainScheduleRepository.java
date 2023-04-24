package com.rbc.goTrainSchedule.repository;

import com.rbc.goTrainSchedule.entity.GoTrainSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoTrainScheduleRepository extends CrudRepository<GoTrainSchedule, Integer> {
    List<GoTrainSchedule> findAll();
}
