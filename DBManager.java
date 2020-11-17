package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 */
public class DBManager {

	//Eccezione generata quando SQL Server restituisce un avviso o un errore (SQLExc)
    
	private static Connection conn;
    private final static String dbPath = "C:\\Users\\Nicola Mauriello\\eclipse-workspace\\Mauriello_Nicola_N46002996";
    private final static String url ="jdbc:h2:"+ dbPath;
    
    //Connessione al database h2
	public static Connection getConnection() throws SQLException{
		if (conn == null || conn.isClosed()){
			conn = DriverManager.getConnection(url, "nik", "");
		}
		return conn;
	}
	
	//Chiusura connessione
	public static void closeConnection() throws SQLException{
		if (conn != null && !conn.isClosed()){
			conn.close();
			conn=null;
		}
	}
}