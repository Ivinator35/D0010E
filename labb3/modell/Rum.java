package labb3.modell;

import java.awt.Color;

public class Rum {

	ArrayList<Rum> gList = new ArrayList()<>;

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


	// TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
	// värden.

	// TODO: Skriv instansmetoden
	//
	// finnsUtgångÅt(Väderstreck väderstreck)
	//
	// som ska kontrollera om det från ett rum finns en utgång åt visst
	// väderstreck.

	public boolean finnsUtgångÅt(Väderstreck väderstreck){
		
		for(int i = 0; i < gList.length; i++){
			if(gList[i].getRUUF == väderstreck){
				return true;
			}
		return false;
		

	}
	
	// TODO: Skriv instansmetoden
	//
	// Gång gångenÅt(Väderstreck väderstreck) som
	//
	// returnerar den gång som leder från ett rum i riktning väderstreck. Om
	// sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.

	public Gång gångenÅt(Väderstreck väderstreck){

		if(finnsUtgångÅt(väderstreck) == true){
			for(int i = 0; i < gList.length; i++){
				if(gList[i].getRUUF == väderstreck){
					return gList[i];
				}
			}
		}
		else{
			throw new Exception("Det finns ingen gång åt: " + väderstreck)
		}
	}

	// TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.

	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
			Rum till, Väderstreck riktningInITill) {
		
		gList.add(gång(från, riktningUtUrFrån, till, riktningInITill));
		gList.add(gång(till, riktningInITill, från, riktningUtUrFrån));
		//hej
	}
}
}
