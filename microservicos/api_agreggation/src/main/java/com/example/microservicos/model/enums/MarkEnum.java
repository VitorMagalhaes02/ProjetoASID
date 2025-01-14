package com.example.microservicos.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MarkEnum {
    POOR(2),
    AVERAGE(3),
    GOOD(4),
    VERY_GOOD(5),
    EXCELLENT(6);

    private int value;
}
