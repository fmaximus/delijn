package com.example.delijn.model;

public enum BusType {
    GROOT(),
    NORMAAL,
    MINI;

    int size() {
        return switch (this) {
            case GROOT -> 4;
            case NORMAAL -> 2;
            case MINI -> 1;
        };
    }
}
