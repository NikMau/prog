package Entity;

import java.util.*;

public class Giocattolo {

	//DConstructor
    public Giocattolo() {
    	
    }
    
    //EConstructor
    public Giocattolo(int idGiocattolo, String desc, int limiteEta, int Prezzo, int quantMagazzino) {
    	id=idGiocattolo;
    	descrizione=desc;
    	limiteInferioreEta=limiteEta;
    	prezzo=Prezzo;
    	quantitaInMagazzino=quantMagazzino;
    }
    
    public String toString() {
        return ("ID: "+id+" descrizione: "+descrizione+" L.Età: "+limiteInferioreEta+" Prezzo: "+prezzo+" In Magazzino: "+quantitaInMagazzino);
      }
    
    //Private Variable
    private int id;

    private String descrizione;

    private int limiteInferioreEta;

    private int prezzo;

    private int quantitaInMagazzino;
    
    
    //Get e Set ---> Implemento solo quelle che potrebbero servirmi
    public int getId() {
    	return id;
    }
    
    public int getQuantitaInMagazzino() {
    	return quantitaInMagazzino;
    }
    
    public void setQuantitaInMagazzino(int value) {
    	quantitaInMagazzino=value;
    }
    
    
}