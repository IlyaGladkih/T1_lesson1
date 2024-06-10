package ru.test.lesson1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.lesson1.annotations.TrackAsyncTime;
import ru.test.lesson1.annotations.TrackTime;
import ru.test.lesson1.dto.*;
import ru.test.lesson1.entity.MethodTrack;
import ru.test.lesson1.service.MethodTrackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/stats/")
public class MethodStatisticController {

    private final MethodTrackService methodTrackService;

    @GetMapping()
    public ResponseEntity<List<MethodDataDto>> getAllStatisticData(){
        List<MethodDataDto> allData = methodTrackService.getAllData();
        if(allData.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allData);
    }


    @GetMapping("/avg")
    public ResponseEntity<List<MethodAverageTimeDto>> getAverageWorkTime(){
        List<MethodAverageTimeDto> allAverageTime = methodTrackService.getAllAverageTime();
        if(allAverageTime.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(methodTrackService.getAllAverageTime());
    }

    @GetMapping("/min")
    public ResponseEntity<List<MethodMinTimeDto>> getMinWorkTime(){
        List<MethodMinTimeDto> allMinTime = methodTrackService.getAllMinTime();
        if (allMinTime.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allMinTime);
    }

    @TrackAsyncTime
    @GetMapping("/max")
    public ResponseEntity<List<MethodMaxTimeDto>> getMaxWorkTime(){
        List<MethodMaxTimeDto> allMaxTime = methodTrackService.getAllMaxTime();
        if(allMaxTime.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allMaxTime);
    }

    @GetMapping("/TrackTime")
    public ResponseEntity<List<MethodDataDto>> getTrackTime(){
        List<MethodDataDto> allTrackTime = methodTrackService.getAllTrackTime();
        if (allTrackTime.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allTrackTime);
    }

    @GetMapping("/TrackAsyncTime")
    public ResponseEntity<List<MethodDataDto>> getTrackAsyncTime(){
        List<MethodDataDto> allTrackTime = methodTrackService.getAllTrackTime();
        if (allTrackTime.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allTrackTime);
    }

}
