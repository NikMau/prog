package Controller;

import java.sql.SQLException;
import java.util.*;
import Entity.*;
import DB.DAO.*;

public class GestoreSocietaProduzione implements IGestoreSocietaProduzione {

	//DConstructor
    public GestoreSocietaProduzione() {
    }
    
    //Singleton
    private static GestoreSocietaProduzione Istanza;
    public static GestoreSocietaProduzione getIstanza() {
		if (Istanza == null)
			Istanza  = new GestoreSocietaProduzione();
		return Istanza;
    }
    
    //Funzione principale per modifcare lo stato di un ordine
    public boolean modificaStatoOrdine(int idOrdine, String Stato) throws ListaDettaglioOrdiniVuotaException{
    	
    	OrdineDAO.updateStato(idOrdine,Stato);
    	if(!Stato.equals("EVASO") && !Stato.equals("NON EVASO") && !Stato.equals("RITIRATO")) {
    		return false;
    	}
    	
    	//Se lo stato passa da NON EVASO ad EVASO
    	//il sistema aggiorna le quantità in magazzino 
    	//in base alle quantià indicate nel dettaglio ordine
    	if(Stato.equals("EVASO")) {
    		
    		LinkedList<DettaglioOrdine> DettOrdine = DettaglioOrdineDAO.ottieniDettaglioOrdine(idOrdine);
    		
    		for(DettaglioOrdine dOrd : DettOrdine) {
    			
    			int numTrenini = dOrd.getNumTrenini();
    			int numCavalli = dOrd.getNumCavalli();
    			int numMusicali = dOrd.getNumMusicali();
    		
    		
    			if(numTrenini>0) {
    				int QtaMag = GiocattoloDAO.ottieniQtaMagT();
    				QtaMag = QtaMag-numTrenini;
    				GiocattoloDAO.aggiornaQtaMagT(QtaMag);
    				System.out.println("QtaT aggiornata in magazzino:"+QtaMag);
    			}
    			if(numCavalli>0) {
    				int QtaMag = GiocattoloDAO.ottieniQtaMagC();
    				QtaMag = QtaMag-numCavalli;
    				GiocattoloDAO.aggiornaQtaMagC(QtaMag);
    				System.out.println("QtaC aggiornata in magazzino:"+QtaMag);
    			}
    			if(numMusicali>0) {
    				int QtaMag = GiocattoloDAO.ottieniQtaMagM();
    				QtaMag = QtaMag-numMusicali;
    				GiocattoloDAO.aggiornaQtaMagM(QtaMag);
    				System.out.println("QtaM aggiornata in magazzino:"+QtaMag);
    			}
    		}
    	}
    	return true;
    }

	@Override
	public void inserisciOrdine(int OrderNumber, String dataEmissione) {
		// TODO Auto-generated method stub
		
	}

	//Funzione che ci permette di visualizzare lo stato di qualsiasi ordine
	public String visualizzaStatoOrdine(int OrderNumber) throws ListaOrdiniVuotaException {
		String Stato=OrdineDAO.ottieniStatoOrdine(OrderNumber);
		return Stato;
	}

	@Override
	public LinkedList<Giocattolo> richiediListaGiocattoliDisponibili() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registraDistributore(int id, String nome, String cognome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggiornaProdottiMagazzino(int id, int quantita) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean effettuaRegistrazioneNewsletterMensile() {
		// TODO Auto-generated method stub
		return false;
	}
}