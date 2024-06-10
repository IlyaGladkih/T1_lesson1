package ru.test.lesson1.dto;

import lombok.Data;

@Data
public class MethodMinTimeDto {

    private final String methodName;
    private final double minTime;
    private final String annotationAboveMethod;
    private final String className;
}
