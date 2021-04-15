package fr.eni.groupe2.bo;

import java.io.Serializable;

import fr.eni.groupe2.messages.BusinessException;

/**
 * 
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe Utilisateur permet de
 * renseigner les informations d'un utilisateur.
 *
 */
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	//autre 
	

	/**
	 * le constructeur par default
	 */
	public Utilisateur() {
	}

	// Les constructeurs
	/**
	 * Le constructeur surchargé permettant d'instancier un object de type Utilisateur en hydratant les attribus ci-dessous   
	 * 
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @throws BusinessException : propagation d'une exception de type Metier.
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) throws BusinessException {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setAdministrateur(false); 
		setCredit(0); 
	}
	
	/**
	 * Le constructeur surchargé permettant d'instancier un object de type Utilisateur en hydratant les attribus ci-dessous
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
	 * @param credit
	 * @param administrateur
	 * @throws BusinessException : propagation d'une exception de type Metier.
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException {
		
		this(pseudo,nom, prenom,email,telephone,rue,codePostal,ville, motDePasse);
		setNoUtilisateur(noUtilisateur); 
		setCredit(credit);
		setAdministrateur(administrateur);
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

	/**
	 * Méthode  de type mutateur permettant d'hydrater l'attribut pseudo d'un utilisateur. 
	 * @param pseudo : le pseudo de l'utilisateur de type string.
	 * @throws BusinessException : retroune une exception de type metier. 
	 */
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
	
	/**
	 *Methode  de type mutateur permettant d'hydrater l'attribut nom d'un utilisateur.
	 * @param nom : le nom de l'utilisateur  est de type string. 
	 * @throws BusinessException : retourne une exception de type metier. 
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut prénom d'un utilisateur. 
	 * @param prenom : le prenom de l'utilisateur est de type string. 
	 * @throws BusinessException : retourne une exception de type metier.
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut email de l'utilisateur. 
	 * @param email : l'email de l'utilisateur est de type string. 
	 * @throws BusinessException : retourne une exception de type metier. 
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut téléphone de l'utilisateur. 
	 * @param telephone : télépone est de type string. 
	 * @throws BusinessException : retourne une exception de type businessObject.
	 */
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
	
	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut rue d'un utilisateur. 
	 * @param rue : la rue est de type string. 
	 * @throws BusinessException : retourne une exception de type metier.
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut codePostal d'un utilisateur.
	 * @param codePostal : le code postal est de type string. 
	 * @throws BusinessException : retourn une exception de type metier. 
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut ville d'un utilisateur. 
	 * @param ville : la ville est d etype string. 
	 * @throws BusinessException : retourn une expcetion de type metier.
	 */
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

	/**
	 * Methode  de type mutateur permettant d'hydrater l'attribut mot de passe d'un utilisateur. 
	 * @param motDePasse : le mot de passe est de type string. 
	 * @throws BusinessException : retourn une exception de type metier. 
	 */
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

	/**
	 * Methode de type mutateur permettant d'hydrater l'attribut crédit d'un utilisateur.
	 * @param credit : le crédit de l'utilisateur.
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	/**
	 * Methode de type mutateur permettant d'hydrater l'attribut administrateur d'un utilisateur
	 * @param administrateur
	 */
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
