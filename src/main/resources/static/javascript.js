// JSON-gegevens
const url = '/api/depot'; // Replace with your API endpoint

const input = {
	stelplaats: "De Lijn Arsenaal",
	parking: [
		{bus: "1000",type: "GROOT"},
		{bus: "1001",type: "GROOT"},
		{bus: "1002",type: "GROOT"},
		{bus: "2000",type: "NORMAAL"},
		{bus: "2001",type: "NORMAAL"},
		{bus: "2002",type: "NORMAAL"},
		{bus: "2003",type: "NORMAAL"},
		{bus: "2004",type: "NORMAAL"},
		{bus: "2005",type: "NORMAAL"},
		{bus: "3000",type: "MINI"},
		{bus: "3001",type: "MINI"},
		{bus: "3002",type: "MINI"},
		{bus: "3003",type: "MINI"},
		{bus: "3004",type: "MINI"},
		{bus: "3005",type: "MINI"},
		{bus: "3006",type: "MINI"},
		{bus: "3007",type: "MINI"},
		{bus: "3008",type: "MINI"},
		{bus: "3009",type: "MINI"},
		{bus: "3010",type: "MINI"},
		{bus: "3011",type: "MINI"},
		{bus: "3012",type: "MINI"},
	],
	garage: {
		groot: [],
		medium: [],
		klein: []
	}
}

const requestOptions = {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json', // Set the content type to JSON
		// Add any other headers required by the API
	},
	body: JSON.stringify(input) // Convert data to JSON string
};

(function() {
	class Bus extends HTMLElement {
		constructor() {
			super();
			const shadow = this.attachShadow({mode: 'open'});

			const busNummer = this.bus;
			const type = this.type;

			shadow.innerHTML = `
				<div class="wagen" data-size="${type}">
					<p>${busNummer}</p>
				</div>
			`;
		}
	}
	customElements.define('bus', Bus);
})();

fetch(url, requestOptions)
		.then(response => response.json()) // Parse the JSON response
		.then(data => {
			// Functie om div-elementen toe te voegen aan de DOM
			function voegDivToe(busType, parent, busNummer) {
				// Maak een nieuw div-element
				const div = document.createElement("bus");

				// Stel de klasse in op basis van het type
				div.className = 'wagen';

				div.dataset.size = busType.toLowerCase();

				// Voeg inhoud toe aan het div-element
				div.innerHTML = `<p>${busNummer}</p>`;

				// Voeg het div-element toe aan de div met de klasse 'parkeerplaats_{type}'
				parent.appendChild(div);
			}

			// Loop door de garage en voeg div-elementen toe aan de DOM
			for (const type of Object.keys(data.garage)) {
					// Maak een div-element voor elk type en voeg het toe aan de DOM

					const busLot = document.querySelector(`.parkeerplaatsen[data-size='${type.toLowerCase()}']`);

					// Loop door de bussen van elk type en voeg div-elementen toe aan de DOM
					data.garage[type].forEach(bus => {
						voegDivToe(bus.type, busLot, bus.bus);
					});
				}
		})
		.catch(error => {
			console.error('Error:', error); // Handle any errors
		});
  

  