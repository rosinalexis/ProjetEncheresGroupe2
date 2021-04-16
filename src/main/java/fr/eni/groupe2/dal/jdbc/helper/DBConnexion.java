package fr.eni.groupe2.dal.jdbc.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * @projet PROJET ENI ENCHERES AVRIL 2021
 * 
 * @description DBConnexion est une classe helper qui permet d'initier la connexion et la déconnexion à la base de données.
 */
public class DBConnexion {
	
	private static final String URI=Settings.getProperty("url");
	private static final String USER=Settings.getProperty("user");
	private static final String PWD=Settings.getProperty("password");
	
	//initie la connexion à la base de données
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
	
	//permet la déconnexion à la base de données lors d'une requet de type stmt  
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
					
	
	//permet la déconnexion à la base de données lors d'une requête préparé
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
	

