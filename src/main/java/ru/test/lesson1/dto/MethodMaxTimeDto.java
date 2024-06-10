package ru.test.lesson1.dto;

import lombok.Data;

@Data
public class MethodMaxTimeDto {
    private final String methodName;
    private final double maxTime;
    private final String annotationAboveMethod;
    private final String className;
}
