package com.example.delijn;

import com.example.delijn.model.Bus;
import com.example.delijn.model.BusType;
import com.example.delijn.model.Depot;
import com.example.delijn.model.Garage;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepotControllerTest {
    DepotController depotController = new DepotController();

    @Test
    void depotSuccess() {
        Depot input = new Depot("De Lijn Arsenaal",
                List.of(
                        new Bus("1000", BusType.GROOT),
                        new Bus("1001", BusType.GROOT),
                        new Bus("1002", BusType.GROOT),
                        new Bus("2000", BusType.NORMAAL),
                        new Bus("2001", BusType.NORMAAL),
                        new Bus("2002", BusType.NORMAAL),
                        new Bus("2003", BusType.NORMAAL),
                        new Bus("2004", BusType.NORMAAL),
                        new Bus("2005", BusType.NORMAAL),
                        new Bus("3000", BusType.MINI),
                        new Bus("3001", BusType.MINI),
                        new Bus("3002", BusType.MINI),
                        new Bus("3003", BusType.MINI),
                        new Bus("3004", BusType.MINI),
                        new Bus("3005", BusType.MINI),
                        new Bus("3006", BusType.MINI),
                        new Bus("3007", BusType.MINI),
                        new Bus("3008", BusType.MINI),
                        new Bus("3009", BusType.MINI),
                        new Bus("3010", BusType.MINI),
                        new Bus("3011", BusType.MINI),
                        new Bus("3012", BusType.MINI)
                ),

                new Garage(
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList()
                )
        );

        Depot expected = new Depot("De Lijn Arsenaal",
                Collections.emptyList(),
                new Garage(
                        List.of(
                                new Bus("1000", BusType.GROOT),
                                new Bus("1001", BusType.GROOT),
                                new Bus("1002", BusType.GROOT),
                                new Bus("2000", BusType.NORMAAL),
                                new Bus("2001", BusType.NORMAAL)
                        ),
                        List.of(
                                new Bus("2002", BusType.NORMAAL),
                                new Bus("2003", BusType.NORMAAL),
                                new Bus("2004", BusType.NORMAAL),
                                new Bus("2005", BusType.NORMAAL),
                                new Bus("3000", BusType.MINI),
                                new Bus("3001", BusType.MINI),
                                new Bus("3002", BusType.MINI),
                                new Bus("3003", BusType.MINI)
                        ),
                        List.of(
                                new Bus("3004", BusType.MINI),
                                new Bus("3005", BusType.MINI),
                                new Bus("3006", BusType.MINI),
                                new Bus("3007", BusType.MINI),
                                new Bus("3008", BusType.MINI),
                                new Bus("3009", BusType.MINI),
                                new Bus("3010", BusType.MINI),
                                new Bus("3011", BusType.MINI),
                                new Bus("3012", BusType.MINI)
                        )
                )
        );

        Depot ouptut = depotController.depot(input);

        assertEquals(expected, ouptut);
    }

    @Test
    void depotTooManyBusses() {
        Depot input = new Depot("De Lijn Arsenaal",
                List.of(
                        new Bus("1000", BusType.GROOT),
                        new Bus("1001", BusType.GROOT),
                        new Bus("1002", BusType.GROOT),
                        new Bus("1003", BusType.GROOT),
                        new Bus("2000", BusType.NORMAAL),
                        new Bus("2001", BusType.NORMAAL),
                        new Bus("2002", BusType.NORMAAL),
                        new Bus("2003", BusType.NORMAAL),
                        new Bus("2004", BusType.NORMAAL),
                        new Bus("2005", BusType.NORMAAL),
                        new Bus("3000", BusType.MINI),
                        new Bus("3001", BusType.MINI),
                        new Bus("3002", BusType.MINI),
                        new Bus("3003", BusType.MINI),
                        new Bus("3004", BusType.MINI),
                        new Bus("3005", BusType.MINI),
                        new Bus("3006", BusType.MINI),
                        new Bus("3007", BusType.MINI),
                        new Bus("3008", BusType.MINI),
                        new Bus("3009", BusType.MINI),
                        new Bus("3010", BusType.MINI),
                        new Bus("3011", BusType.MINI),
                        new Bus("3012", BusType.MINI)
                ),

                new Garage(
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList()
                )
        );

        Depot expected = new Depot("De Lijn Arsenaal",
                List.of(
                        new Bus("3010", BusType.MINI),
                        new Bus("3011", BusType.MINI),
                        new Bus("3012", BusType.MINI)
                ),
                new Garage(
                        List.of(
                                new Bus("1000", BusType.GROOT),
                                new Bus("1001", BusType.GROOT),
                                new Bus("1002", BusType.GROOT),
                                new Bus("1003", BusType.GROOT)
                        ),
                        List.of(

                                new Bus("2000", BusType.NORMAAL),
                                new Bus("2001", BusType.NORMAAL),
                                new Bus("2002", BusType.NORMAAL),
                                new Bus("2003", BusType.NORMAAL),
                                new Bus("2004", BusType.NORMAAL),
                                new Bus("2005", BusType.NORMAAL)
                        ),
                        List.of(
                                new Bus("3000", BusType.MINI),
                                new Bus("3001", BusType.MINI),
                                new Bus("3002", BusType.MINI),
                                new Bus("3003", BusType.MINI),
                                new Bus("3004", BusType.MINI),
                                new Bus("3005", BusType.MINI),
                                new Bus("3006", BusType.MINI),
                                new Bus("3007", BusType.MINI),
                                new Bus("3008", BusType.MINI),
                                new Bus("3009", BusType.MINI)
                        )
                )
        );

        Depot ouptut = depotController.depot(input);

        assertEquals(expected, ouptut);
    }
}