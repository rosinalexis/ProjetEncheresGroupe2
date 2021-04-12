package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.groupe2.messages.DALException;


public class DBConnexion {

	private static final String URI=Settings.getProperty("url");
	private static final String USER=Settings.getProperty("user");
	private static final String PWD=Settings.getProperty("password");
	
	public static Connection seConnecter()throws DALException {
		Connection cnx = null;
	
		try {
			
			Class.forName(Settings.getProperty("driverjdbc"));
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}							
								
		try{							
															
			cnx = DriverManager.getConnection(URI, USER, PWD);						
		}							
		catch(SQLException e){							
			throw new DALException("Impossible d'obtenir une connexion : "+e.getMessage());											
		}							
		return cnx;							
	}	
	
	public static void seDeconnecter(Connection cnx, Statement stmt) throws DALException{								
		
		try {							
			stmt.close();						
		} catch (SQLException e) {							
			throw new DALException("Impossible de fermer le Statement : "+e.getMessage());						
									
		}							
		try {							
			cnx.close();						
		} catch (SQLException e) {							
			throw new DALException("Impossible de fermer la connexion : "+e.getMessage());						
									
		}							
	}								
									
	public static void seDeconnecter(Connection cnx, PreparedStatement pstmt) throws DALException{								
									
		try {							
			pstmt.close();						
		} catch (SQLException e) {							
			throw new DALException("Impossible de fermer le PreparedStatement : "+e.getMessage());						
									
		}							
		try {							
			cnx.close();						
		} catch (SQLException e) {							
			throw new DALException("Impossible de fermer la connexion : "+e.getMessage());						
									
		}							
	}								
}									
	

