package Entity;

import java.util.*;

public class Trenino extends Giocattolo{
	
	//DConstructor
	public Trenino() {
		
	}
	
	//EConstructor
	public Trenino (int lunghezza) {
		lunghezzaCircuito=lunghezza;
	}
	
	//Private Variable
	private int lunghezzaCircuito;
	
	//Get e Set non mi servono in questo caso
}