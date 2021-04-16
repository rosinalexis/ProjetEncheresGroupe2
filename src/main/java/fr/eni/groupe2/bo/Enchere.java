package fr.eni.groupe2.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * <strong>Classe</strong> metier permettant d'instancier un object de type Enchere
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe Enchere permet de renseigner les informations d'une enchère.
 * 
 *
 */
public class Enchere implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// les attribues d'une enchère
	private Date dateEnchere; 
	private int montantEnchere;
	private Utilisateur utilisateur;
	private ArticleVendu article;
	
	
	/**
	 * Le constructeur par défault de ma classe. 
	 */
	public Enchere() {
		
	}
	
	
	/**
	 * Le constructeur surchargé permettant d'instancier un object de type enchère en hydratant les attribus ci-dessous
	 * @param dateEnchère : la date de l'enchère.
	 * @param montant_enchere  : le montant de l'enchère.
	 */
	public Enchere(Date dateEnchere, int montantEnchere) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
	}

	
	/**
	 * Le constructeur surchargé permettant d'instancier un object de type enchère en hydratant les attribus ci-dessous
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noUtilisateur
	 * @param noArticle
	 */
	public Enchere(Utilisateur Utilisateur, ArticleVendu Article, Date  dateEnchere, int montantEnchere) {
		this(dateEnchere, montantEnchere);
		setUtilisateur(Utilisateur);
		setArticle(Article);
		
	}
	
	
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + getDateEnchere() + ", montantEnchere=" + getMontantEnchere() + ", utilisateur="
				+ getUtilisateur() + ", article=" + getArticle() + "]";
	}
	
	//les getters et setter 
	public Date getDateEnchere() {
		return dateEnchere;
	}



	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}



	public int getMontantEnchere() {
		return montantEnchere;
	}


	
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public ArticleVendu getArticle() {
		return article;
	}


	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
}
	
	




	
	
	
	
	

	
