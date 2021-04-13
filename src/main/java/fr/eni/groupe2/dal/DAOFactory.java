package fr.eni.groupe2.dal;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * 
 * @author groupe 2 
 * @projet PROJET ENI ENCHERES AVRIL 2021
 * 
 * @description DAOFactory responsable de l'instanciation de UtilisateurDAOJdvcImpl qui lui premet la communication à la base de données.
 */
public class DAOFactory {

	public static DAO<Utilisateur> getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
