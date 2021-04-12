package fr.eni.groupe2.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.DAOFactory;
import fr.eni.groupe2.messages.DALException;


public class UtilisateurManager {

	private static  DAO<Utilisateur> utilisateurDAO= DAOFactory.getUtilisateurDAO();
	
	public static boolean ajouterUtilisateur(Utilisateur utilisateur) throws DALException  {
		boolean ok  = false ; 
		
		List<Utilisateur> utilisateurs  =  new ArrayList<Utilisateur>(); 
		utilisateurs = listerUtlisateur(); 
		
		//v�rification avant insertion pour �viter les doublons  
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

	public  static List<Utilisateur> listerUtlisateur () throws DALException{
		return utilisateurDAO.selectAll();	
	}

	public static Utilisateur rechercherUtilisateur(int id) throws DALException {
		
			return utilisateurDAO.selectByID(id); 
	}

}

