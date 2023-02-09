package labb3.modell;

import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;

import java.util.ArrayList;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util.
public class Nivå extends java.util.Observable {

    public ArrayList<Rum> rum = new ArrayList<>();

    protected Rum startrum;

    private Punkt playerPos;

    protected int count = 0;

    // TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
    // i vilket rum som användaren "är".

    public Nivå(Rum startrum, ArrayList<Rum> rum) throws Exception {

        // TODO: Kopiera in startrum och rum in i tillståndsvariablerna.

        this.startrum = startrum;
        this.rum = rum;
        this.playerPos = new Punkt(startrum.getÖvX()/2, startrum.getÖvY()/2);
        // TODO: Kontrollera att startrum finns med i rum. Om inte, kasta
        // undantag med lämpligt felmeddelande.

        for(int i = 0; i < rum.size(); i++){
            if(rum.get(i) == startrum){
                count++;
            }
        }
        if(count <= 0){
            throw new Exception("Start rummet finns inte i nivån");
        }

        // TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
        // fallet, kasta undantag med lämpligt felmeddelande.

        for(int i = 1; i < rum.size(); i++){
            if(rum.get(i).getÖvX() == rum.get(i-1).getÖvX() && rum.get(i).getÖvY() == rum.get(i-1).getÖvY()  ){
                throw new Exception("Det finns rum i nivån som överlappar");
            }
        }

    }

    // TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
    // Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.



    // TODO Skriv en instansmetod som returnerar en referens till det rum som
    // användaren "är i".

    public Rum getPlayerPos() throws Exception {
        int tempX = playerPos.x();
        int tempY = playerPos.y();

        for(int i = 0; i < rum.size(); i++){
            if(tempX == (rum.get(i).getÖvX() / 2) && tempY == (rum.get(i).getÖvY() / 2)){
                return rum.get(i);
            }
        }
        throw new Exception("Det finns ingen spelare i nivån");
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
        try{
            if (getPlayerPos().finnsUtgångÅt(väderstreck)) {
                Gång tempGång = getPlayerPos().gångenÅt(väderstreck);
                Rum newRum = tempGång.getTill();
                playerPos = new Punkt((newRum.getÖvX() / 2), (newRum.getÖvY() / 2) );
            }
        }
		catch (Exception e) {}
    }


}
