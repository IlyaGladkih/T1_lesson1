package ru.test.lesson1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.lesson1.annotations.TrackAsyncTime;
import ru.test.lesson1.annotations.TrackTime;
import ru.test.lesson1.converter.MethodDataConverter;
import ru.test.lesson1.dto.*;
import ru.test.lesson1.entity.MethodTrack;
import ru.test.lesson1.repository.MethodTrackRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MethodTrackService {

    private final MethodTrackRepository methodTrackRepository;
    private final MethodDataConverter converter;

    @Transactional
    public List<MethodDataDto> getAllData(){
        List<MethodTrack> all = methodTrackRepository.findAll();
        return this.toDto(all);
    }

    @Transactional
    public List<MethodAverageTimeDto> getAllAverageTime(){
        return methodTrackRepository.findAllAverageTimeMethodWork();
    }

    @TrackTime
    @Transactional
    public List<MethodMinTimeDto> getAllMinTime(){
        return  methodTrackRepository.findAllMinTimeMethodWork();
    }

    @Transactional
    public List<MethodMaxTimeDto> getAllMaxTime(){
        return methodTrackRepository.findAllMaxTimeMethodWork();
    }

    @Transactional
    public List<MethodDataDto> getAllTrackTime(){
        List<MethodTrack> trackTime = methodTrackRepository.findAllByAnnotationAboveMethodLike("TrackTime");
        return this.toDto(trackTime);
    }

    @Transactional
    public List<MethodDataDto> getAllTrackAsymcTime(){
        List<MethodTrack> trackTime = methodTrackRepository.findAllByAnnotationAboveMethodLike("TrackAsyncTime");
        return this.toDto(trackTime);
    }

    private List<MethodDataDto> toDto(List<MethodTrack> data){
        if(!data.isEmpty()) return data.stream().map(converter::toDTO).collect(Collectors.toList());
        else return Collections.EMPTY_LIST;
    }

}
