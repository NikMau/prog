package DB.DAO;

public class ListaOrdiniVuotaException extends Exception {
	
	public ListaOrdiniVuotaException() {
		super("\nNessun ordine presente nel sistema!.\n");
	}

}