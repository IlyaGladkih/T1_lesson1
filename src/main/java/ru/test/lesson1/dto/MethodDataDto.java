package ru.test.lesson1.dto;

import lombok.*;

@Data
@Builder
public class MethodDataDto {

    private final String methodName;

    private final String className;

    private final long time;

    private final String annotationAboveMethod;
}
