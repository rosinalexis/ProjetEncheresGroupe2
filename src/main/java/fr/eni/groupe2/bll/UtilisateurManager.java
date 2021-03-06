package fr.eni.groupe2.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * 
 * @author groupe 2 
 * UtilisateurManager permet la communication avec la couche DAL pour la lecture et l'enregistrement des donn?es
 * 
 *
 */
public class UtilisateurManager {

	// mes attibues
	private static  DAO<Utilisateur> utilisateurDAO= DAOFactory.getUtilisateurDAO();
	 
	/**
	 * ajouterUtilisateur v?rifie l'existance  et ajoute un utilisateur ? la base.
	 * @param utilisateur
	 * @return
	 * @throws DALException
	 * @throws BusinessException 
	 */
	public static boolean ajouterUtilisateur(Utilisateur utilisateur) throws DALException, BusinessException  {
		boolean ok  = false ; 
		
		List<Utilisateur> utilisateurs  =  new ArrayList<Utilisateur>(); 
		utilisateurs = listerUtlisateur(); 
		
		//v?rification avant insertion pour ?viter les doublons  
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
	 * @throws BusinessException 
	 */
	public  static List<Utilisateur> listerUtlisateur () throws DALException, BusinessException{
		return utilisateurDAO.selectAll();	
	}

	/**
	 * rechercherUtilisateur permet de rechercher un utilisateur en base via son ID.
	 * @throws DALException
	 * @throws BusinessException 
	 */
	public static Utilisateur rechercherUtilisateur(int id) throws DALException, BusinessException {
			return utilisateurDAO.selectByID(id); 
	}


	/**
	 * modificationUtilisateur permet de mettre ? jour les donn?es d'un utilisateur.
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param motDePasseBis
	 * @param credit
	 * @param administrateur
	 * @return
	 */
	public Utilisateur modificationUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom,
			String email, String telephone, String rue, String codePostal, String ville, String motDePasse,
			String motDePasseBis, int credit, boolean administrateur) {
		Utilisateur utilisateur = null;
		try {
			utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
					ville, motDePasse, credit, administrateur);
			DAOFactory.getUtilisateurDAO().update(utilisateur);
			return utilisateur;
		} catch (BusinessException | DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}
}


