package labb3.modell;

import java.awt.Color;
import java.util.ArrayList;

public class Rum {

	public ArrayList<Gång> gList = new ArrayList();

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
		this.golvfärg = golvfärg;

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

	public ArrayList<Gång> getGList(){
		return gList;
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
		
		for(int i = 0; i < gList.size(); i++) {
			if (gList.get(i).getRUUF() == väderstreck) {
				return true;
			}
		}
		return false;
	}
	
	// TODO: Skriv instansmetoden
	//
	// Gång gångenÅt(Väderstreck väderstreck) som
	//
	// returnerar den gång som leder från ett rum i riktning väderstreck. Om
	// sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.


	public Gång gångenÅt(Väderstreck väderstreck) throws Exception {

			for (int i = 0; i < this.gList.size(); i++) {
				if(this.gList.get(i).getRUUF() == väderstreck){
					return this.gList.get(i);
				}
			}

			throw new Exception("Det finns ingen gång åt: " + väderstreck);
	}


	// TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.

	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
								  Rum till, Väderstreck riktningInITill) {
		Gång g1 = new Gång(från, riktningUtUrFrån, till, riktningInITill);
		Gång g2 = new Gång(till, riktningInITill, från, riktningUtUrFrån);

		från.gList.add(g1);
		till.gList.add(g2);

		//hej
	}
}

