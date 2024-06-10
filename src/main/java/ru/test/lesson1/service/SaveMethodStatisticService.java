package ru.test.lesson1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.lesson1.entity.MethodTrack;
import ru.test.lesson1.repository.MethodTrackRepository;

@Service
@RequiredArgsConstructor
public class SaveMethodStatisticService {

    private final MethodTrackRepository methodTrackRepository;

    @Transactional
    public void saveStatistic(MethodTrack data){
        methodTrackRepository.save(data);
    }
}
