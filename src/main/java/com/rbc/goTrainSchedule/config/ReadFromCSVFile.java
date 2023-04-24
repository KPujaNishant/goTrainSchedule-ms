package com.rbc.goTrainSchedule.config;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.rbc.goTrainSchedule.model.GoTrainSchedule;
import com.rbc.goTrainSchedule.repository.GoTrainScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.rbc.goTrainSchedule.constant.GoTrainScheduleConstants.FILEPATH;
import static com.rbc.goTrainSchedule.constant.GoTrainScheduleConstants.FIRST_LINE;

@Configuration
@Slf4j

@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReadFromCSVFile {


    private final GoTrainScheduleRepository goTrainScheduleRepository;

    @Bean
    public void readFromCSV() throws IOException, CsvException {
        log.info("Inside read from csv file");

        //Reading records from excel, parsing it and skip the 1st line as it's header and
        // mapping it to java object (modal)
        List<GoTrainSchedule> beans = new CsvToBeanBuilder(new FileReader(FILEPATH)).withSkipLines(FIRST_LINE)
                .withType(GoTrainSchedule.class).build()
                .parse();

        //mapping data to entity from model
        List<com.rbc.goTrainSchedule.entity.GoTrainSchedule> entityList = new ArrayList<>();
        for (GoTrainSchedule model : beans) {
            com.rbc.goTrainSchedule.entity.GoTrainSchedule entity = new com.rbc.goTrainSchedule.entity.GoTrainSchedule();
            //converting id from string to integer as from excel we got id as string
            if (StringUtils.isNoneEmpty(model.getId()))
                entity.setId(Integer.getInteger(model.getId().trim()));
            entity.setLine(model.getLine());
            entity.setDeparture(model.getDeparture());
            entity.setArrival(model.getArrival());
            entityList.add(entity);
        }

        //Saving records to table
        goTrainScheduleRepository.saveAll(entityList);


        log.info("Go Train Scheduled has been saved to Database ");


    }


}
