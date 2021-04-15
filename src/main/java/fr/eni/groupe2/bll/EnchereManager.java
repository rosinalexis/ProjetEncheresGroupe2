package fr.eni.groupe2.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.ListeEnchere;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
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
		 * Méthode permettant de lister tout les enchères dans la base de données. 
		 * @return
		 * @throws DALException
		 */
		public static List<Enchere> listerEnchere() throws DALException {
			
			return enchereDAO.selectAll();
		}
		
		
		/**
		 * Méthode permettant de lister tout les enchères  avec leurs informations dans la base de données. 
		 * @return
		 * @throws DALException
		 */
		public static List<ListeEnchere> afficherEnchere() throws DALException{
			List<ListeEnchere> listeEncheres = new ArrayList<ListeEnchere>();
			List<Enchere> liste = new ArrayList<Enchere>(); 
			liste  =listerEnchere();
			
			for (Enchere e : liste) {
				
				int noUtilisateur = e.getNoUtilisateur();
				int noArticle = e.getNoArticle(); 
				
				ListeEnchere ListeEnchereTrans= new ListeEnchere();
				ListeEnchereTrans =EnchereDAOJdbcImpl.listerEncheres(noUtilisateur, noArticle);
				
				listeEncheres.add(ListeEnchereTrans); 
			}
			
			return listeEncheres;
		}
		
		
}
