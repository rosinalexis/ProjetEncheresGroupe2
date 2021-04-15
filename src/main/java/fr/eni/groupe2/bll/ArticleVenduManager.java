package fr.eni.groupe2.bll;

import fr.eni.groupe2.bo.ArticleVendu;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * ArticleVenduManager permet la communication avec la couche DAL pour la lecture et l'enregistrement des données.
 * 
 *
 */
public class ArticleVenduManager {
	private static  DAO< ArticleVendu> articleVenduDAO= DAOFactory.getArticleVenduDAO();
	
	public static ArticleVendu rechercheArticleVendu(int id) throws DALException {
		
		return articleVenduDAO.selectByID(id);
	}
}
