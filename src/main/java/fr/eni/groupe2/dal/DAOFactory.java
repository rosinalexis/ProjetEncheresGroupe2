package fr.eni.groupe2.dal;

import fr.eni.groupe2.bo.ArticleVendu;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * 
 * @author groupe 2 
 * @projet PROJET ENI ENCHERES AVRIL 2021
 * 
 * @description DAOFactory responsable de l'instanciation d'un DAOJdvcImpl qui lui premet la communication à la base de données.
 */
public class DAOFactory {

	public static DAO<Utilisateur> getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static DAO<Enchere> getEnchereDAO(){
		return new EnchereDAOJdbcImpl(); 
	}
	
	public static DAO<ArticleVendu> getArticleVenduDAO(){
		return new ArticleVenduDAOJdbcImpl();
	}
}
