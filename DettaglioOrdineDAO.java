package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DB.DBManager;
import Entity.DettaglioOrdine;

public class DettaglioOrdineDAO{
	
	//DConstructor
	public DettaglioOrdineDAO() {
		
	}
	
	//Non scrivo le funzioni che non mi servono per risparmiare tempo
	
	public static LinkedList<DettaglioOrdine> ottieniDettaglioOrdine(int id) throws ListaDettaglioOrdiniVuotaException{
		LinkedList<DettaglioOrdine> DettaglioO=new LinkedList<DettaglioOrdine>();
		
		  try {
	            Connection conn = DBManager.getConnection();
	            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DETTAGLIO_ORDINI WHERE ID_ORDINE="+id);
	            ResultSet rs = stmt.executeQuery();
	            if (!rs.isBeforeFirst()) {    
	            	throw new ListaDettaglioOrdiniVuotaException();
	            } 	            
	            while(rs.next()){
					DettaglioOrdine dettOrd= new DettaglioOrdine(rs.getInt("ID_ORDINE"),rs.getInt("NUM_TRENINI"),rs.getInt("NUM_CAVALLI"),rs.getInt("NUM_MUSICALI"));
					DettaglioO.add(dettOrd);
	            }
	            
	             
	      }
		  catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	      try {
	    	  	DBManager.closeConnection();
	        }
	      catch (SQLException e) {
	    	  	e.printStackTrace();
	    	}
		
		return DettaglioO;
	}
}