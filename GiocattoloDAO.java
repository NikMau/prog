package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DB.DBManager;
import Entity.Giocattolo;

public class GiocattoloDAO{
	
	public GiocattoloDAO() {
		
	}
	
	//Non scrivo le funzioni che non mi servono per risparmiare tempo
	
	public static int ottieniQtaMagT() {
		int QtaMagT=0;
		
		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Q_MAG FROM GIOCATTOLI WHERE ID='100'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	QtaMagT = (rs.getInt("Q_MAG"));
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
	
	return QtaMagT;
	}
	
	public static void aggiornaQtaMagT(int Qta) {

		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE GIOCATTOLI SET Q_MAG = '"+Qta+"'WHERE ID=100");
            stmt.execute();
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
	
	public static int ottieniQtaMagC() {
		int QtaMagC=0;
		
		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Q_MAG FROM GIOCATTOLI WHERE ID='101'");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	QtaMagC = (rs.getInt("Q_MAG"));
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
        DBManager.closeConnection();
        }
        catch (SQLException e) {
        e.printStackTrace();
    	}
	
	return QtaMagC;
	}
	
	public static void aggiornaQtaMagC(int Qta) {

		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE GIOCATTOLI SET Q_MAG = '"+Qta+"'WHERE ID=101");
            stmt.execute();
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

	public static int ottieniQtaMagM() {
		int QtaMagM=0;
		
		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT Q_MAG FROM GIOCATTOLI WHERE ID='102'");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	QtaMagM = (rs.getInt("Q_MAG"));
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
        DBManager.closeConnection();
        }
        catch (SQLException e) {
        e.printStackTrace();
    	}
	
	return QtaMagM;
	}

	public static void aggiornaQtaMagM(int Qta) {

		try {
            Connection conn = DBManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE GIOCATTOLI SET Q_MAG = '"+Qta+"'WHERE ID=102");
            stmt.execute();
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