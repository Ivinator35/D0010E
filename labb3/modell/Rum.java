package labb3.modell;

import java.awt.Color;

public class Rum {

	// TODO: Lägg till tillståndsvariabler.

	protected int bredd;
	protected int höjd;
	protected int övX;
	protected int övY;
	protected Color golvfärg;

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
		this.bredd = bredd;
		this.höjd = höjd;
		this.övX = övX;
		this.övY = övY;

		// TODO: Kopiera parametrarna in i tillståndsvariablerna. (övX,övY) är
		// koordinaten för rummets övre vänstra hörn och lagras lämpligen som en
		// instans av klassen Punkt i paketet verktyg.
	}

	public Color getGolvfärg(){
		return golvfärg;
	}

	public int getBredd(){
		return bredd;
	}

	public int getHöjd(){
		return höjd;
	}

	public int getÖvX(){
		return övX;
	}

	public int getÖvY(){
		return övY;
	}


	public boolean finnsUtgångÅt(Väderstreck väderstreck){
		if(finnsengång){
			return true;
		}
		else{
			return false;
		}
	}

	// TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
	// värden.

	// TODO: Skriv instansmetoden
	//
	// finnsUtgångÅt(Väderstreck väderstreck)
	//
	// som ska kontrollera om det från ett rum finns en utgång åt visst
	// väderstreck.


	
	// TODO: Skriv instansmetoden
	//
	// Gång gångenÅt(Väderstreck väderstreck) som
	//
	// returnerar den gång som leder från ett rum i riktning väderstreck. Om
	// sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.

	// TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.

	public Gång gångenÅt(Väderstreck väderstreck){
		if(gång.getRIIT() == ){
			
		}
	}


	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
			Rum till, Väderstreck riktningInITill) {
	}
}
