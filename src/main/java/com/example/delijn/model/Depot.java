package com.example.delijn.model;

import java.util.List;

public record Depot(String stelplaats, List<Bus> parking, Garage garage) {
}
