package com.example.delijn;

import com.example.delijn.model.Bus;
import com.example.delijn.model.BusType;
import com.example.delijn.model.Depot;
import com.example.delijn.model.Garage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepotController {
    final int plaatsenGroteParking = 4;
    final int plaatsenNormaleParking = 6;
    final int plaatsenMiniParking = 10;
    @PostMapping("/depot")
    public Depot depot(@RequestBody Depot depot) {

        int restPlaatsenGroteParking = plaatsenGroteParking * 4;
        int restPlaatsenNormaleParking = plaatsenNormaleParking * 2;
        int restPlaatsenMiniParking = plaatsenMiniParking * 4;

        List<Bus> groot = new ArrayList<>();
        List<Bus> normaal = new ArrayList<>();
        List<Bus> klein = new ArrayList<>();

        for (Bus bus : depot.parking().stream().filter(bus -> bus.type() == BusType.GROOT).toList()) {
            if (restPlaatsenGroteParking > 4) {
                restPlaatsenGroteParking -= 4;
                groot.add(bus);
            }
        }

        for (Bus bus : depot.parking().stream().filter(bus -> bus.type() == BusType.NORMAAL).toList()) {
            if (restPlaatsenGroteParking > 2) {
                restPlaatsenGroteParking -= 2;
                groot.add(bus);
            } else if (restPlaatsenNormaleParking > 2) {
                restPlaatsenNormaleParking -= 2;
                normaal.add(bus);
            }
        }

        for (Bus bus : depot.parking().stream().filter(bus -> bus.type() == BusType.MINI).toList()) {
            if (restPlaatsenGroteParking > 1) {
                restPlaatsenGroteParking -= 1;
                groot.add(bus);
            } else if (restPlaatsenNormaleParking > 1) {
                restPlaatsenNormaleParking -= 1;
                normaal.add(bus);
            }else if (restPlaatsenMiniParking > 1) {
                restPlaatsenMiniParking -= 1;
                klein.add(bus);
            }
        }

        return new Depot(depot.stelplaats(), Collections.emptyList(), new Garage(groot, normaal, klein));
    }
}
