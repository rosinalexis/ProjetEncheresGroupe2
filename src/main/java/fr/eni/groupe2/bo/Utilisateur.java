package fr.eni.groupe2.bo;

import fr.eni.groupe2.db.BusinessException;

/**
 * 
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe Utilisateur permet de
 *              renseigner les informations d'un utilisateur.
 *
 */
public class Utilisateur {

	// les attribus d'un utilisateur
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;

	// Constructeur vide
	public Utilisateur() {
	}

	// Constructeur avec paramètres
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.administrateur = false; 
		this.credit = 0; 
	}
	
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		
		this(pseudo,nom, prenom,email,telephone,rue,codePostal,ville, motDePasse);
		this.noUtilisateur  = noUtilisateur; 
		this.credit = credit;
		this.administrateur =administrateur;
	}
	

	// Getters et Setters
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {

		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {

		return pseudo;
	}

	public void setPseudo(String pseudo) throws BusinessException {

		if (pseudo.isEmpty()) {
			throw new BusinessException("le pseudo est vide !");
		} 
		else if (pseudo.length()>30) {
			throw new BusinessException("le pseudo est invalide !");
		}
		else {

			this.pseudo = pseudo;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws BusinessException {

		if (nom.isEmpty()) {
			throw new BusinessException("le nom est vide !");
		} 
		else if (nom.length()>30) {
			throw new BusinessException("le nom n'est pas valide!");
		}
		else {
			this.nom = nom;
		}
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws BusinessException {
		
		if (prenom.isEmpty()) {
			
			throw new BusinessException("le prenom est vide !");
		} 
		else if (prenom.length()>30) {
			throw new BusinessException("le prenom est invalide !");
		}
		else {
			this.prenom = prenom;
		}

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws BusinessException {

		if (email.isEmpty()) {
			throw new BusinessException("l'email est vide !");
		} 
		else if( email.length()>30) {
			
			throw new BusinessException("l'email est invalide  !");
		}
		else {
			this.email = email;
		}

	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) throws BusinessException {

		if (telephone.isEmpty()) {
			throw new BusinessException("le téléphone est vide !");
		}
		else if(telephone.length()>15) {
			throw new BusinessException("le numéro de téléphone n'est pas valide  !");
		}
		else {
			this.telephone = telephone;
		}

	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) throws BusinessException {

		if (rue.isEmpty()) {
			throw new BusinessException("la rue est vide !");
		} 
		else if (rue.length() > 30) {
			throw new BusinessException("la rue n'est pas valide!");
		}
		else {
			this.rue = rue;
		}

	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) throws BusinessException {
		if (codePostal.isEmpty()) {
			throw new BusinessException("le code postal est vide !");
		} 
		else if (codePostal.length()>10) {
			throw new BusinessException("le code postal n'est pas valide !");
		}
		else {
			this.codePostal = codePostal;
		}

	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) throws BusinessException {
		if (ville.isEmpty()) {
			
			throw new BusinessException("la ville est vide !");

		}
		else if (ville.length()>30){
			throw new BusinessException("le  nom de la ville n'est  pas valide !");
		}
		else {
			this.ville = ville;
		}

	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) throws BusinessException {
		if (motDePasse.isEmpty()) {
			throw new BusinessException("le mot de passe est vide !");
		} else {
			this.motDePasse = motDePasse;
		}

	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {

		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	// la méthode toString pour le débug de l'application
	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}

}
