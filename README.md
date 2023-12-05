# Finale Beste Developer Challenge De Lijn - Team 6

Dit project omvat de finale opdracht van de Beste Developer Challenge van De Lijn. Het doel van deze opdracht is om een applicatie te ontwikkelen die een optimale manier berekend om de bussen die op de parking staan in de verschillende stelplaatsen te plaatsen.

Er zijn 3 types bussen:
- Grote bussen
- Normale bussen
- Minibussen

Grote bussen hebben een lengte van 2 normale bussen, normale bussen hebben een lengte van 2 minibussen. 

De garage heeft 3 busparkings:
- Grote parking: 4 plaatsen voor grote bussen
- Medium parking: 6 plaatsen voor normale bussen
- Kleine parking: 12 plaatsen voor minibussen

== API ==

https://pastebin.com/9W0Rcr6j

=== Input ===
```javascript
{
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
```
=== GEWENSTE OUTPUT ===
```js
{
    stelplaats: "De Lijn Arsenaal",
    parking: [],
    garage: {
        groot: [
            {bus: "1000",type: "GROOT"},
            {bus: "1001",type: "GROOT"},
            {bus: "1002",type: "GROOT"},
            {bus: "2000",type: "NORMAAL"},
            {bus: "2001",type: "NORMAAL"}
        ],
        medium: [
            {bus: "2002",type: "NORMAAL"},
            {bus: "2003",type: "NORMAAL"},
            {bus: "2004",type: "NORMAAL"},
            {bus: "2005",type: "NORMAAL"},
            {bus: "3000",type: "MINI"},
            {bus: "3001",type: "MINI"},
            {bus: "3002",type: "MINI"},
            {bus: "3003",type: "MINI"}		
        ],
        klein: [
            {bus: "3004",type: "MINI"},
            {bus: "3005",type: "MINI"},
            {bus: "3006",type: "MINI"},
            {bus: "3007",type: "MINI"},
            {bus: "3008",type: "MINI"},
            {bus: "3009",type: "MINI"},
            {bus: "3010",type: "MINI"},
            {bus: "3011",type: "MINI"},
            {bus: "3012",type: "MINI"}		
        ]
    }
}
 ```