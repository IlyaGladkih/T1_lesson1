package ru.test.lesson1.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.test.lesson1.dto.ErrorDto;

@ControllerAdvice
public class MethodStatisticControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        return ResponseEntity.badRequest().body(ErrorDto.builder().errorMessage(e.getMessage()).build());
    }

}
