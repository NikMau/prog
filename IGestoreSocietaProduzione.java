package Controller;

import java.sql.SQLException;
import java.util.*;
import Entity.*;
import DB.DAO.*;

public interface IGestoreSocietaProduzione{
	
	public void inserisciOrdine(int OrderNumber, String dataEmissione);
	
	public String visualizzaStatoOrdine(int OrderNumber) throws ListaOrdiniVuotaException;
	
	public LinkedList<Giocattolo> richiediListaGiocattoliDisponibili();
	
	public void registraDistributore(int id, String nome, String cognome);
	
	public void aggiornaProdottiMagazzino(int id, int quantita);
	
	public boolean modificaStatoOrdine(int idOrdine, String Stato) throws ListaDettaglioOrdiniVuotaException;
	
	public boolean effettuaRegistrazioneNewsletterMensile();
}