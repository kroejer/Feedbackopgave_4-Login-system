**Feedbackopgave 4 - Login-system**  

**Gruppemedlemmer:**  
Jonas, Oliver, Valdemar og Kasper

**Projektbeskrivelse:**  
Vi har bygget et program der har 2 arrays med 4 brugernavne og
4 adgangskoder, som modtager input fra brugeren sådan at hvis brugeren
kender et brugernavn og en adgangskode der passer sammen i systemet,
så bliver de logget ind. Hvis de taster brugernavnet forkert så lukker 
programmet, og hvis de taster adgangskoden forkert 3 gange, så lukker
programmet også. Hvis de taster begge ting rigtigt så bliver de lukket 
ind og får en velkomstbesked med tidspunkt for login.

**Hvordan køres programmet:**  
Programmet køres via main og fem metoder som vi har oprettet.
Metoderne kaldes i main, og den ene metode kalder også på de 4 andre.


**Metoder vi har implementeret:**  
**inputUsername**  
**validateUsername**  
**inputPassword**  
**validatePassword**  
**loginAttempt**  


**Udfordringer ved projektet:**  
Det var en udfordring at få flyttet vores while loop over i en metode
på en fornuftig måde.  
Det var en udfordring at få tidsviseren til at fungere ordentligt.

**Tests vi har lavet:**  
Vi har testet alle fire brugernavne med alle fire adgangskoder for at
sikre os at det kun er adgangskoden på plads 1 der virker med
brugernavnet på plads 1.  
Vi har testet hvordan programmet reagerer med forkert brugernavn, 
hvordan det reagerer med korrekt brugernavn men forkert adgangskode,
og hvordan programmet reagerer med korrekt brugernavn og korrekt 
adgangskode.