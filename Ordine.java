package Entity;

import java.util.*;

public class Ordine{
	
	public Ordine() {
		
	}
	
	public Ordine(int id, String Stato, String dEmissione, String dEvasione, String dRitiro) {
		OrderNumber=id;
		stato=Stato;
		dataEmissione=dEmissione;
		dataEvasione=dEvasione;
		dataRitiro=dRitiro;
	}
	
	private int OrderNumber;
	
	private String stato;
	
	private String dataEmissione;
	
	private String dataEvasione;
	
	private String dataRitiro;
		
	
	public int getOrderNUmber() {
		return OrderNumber;
	}
	
	public String getStato() {
		return stato;
	}
}