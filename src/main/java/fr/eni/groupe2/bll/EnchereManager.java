package fr.eni.groupe2.bll;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.ListeEnchere;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * EnchereManager permet la communication avec la couche DAL pour la lecture et l'enregistrement des donn�es.
 * 
 *
 */
public class EnchereManager {

	// mes attibues
		private static  DAO<Enchere> enchereDAO= DAOFactory.getEnchereDAO();
		
		/**
		 * M�thode permettant de lister tout les ench�res dans la base de donn�es. 
		 * @return
		 * @throws DALException
		 */
		public static List<Enchere> listerEnchere() throws DALException {
			
			return enchereDAO.selectAll();
		}
		
		
		/**
		 * M�thode permettant de lister tout les ench�res  avec leurs informations dans la base de donn�es. 
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

		public Enchere insertEnchere(int noUtilisateur, int noArticle, Date dateEnchere, int montantEnchere) throws DALException {
			Enchere enchere = new Enchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
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
			Enchere enchereAvecNoEnchere = new Enchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
			
			return enchereAvecNoEnchere;
		}
		
		
}
