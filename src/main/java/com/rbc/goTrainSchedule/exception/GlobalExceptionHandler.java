package com.rbc.goTrainSchedule.exception;

import com.rbc.goTrainSchedule.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

import static com.rbc.goTrainSchedule.constant.GoTrainScheduleConstants.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundException(Exception e) {
        log.error(e.getMessage(), e);
        var err = new ErrorResponse(NOT_FOUND_ERROR_CODE, NOT_FOUND_ERROR_REASON, e.getMessage(), SERVICE_NAME);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class, ValidationException.class})
    public ResponseEntity<ErrorResponse> badRequest(Exception e) {
        log.error(e.getMessage(), e);
        var err = new ErrorResponse(BAD_REQUEST_ERROR_CODE, BAD_REQUEST_ERROR_REASON, e.getMessage(), SERVICE_NAME);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> genericException(Exception e) {
        log.error(e.getMessage(), e);
        var err = new ErrorResponse(INTERNALSERVER_ERROR_CODE, INTERNALSERVER_ERROR_REASON, e.getMessage(), SERVICE_NAME);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
