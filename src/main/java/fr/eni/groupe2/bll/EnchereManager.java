package fr.eni.groupe2.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.groupe2.bo.ArticleVendu;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * EnchereManager permet la communication avec la couche DAL pour la lecture et l'enregistrement des données.
 * 
 *
 */
public class EnchereManager {

	// mes attibues
		private static  DAO<Enchere> enchereDAO= DAOFactory.getEnchereDAO();
		
		/**
		 * Méthode permettant de lister tous les enchères dans la base de données. 
		 * @return
		 * @throws DALException
		 * @throws BusinessException 
		 */
		public static List<Enchere> listerEnchere() throws DALException, BusinessException {
			return enchereDAO.selectAll();
		}
		
		
		/**
		 * Méthode permettant de lister tous les enchères d'un utilisateur avec leurs informations dans la base de données. 
		 * @return
		 * @throws DALException
		 * @throws BusinessException 
		 */
		public static List<Enchere> listerEnchereParPseudo(String pseudo) throws DALException, BusinessException{
			return EnchereDAOJdbcImpl.AfficherEncheresUtilisateursParPseudo(pseudo);
		}
		
		
		public static List<Enchere> listerEnchereParCategorie(String categorie) throws DALException, BusinessException{
			return EnchereDAOJdbcImpl.AfficherEncheresUtilisateursParCategorie(categorie);
		}
		
		public static List<Enchere> listerEnchereParMot(String mot) throws DALException, BusinessException{
			return EnchereDAOJdbcImpl.AfficherEncheresUtilisateursParMot(mot);
		}
		
		
		public Enchere insertEnchere(int noUtilisateur, int noArticle, Date dateEnchere, int montantEnchere) throws DALException {
			Enchere enchere = new Enchere();
			Utilisateur u= new Utilisateur();
			u.setNoUtilisateur(noUtilisateur);
			
			ArticleVendu a = new ArticleVendu(); 
			a.setNoArticle(noArticle);
			
			enchere.setUtilisateur(u);
			enchere.setArticle(a);
			enchere.setDateEnchere(dateEnchere);
			enchere.setMontantEnchere(montantEnchere);
			
			BusinessException exception = new BusinessException(null);
			EnchereDAOJdbcImpl enchereDAO = new EnchereDAOJdbcImpl();
			int noEnchere = 0;
			try {
				if(!(exception == null))
				{
					noEnchere = enchereDAO.insertEnchere(enchere);
				}
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Enchere enchereAvecNoEnchere = new Enchere();
			
			
			return enchere;
		}
		
		
}
