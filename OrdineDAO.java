package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DB.DBManager;
import Entity.Ordine;
import java.time.*;
import java.time.chrono.*;
import DB.DAO.ListaOrdiniVuotaException;

public class OrdineDAO{
	
	//DConstructor
	public OrdineDAO() {
		
	}
	
	//Non scrivo le funzioni che non mi servono per risparmiare tempo
	
	public static String ottieniStatoOrdine(int id) throws ListaOrdiniVuotaException{
		
		 String StatoOrdine="";
		 try {
	            Connection conn = DBManager.getConnection();
	            PreparedStatement stmt = conn.prepareStatement("SELECT STATO FROM ORDINI WHERE ORDERNUMBER="+id);
	            ResultSet rs = stmt.executeQuery();	       
	            if (!rs.isBeforeFirst()) {    
	            	throw new ListaOrdiniVuotaException();
	            } 
	            while(rs.next()){
					StatoOrdine = (rs.getString("STATO"));
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
		
		return StatoOrdine;
	}
	
	
	public static void updateStato(int id,String Stato){
		try {
			if(Stato.equals("EVASO") || Stato.equals("NON EVASO") || Stato.equals("RITIRATO")) {
				Connection conn = DBManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement("UPDATE ORDINI SET STATO = '"+Stato+"'WHERE ORDERNUMBER="+id);
				stmt.execute();
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
	}
}