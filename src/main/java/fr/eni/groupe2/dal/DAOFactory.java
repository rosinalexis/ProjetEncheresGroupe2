package fr.eni.groupe2.dal;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static DAO<Utilisateur> getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
