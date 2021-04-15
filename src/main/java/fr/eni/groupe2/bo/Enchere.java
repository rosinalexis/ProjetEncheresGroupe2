package fr.eni.groupe2.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe Enchere permet de renseigner les informations d'une ench�re.
 * 
 *
 */
public class Enchere implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// les attribues d'une ench�re
	private Date dateEnchere; 
	private int montantEnchere;
	private int noUtilisateur;
	private int noArticle;
	
	/**
	 * Le constructeur par d�fault de ma classe. 
	 */
	public Enchere() {
		
	}

	/**
	 * Le constructeur surcharg� permettant d'instancier un object de type ench�re en hydratant les attribus ci-dessous
	 * @param dateEnch�re : la date de l'ench�re.
	 * @param montant_enchere  : le montant de l'ench�re.
	 */
	public Enchere(Date dateEnchere, int montantEnchere) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
	}
	
	

	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noUtilisateur
	 * @param noArticle
	 */
	public Enchere(int noUtilisateur, int noArticle, Date dateEnchere, int montantEnchere) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
		setNoUtilisateur(noUtilisateur);
		setNoArticle(noArticle);
	}

	//les getters et setter 
	
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * M�thode  de type mutateur permettant d'hydrater l'attribut date d'une ench�re.
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * M�thode  de type mutateur permettant d'hydrater l'attribut montant d'une ench�re.
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	

	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", noUtilisateur="
				+ noUtilisateur + ", noArticle=" + noArticle + "]";
	}
}
