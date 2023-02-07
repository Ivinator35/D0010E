package labb3.modell;

import java.util.ArrayList;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util. 
public class Nivå extends Observable {

	ArrayList<Rum> rList = new ArrayList()<>;

	protected Rum startrum;

	protected int count = 0;

	// TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
	// i vilket rum som användaren "är".

	public Nivå(Rum startrum, ArrayList<Rum> rum) {

		// TODO: Kopiera in startrum och rum in i tillståndsvariablerna.

		this.startrum = startrum;
		this.rList = rum;
		
		// TODO: Kontrollera att startrum finns med i rum. Om inte, kasta
		// undantag med lämpligt felmeddelande.
		
		for(int i = 0; i < rList.length; i++){
			if(rum[i] == startrum){
				count++;
			}
		}
		if(count <= 0){
			throw new Exception("Start rummet finns inte i nivån");
		}

		// TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
		// fallet, kasta undantag med lämpligt felmeddelande.

		for(int i = 1; i < rList.length; i++){
			if(rum[i].getÖvX == rum[i-1].getÖvX && rum[i].getÖvY == rum[i-1].getÖvY ){
				throw new Exception("Det finns rum i nivån som överlappar");
			}
		}

	}

	// TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
	// Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.

	

	// TODO Skriv en instansmetod som returnerar en referens till det rum som
	// användaren "är i".

	public Rum getPlayerPos(){
		for(int i = 0; i < rList.length; i++){
			if(playerPos.x == (rum[i].getÖvX / 2) && playerPos.y == (rum[i].getÖvY / 2)){
				return rum[i];
			}
		}
	}

	// TODO: Skriv klar instansmetoden hoppaÅt nedan så att den ändrar det rum
	// som användaren "är i" om det är möjligt genom att följa en gång från
	// rummet och i riktning väderstreck.
	//
	// Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
	// inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
	// metod använder kontrolldelen av programmet för att begära ett hopp till
	// angränsande rum efter att användaren tryckt på en tangent.)

	public void hoppaÅt(Väderstreck väderstreck) {
		
	}
}
