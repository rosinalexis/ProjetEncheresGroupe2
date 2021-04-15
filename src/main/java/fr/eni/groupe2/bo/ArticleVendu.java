package fr.eni.groupe2.bo;

import java.io.Serializable;
import java.util.Date;

/**
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
	private int noUtilisateur;
	private int noCategorie;

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
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie ) {
		
		setNomArticle(nomArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setNoUtilisateur(noUtilisateur);
		setNoCategorie(noCategorie);
	}

	/**
	 * Le constructeur surchargé permettant d'instancier un object de type
	 * ArticleVendu en hydratant les attribus ci-dessous
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param prixInitial
	 * @param prixVente
	 * @param etatVente
	 * @param noUtilisateur
	 * @param noCategorie
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres,
			Date dateFinEncheres, int prixInitial, int prixVente, String etatVente, int noUtilisateur,
			int noCategorie) {
		
		this(nomArticle, description, dateDebutEncheres,dateFinEncheres,prixInitial,prixVente,noUtilisateur,noCategorie);
		
		setNoArticle(noArticle);
		setEtatVente(etatVente); 
	}


	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
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


	public int getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public int getNoCategorie() {
		return noCategorie;
	}


	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", noUtilisateur="
				+ noUtilisateur + ", noCategorie=" + noCategorie + "]";
	}






}
