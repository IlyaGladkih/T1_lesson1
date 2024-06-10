package ru.test.lesson1.converter;

import org.springframework.stereotype.Component;
import ru.test.lesson1.dto.MethodDataDto;
import ru.test.lesson1.entity.MethodTrack;

@Component
public class MethodDataConverter {

    public MethodDataDto toDTO(MethodTrack entity){
        return MethodDataDto.builder()
                .methodName(entity.getMethodName())
                .className(entity.getClassName())
                .time(entity.getWorkTime())
                .annotationAboveMethod(entity.getAnnotationAboveMethod())
                .build();
    }
}
