package fr.eni.groupe2.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>Classe</strong> metier permettant d'instancier un object de
 * ArticleVendu
 * 
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe ArticleVendu permet de
 *              renseigner les informations d'un article.
 */
public class ArticleVendu implements Serializable {

	private static final long serialVersionUID = 1L;

	// mes attribues
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private String etatVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	private Retrait retrait; 
	
	
	//methode 
	/**
	 * Constructeur par défault
	 */
	public ArticleVendu() {
	}

	/**
	 * Le constructeur surchargé permettant d'instancier un object de type
	 * ArticleVendu en hydratant les attribus ci-dessous
	 * 
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param utilisateur       : une instance d'Utilisateur
	 * @param categorie         : une instance Categorie
	 * @param retrait           : une instance de Retrait
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int prixVente, Utilisateur Utilisateur, Categorie categorie,Retrait retrait) {

		setNomArticle(nomArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setUtilisateur(Utilisateur);
		setCategorie(categorie);
	}

	/**
	 * Le constructeur surchargé permettant d'instancier un object de type
	 * ArticleVendu en hydratant les attribus ci-dessous
	 * 
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param etatVente
	 * @param utilisateur       : une instance d'Utilisateur
	 * @param categorie         : une instance Categorie
	 * @param retrait           : une instance de Retrait
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int prixInitial, int prixVente, String etatVente, Utilisateur utilisateur,
			Categorie categorie,Retrait retrait) {

		this(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, utilisateur,
				categorie,retrait);
		setEtatVente(etatVente);
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + getNoArticle() + ", nomArticle=" + getNomArticle() + ", description="
				+ getDescription() + ", dateDebutEncheres=" + getDateDebutEncheres() + ", dateFinEncheres="
				+ getDateFinEncheres() + ", prixInitial=" + prixInitial + ", prixVente=" + getPrixVente()
				+ ", etatVente=" + getEtatVente() + ", utilisateur=" + getUtilisateur() + ", categorie="
				+ getCategorie() +",retrait="+getRetrait()+ "]";
	}

	
	


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur noUtilisateur) {
		this.utilisateur = noUtilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	public Retrait getRetrait() {
		return retrait;
	}

	
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
}
