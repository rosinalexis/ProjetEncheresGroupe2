package fr.eni.groupe2.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * UtilisateurManager permet la communication avec la couche DAL pour la lecture et l'enregistrement des données
 * 
 *
 */
public class UtilisateurManager {

	// mes attibues
	private static  DAO<Utilisateur> utilisateurDAO= DAOFactory.getUtilisateurDAO();
	 
	/**
	 * ajouterUtilisateur vérifie l'existance  et ajoute un utilisateur à la base.
	 * @param utilisateur
	 * @return
	 * @throws DALException
	 */
	public static boolean ajouterUtilisateur(Utilisateur utilisateur) throws DALException  {
		boolean ok  = false ; 
		
		List<Utilisateur> utilisateurs  =  new ArrayList<Utilisateur>(); 
		utilisateurs = listerUtlisateur(); 
		
		//vérification avant insertion pour éviter les doublons  
		for (Utilisateur utilisateurVerif : utilisateurs) {
			if (utilisateurVerif.getPseudo().equals(utilisateur.getPseudo())
					&&(utilisateurVerif.getNom().equals(utilisateur.getNom()))
					&&(utilisateurVerif.getPrenom().equals(utilisateur.getPrenom()))
					&&(utilisateurVerif.getEmail().equals(utilisateur.getEmail()))){
				 ok = false;
			}else {
				ok = true;
			}
		}
		if (ok) {
			utilisateurDAO.insert(utilisateur);
		}
		
		return ok;
	}

	
	/**
	 * listerUtilisateur permet de rendre la liste de tout les utilisateurs
	 * @throws DALException
	 */
	public  static List<Utilisateur> listerUtlisateur () throws DALException{
		return utilisateurDAO.selectAll();	
	}


	/**
	 * rechercherUtilisateur permet de rechercher un utilisateur en base via son ID.
	 * @throws DALException
	 */
	public static Utilisateur rechercherUtilisateur(int id) throws DALException {
			return utilisateurDAO.selectByID(id); 
	}

}


