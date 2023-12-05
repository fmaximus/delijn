package com.example.delijn.model;

import java.util.ArrayList;
import java.util.List;

public class BusLot {
    private final BusType type;

    private final List<Bus> busses = new ArrayList<>();

    private int spacesRemaining;

    public BusLot(int spaces, BusType type, List<Bus> initialBusses) {
        this.type = type;
        this.spacesRemaining = spaces * type.size();
        this.busses.addAll(initialBusses);
    }

    public boolean addBus(Bus bus) {
        if (bus.type().size() > type.size()) {
            return false;
        }
        if (spacesRemaining >= bus.type().size()) {
            spacesRemaining -= bus.type().size();
            busses.add(bus);
            return true;
        }
        return false;
    }

    public List<Bus> busses() {
        return List.copyOf(busses);
    }
}
