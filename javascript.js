// JSON-gegevens
const data = {
    garage: {
      groot: [
        { bus: "1000", type: "GROOT" },
        { bus: "1001", type: "GROOT" },
        { bus: "1002", type: "GROOT" },
        { bus: "2000", type: "NORMAAL" },
        { bus: "2001", type: "NORMAAL" }
      ],
      medium: [
        { bus: "2002", type: "NORMAAL" },
        { bus: "2003", type: "NORMAAL" },
        { bus: "2004", type: "NORMAAL" },
        { bus: "2005", type: "NORMAAL" },
        { bus: "3000", type: "MINI" },
        { bus: "3001", type: "MINI" },
        { bus: "3002", type: "MINI" },
        { bus: "3003", type: "MINI" }
      ],
      klein: [
        { bus: "3004", type: "MINI" },
        { bus: "3005", type: "MINI" },
        { bus: "3006", type: "MINI" },
        { bus: "3007", type: "MINI" },
        { bus: "3008", type: "MINI" },
        { bus: "3009", type: "MINI" },
        { bus: "3010", type: "MINI" },
        { bus: "3011", type: "MINI" },
        { bus: "3012", type: "MINI" }
      ]
    }
  };
  
  // Functie om div-elementen toe te voegen aan de DOM
  function voegDivToe(type, busNummer) {
    // Maak een nieuw div-element
    const div = document.createElement("div");
    
    // Stel de klasse in op basis van het type
    div.className = type.toLowerCase();
    
    // Voeg inhoud toe aan het div-element
    div.innerHTML = `Bus ${busNummer}`;
    
    // Voeg het div-element toe aan de div met de klasse 'parkeetplaats_{type}'
    document.querySelector(`.parkeerplaats_${type.toLowerCase()}`).appendChild(div);
  }
  
  // Loop door de garage en voeg div-elementen toe aan de DOM
  for (const type in data.garage) {
    if (data.garage.hasOwnProperty(type)) {
      // Maak een div-element voor elk type en voeg het toe aan de DOM
      const parkeetplaatsDiv = document.createElement("div");
      parkeetplaatsDiv.className = `parkeerplaatslayout_${type.toLowerCase()}`;
      document.body.appendChild(parkeetplaatsDiv);
  
      // Loop door de bussen van elk type en voeg div-elementen toe aan de DOM
      data.garage[type].forEach(bus => {
        voegDivToe(type, bus.bus);
      });
    }
  }
  