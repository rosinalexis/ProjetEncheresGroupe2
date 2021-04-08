package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnexion {

	private static final String URI=Settings.getProperty("url");
	private static final String USER=Settings.getProperty("user");
	private static final String PWD=Settings.getProperty("password");
	
	public static Connection seConnecter()throws Exception {
		Connection cnx = null;
	
		try {
			Class.forName(Settings.getProperty("driverjdbc"));
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}							
								
		try{							
															
			cnx = DriverManager.getConnection(URI, USER, PWD);						
		}							
		catch(SQLException e){							
			throw new Exception("Impossible d'obtenir une connexion : "+e.getMessage());											
		}							
		return cnx;							
	}	
	
	public static void seDeconnecter(Connection cnx, Statement stmt) throws Exception{								
		
		try {							
			stmt.close();						
		} catch (SQLException e) {							
			throw new Exception("Impossible de fermer le Statement : "+e.getMessage());						
									
		}							
		try {							
			cnx.close();						
		} catch (SQLException e) {							
			throw new Exception("Impossible de fermer la connexion : "+e.getMessage());						
									
		}							
	}								
									
	public static void seDeconnecter(Connection cnx, PreparedStatement pstmt) throws Exception{								
									
		try {							
			pstmt.close();						
		} catch (SQLException e) {							
			throw new Exception("Impossible de fermer le PreparedStatement : "+e.getMessage());						
									
		}							
		try {							
			cnx.close();						
		} catch (SQLException e) {							
			throw new Exception("Impossible de fermer la connexion : "+e.getMessage());						
									
		}							
	}								
}									
	

