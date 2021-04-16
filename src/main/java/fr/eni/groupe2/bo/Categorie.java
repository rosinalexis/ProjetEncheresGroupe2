package fr.eni.groupe2.bo;

import java.io.Serializable;
/**
 * java beans Categorie 
 * @author 
 *
 */
public class Categorie  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//attributs
	private int noCategorie; 
	private String libelle;
	
	//méthodes 
	/**
	 * Le constructeur par default 
	 */
	public Categorie() {
		
	}
	
	/**
	 * Le constructeur surchargé permettant d'instancier un objet de type categorie 
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		
		setLibelle(libelle);
	}

	
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + getNoCategorie() + ", libelle=" + getLibelle() + "]";
	} 
	

	public int getNoCategorie() {
		return noCategorie;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
	
	
}
