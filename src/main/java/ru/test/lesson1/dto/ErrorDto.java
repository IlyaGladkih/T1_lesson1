package ru.test.lesson1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private final String errorMessage;
}
