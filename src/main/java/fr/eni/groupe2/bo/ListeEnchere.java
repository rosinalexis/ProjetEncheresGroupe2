package fr.eni.groupe2.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe ListeEnchere permet de
 * renseigner les informations des encheres à lister.
 *
 */
public class ListeEnchere implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//les attribues de ma classe 
	private String nomArticle;
	private int prix; 
	private Date dateFinEnchere; 
	private String pseudo;
	
	
	
	/**
	 * Constructeur par défault
	 */
	public ListeEnchere() {
		super();
	}



	/**
	 * Le constructeur surchargé permettant d'instancier un object de type listeenchere en hydratant les attribus ci-dessous
	 * @param nomArticle
	 * @param prix
	 * @param dateFinEnchere
	 * @param pseudo
	 */
	public ListeEnchere(String nomArticle, int prix, Date dateFinEnchere, String pseudo) {
		setNomArticle(nomArticle); 
		setPrix(prix); 
		setDateFinEnchere(dateFinEnchere); 
		setPseudo(pseudo);
	}

	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	@Override
	public String toString() {
		return "ListeEnchere [nomArticle=" + nomArticle + ", prix=" + prix + ", dateFinEnchere=" + dateFinEnchere
				+ ", pseudo=" + pseudo + "]";
	} 
	
	
	
}
