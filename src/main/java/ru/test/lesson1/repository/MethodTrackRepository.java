package ru.test.lesson1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.test.lesson1.dto.MethodAverageTimeDto;
import ru.test.lesson1.dto.MethodDataDto;
import ru.test.lesson1.dto.MethodMaxTimeDto;
import ru.test.lesson1.dto.MethodMinTimeDto;
import ru.test.lesson1.entity.MethodTrack;

import java.util.List;

@Repository
public interface MethodTrackRepository extends JpaRepository<MethodTrack, Integer> {

    @Query("select "+
            "new ru.test.lesson1.dto.MethodAverageTimeDto(m.methodName, avg (m.workTime), m.annotationAboveMethod, m.className) "+
            "from MethodTrack m group by m.methodName, m.annotationAboveMethod, m.className")
    List<MethodAverageTimeDto> findAllAverageTimeMethodWork();

    @Query("select "+
            "new ru.test.lesson1.dto.MethodMinTimeDto(m.methodName, min (m.workTime), m.annotationAboveMethod, m.className) "+
            "from MethodTrack m group by m.methodName, m.annotationAboveMethod, m.className")
    List<MethodMinTimeDto> findAllMinTimeMethodWork();

    @Query("select "+
            "new ru.test.lesson1.dto.MethodMaxTimeDto(m.methodName, min (m.workTime), m.annotationAboveMethod, m.className) "+
            "from MethodTrack m group by m.methodName, m.annotationAboveMethod, m.className")
    List<MethodMaxTimeDto> findAllMaxTimeMethodWork();

    List<MethodTrack> findAllByAnnotationAboveMethodLike(String name);
}
