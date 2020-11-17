package UI;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

import DB.DAO.ListaDettaglioOrdiniVuotaException;
import DB.DAO.ListaOrdiniVuotaException;
import Controller.GestoreSocietaProduzione;

public class ConsoleAddettoFornitura{
	
	public ConsoleAddettoFornitura() {
		
	}
	
	public ConsoleAddettoFornitura(BufferedReader cr, PrintWriter cw) {
		this.consoleReader = cr;
		this.consoleWriter = cw;
	}
	
	public BufferedReader consoleReader;

	public PrintWriter consoleWriter;
	
	//Ci permette di eseguire la funzionalità 1
	public int visualizzaStatoOrdine() throws ListaOrdiniVuotaException{
		GestoreSocietaProduzione gsp = GestoreSocietaProduzione.getIstanza();
		Scanner ID=new Scanner(System.in);
		System.out.println("Inserisci l'ID dell'ordine: ");
		int id=ID.nextInt();
		System.out.println("Stato ordine selezionato: "+gsp.visualizzaStatoOrdine(id));
		return id;
	}
	
	//Ci permette di eseguire la funzionalità 2
	private void modificaStatoOrdine() throws ListaOrdiniVuotaException, ListaDettaglioOrdiniVuotaException{
    	
		//Input necessari per la funzionalità ModificaStato (Evadi Ordine)
		int id=visualizzaStatoOrdine();
		Scanner Stato=new Scanner(System.in);
		System.out.println("Inserisci un nuovo stato per l'ordine indicato: ");
		String stato=Stato.nextLine();
		
		GestoreSocietaProduzione gsp = GestoreSocietaProduzione.getIstanza();
		
    		if(gsp.modificaStatoOrdine(id,stato))
    			consoleWriter.format("Stato modificato correttamente!\n\n");
    		else
    			consoleWriter.format("Impossibile modificare lo stato!\n\n");
    }
	
	
    //La ConsoleAddettoFornitura attraverso la seguente funzione,consente di visualizzare il menù a tendina 
	//che viene messo a disposizione dell'addetto che fa utilizzo del programma.	
	public void showConsoleAddettoFornitura() throws IOException, ListaOrdiniVuotaException, ListaDettaglioOrdiniVuotaException, SQLException {
		boolean keepAlive = true;

		while (keepAlive) {
			consoleWriter.format("Scegli operazione:\n");
			consoleWriter.format("0. Esci dal programma\n");
			consoleWriter.format("1. Visualizza lo stato di un ordine \n");
			consoleWriter.format("2. Modifica lo stato di un ordine \n");

			try {
				int optionValue = Integer.parseInt(consoleReader.readLine());
				switch (optionValue) {
				case 0:
					keepAlive = false;
					break;
				case 1:
					visualizzaStatoOrdine();
					break;
				case 2:
					modificaStatoOrdine();
					break;
				default:
					consoleWriter.format("Hai sbagliato numero... Riprova\n\n");
				}
			} catch (NumberFormatException e) {				
				consoleWriter.format("Non hai inserito un numero... Riprova\n\n");
			}

		}
	}
}