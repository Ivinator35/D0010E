package labb3.modell;

public class Gång {

    // TODO: Lägg till tillståndsvariabler för att hålla parametrarna till
    // konstruktorn.

    protected Rum från;
    protected Väderstreck riktningUtUrFrån;
    protected Rum till;
    protected Väderstreck riktningInITill;

    public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
                Väderstreck riktningInITill) {

        this.från = från;
        this.riktningUtUrFrån = riktningUtUrFrån;
        this.till = till;
        this.riktningInITill = riktningInITill;

        // TODO: Tilldela tillståndsvariablerna parametervärdena.
    }

    public Rum getFrån(){
        return från;
    }

    public Väderstreck getRUUF(){
        return riktningUtUrFrån;
    }

    public Rum getTill(){
        return till;
    }

    public Väderstreck getRIIT(){
        return riktningInITill;
    }
    // TODO: Lägg till instansmetoder som returnerar tillståndsvariablernas
    // värden.
}
