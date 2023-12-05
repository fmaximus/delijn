package com.example.delijn;

import com.example.delijn.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepotController {
    static final int plaatsenGroteParking = 4;
    static final int plaatsenNormaleParking = 6;
    static final int plaatsenMiniParking = 10;
    @PostMapping("/depot")
    public Depot depot(@RequestBody Depot depot) {
        BusLot groteParking = new BusLot(plaatsenGroteParking, BusType.GROOT, depot.garage().groot());
        BusLot normaleParking = new BusLot(plaatsenNormaleParking, BusType.NORMAAL, depot.garage().medium());
        BusLot miniParking = new BusLot(plaatsenMiniParking, BusType.MINI, depot.garage().klein());
        List<Bus> parking = new ArrayList<>();

        depot.parking().stream().sorted(Comparator.comparing(Bus::type)).forEach(bus -> {
            if (groteParking.addBus(bus)) {
                return;
            }
            if (normaleParking.addBus(bus)) {
                return;
            }
            if (miniParking.addBus(bus)) {
                return;
            }
            parking.add(bus);
        });

        return new Depot(depot.stelplaats(), parking, new Garage(groteParking.busses(), normaleParking.busses(), miniParking.busses()));
    }
}
