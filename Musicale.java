package Entity;

import java.util.*;

public class Musicale extends Giocattolo{
	
	//DConstructor
	public Musicale() {
		
	}
	
	public Musicale(String TStrumento) {
		tipoStrumento=TStrumento;
	}
	
	//Private Variable
	private String tipoStrumento;
	
	//Get e Set non mi servono in questo caso
}