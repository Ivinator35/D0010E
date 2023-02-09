package labb3.modell;

import labb3.modell.Väderstreck;
import labb3.verktyg.Punkt;

import java.util.ArrayList;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util.
public class Nivå extends java.util.Observable {

    public ArrayList<Rum> rum = new ArrayList<>();

    protected Rum startrum;

    private Rum playerPos;

    protected int count = 0;

    // TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
    // i vilket rum som användaren "är".

    public Nivå(Rum startrum, ArrayList<Rum> rum) throws Exception {

        // TODO: Kopiera in startrum och rum in i tillståndsvariablerna.

        this.startrum = startrum;
        this.rum = rum;
        this.playerPos = startrum;
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
        return playerPos;
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
                playerPos = playerPos.gångenÅt(väderstreck).getTill();
                setChanged();
                notifyObservers();
            } catch (Exception ex) { }
    }
}
