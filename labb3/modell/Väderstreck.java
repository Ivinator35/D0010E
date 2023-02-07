package labb3.modell;

public enum Väderstreck {
	NORR, ÖSTER, SÖDER, VÄSTER;

	protected int tempIndex;

	public Väderstreck(int tempIndex){
		this.tempIndex = tempIndex;
	}

	public int index(){

		if(NORR){
			tempIndex = 0;
		}
		else if(ÖSTER){
			tempIndex = 1;
		}
		else if(SÖDER){
			tempIndex = 2;
		}
		else if(VÄSTER){
			tempIndex = 3;
		}

		return tempIndex;

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
