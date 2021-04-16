package fr.eni.groupe2.bo;

/**
 * <strong>Classe</strong> metier permettant d'instancier un object de type Retrait
 * @author Groupe2
 * @description projet ENCHERES ENI 2021. La Classe Enchere permet de renseigner les informations d'un point de retrait.
 * 
 *
 */
public class Retrait  {

	
	//les attributs 
	String rue; 
	String codePostal; 
	String ville; 
	ArticleVendu article;
	
	
	
	
	
	
	
	/**
	 * le constructeur par default da ma classe 
	 */
	public Retrait() {
		
	}

	/**
	 * le construteur surchargé permettant d'hydrater un objet de type Retrait avec les paramètres ci-dessous: 
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param article
	 */
	public Retrait(String rue, String codePostal, String ville, ArticleVendu article) {
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setArticle(article);
	}
	
	
	@Override
	public String toString() {
		return "Retrait [rue=" + getRue() + ", codePostal=" + getCodePostal() + ", ville=" + getVille() + ", article=" + getArticle() + "]";
	}

	public String getRue() {
		return rue;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	} 
	
	
	
	
}
