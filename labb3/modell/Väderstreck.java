package D0010E.labb3.modell;

public enum Väderstreck {
	NORR(index: 0), ÖSTER(index: 1), SÖDER(index: 2), VÄSTER(index: 3);

	protected int value;

	public Väderstreck(int value){
		this.value = value;
	}

	int index(){
		return this.value;
	}
	// TODO: Lägg till en konstruktor som tar ett heltal och sparar det i 
	// en dold heltalsvariabel (en instansvariabel). Skriv en instansmetod
	// index() som returnerar heltalsvariabeln. Ändra de fyra väderstrecken 
	// så att 
	// 
	// NORR.index() returnerar 0, 
	// ÖSTER.index() returnerar 1,
	// SÖDER.index() returnerar 2 och 
	// VÄSTER.index() returnerar 3. 
}
