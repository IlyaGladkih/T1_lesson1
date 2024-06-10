package ru.test.lesson1.dto;

import lombok.Data;

@Data
public class MethodAverageTimeDto {

    private final String methodName;
    private final double averageTime;
    private final String annotationAboveMethod;
    private final String className;
}
