package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.groupe2.bo.ArticleVendu;
import fr.eni.groupe2.bo.Categorie;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.Retrait;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.dal.jdbc.helper.DBConnexion;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

public class EnchereDAOJdbcImpl implements DAO<Enchere> {

	private final static String LISTER = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo,libelle "
			+ "FROM ARTICLES_VENDUS av " + "INNER JOIN UTILISATEURS u " + "ON av.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c " + "ON  av.no_categorie = c.no_categorie;";

	private final static String RECHERCHERPSEUDO = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo,libelle "
			+ "FROM ARTICLES_VENDUS av " + "INNER JOIN UTILISATEURS u " + "ON av.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c " + "ON  av.no_categorie = c.no_categorie " + "WHERE u.pseudo =?";

	private final static String RECHERCHERCATEGORIE = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo,libelle "
			+ "FROM ARTICLES_VENDUS av " + "INNER JOIN UTILISATEURS u " + "ON av.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c " + "ON  av.no_categorie = c.no_categorie " + "WHERE libelle =?";

	private final static String RECHERCHERDESCRIPTION = "SELECT nom_article,description, prix_initial, date_fin_encheres, pseudo,libelle "
			+ "FROM ARTICLES_VENDUS av " + "INNER JOIN UTILISATEURS u " + "ON av.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c " + "ON  av.no_categorie = c.no_categorie " + "WHERE description LIKE ?+ ? + ?  ";

	private final static String SELECT_BY_NO_ENCHERE = "SELECT MAX(montant_enchere) as montantEnchereMax  FROM ENCHERES WHERE noArticle=?";
	
	
	private final static String RECHERCHERPARNOMARTICLE = "SELECT nom_article,description, prix_initial ,prix_vente, date_fin_encheres, pseudo,libelle "
			+ "FROM ARTICLES_VENDUS av " + "INNER JOIN UTILISATEURS u " + "ON av.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c " + "ON  av.no_categorie = c.no_categorie " + "WHERE nom_article =?";
	
	@Override
	public void insert(Enchere u) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public Enchere update(Enchere u) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectByID(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() throws DALException, BusinessException {

		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;

		Enchere enchere = null;
		Utilisateur u = null;
		ArticleVendu a = null;
		Categorie c = null;

		List<Enchere> listeEncheres = new ArrayList<Enchere>();

		cnx = DBConnexion.seConnecter();

		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);

			while (rs.next()) {

				// insertion de l'article
				a = new ArticleVendu();
				a.setNomArticle(rs.getString("nom_article"));
				a.setPrixInitial(rs.getInt("prix_initial"));
				a.setDateFinEncheres(rs.getDate("date_fin_encheres"));

				// insertion de l'utilisateur
				u = new Utilisateur();
				u.setPseudo(rs.getString("pseudo"));

				// insertion de la catégorie
				c = new Categorie();
				c.setLibelle(rs.getString("libelle"));

				// insertion dans l'article
				a.setUtilisateur(u);
				a.setCategorie(c);

				// insertion dans l'encheres
				enchere = new Enchere();
				enchere.setUtilisateur(u);
				enchere.setArticle(a);
				enchere.setDateEnchere(a.getDateFinEncheres());
				enchere.setMontantEnchere(a.getPrixInitial());

				// ajout dans la liste
				listeEncheres.add(enchere);
			}

		} catch (SQLException e) {

			throw new DALException("Problème lister enchere -" + e.getMessage());

		} finally {

			DBConnexion.seDeconnecter(cnx, stmt);
		}

		return listeEncheres;
	}

	@Override
	public void delete(Enchere u) {
		// TODO Auto-generated method stub

	}

	public static List<Enchere> AfficherEncheresUtilisateursParPseudo(String pseudo)
			throws DALException, BusinessException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Enchere enchere = null;
		Utilisateur u = null;
		ArticleVendu a = null;
		Categorie c = null;

		cnx = DBConnexion.seConnecter();

		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try {
			pstmt = cnx.prepareStatement(RECHERCHERPSEUDO);
			pstmt.setString(1, pseudo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// insertion de l'article
				a = new ArticleVendu();
				a.setNomArticle(rs.getString("nom_article"));
				a.setPrixInitial(rs.getInt("prix_initial"));
				a.setDateFinEncheres(rs.getDate("date_fin_encheres"));

				// insertion de l'utilisateur
				u = new Utilisateur();
				u.setPseudo(rs.getString("pseudo"));

				// insertion de la catégorie
				c = new Categorie();
				c.setLibelle(rs.getString("libelle"));

				// insertion dans l'article
				a.setUtilisateur(u);
				a.setCategorie(c);

				// insertion dans l'encheres
				enchere = new Enchere();
				enchere.setUtilisateur(u);
				enchere.setArticle(a);
				enchere.setDateEnchere(a.getDateFinEncheres());
				enchere.setMontantEnchere(a.getPrixInitial());

				// ajout dans la liste
				listeEncheres.add(enchere);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return listeEncheres;

	}

	public static List<Enchere> AfficherEncheresUtilisateursParCategorie(String categorie)
			throws DALException, BusinessException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Enchere enchere = null;
		Utilisateur u = null;
		ArticleVendu a = null;
		Categorie c = null;

		cnx = DBConnexion.seConnecter();

		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try {
			pstmt = cnx.prepareStatement(RECHERCHERCATEGORIE);
			pstmt.setString(1, categorie);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// insertion de l'article
				a = new ArticleVendu();
				a.setNomArticle(rs.getString("nom_article"));
				a.setPrixInitial(rs.getInt("prix_initial"));
				a.setDateFinEncheres(rs.getDate("date_fin_encheres"));

				// insertion de l'utilisateur
				u = new Utilisateur();
				u.setPseudo(rs.getString("pseudo"));

				// insertion de la catégorie
				c = new Categorie();
				c.setLibelle(rs.getString("libelle"));

				// insertion dans l'article
				a.setUtilisateur(u);
				a.setCategorie(c);

				// insertion dans l'encheres
				enchere = new Enchere();
				enchere.setUtilisateur(u);
				enchere.setArticle(a);
				enchere.setDateEnchere(a.getDateFinEncheres());
				enchere.setMontantEnchere(a.getPrixInitial());

				// ajout dans la liste
				listeEncheres.add(enchere);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return listeEncheres;

	}

	public static List<Enchere> AfficherEncheresUtilisateursParMot(String mot) throws DALException, BusinessException {
		
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Enchere enchere = null;
		Utilisateur u = null;
		ArticleVendu a = null;
		Categorie c = null;

		cnx = DBConnexion.seConnecter();

		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try {
			pstmt = cnx.prepareStatement(RECHERCHERDESCRIPTION);
			pstmt.setString(1, "%");
			pstmt.setString(2,  mot);
			pstmt.setString(3, "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// insertion de l'article
				a = new ArticleVendu();
				a.setNomArticle(rs.getString("nom_article"));
				a.setPrixInitial(rs.getInt("prix_initial"));
				a.setDateFinEncheres(rs.getDate("date_fin_encheres"));

				// insertion de l'utilisateur
				u = new Utilisateur();
				u.setPseudo(rs.getString("pseudo"));

				// insertion de la catégorie
				c = new Categorie();
				c.setLibelle(rs.getString("libelle"));

				// insertion dans l'article
				a.setUtilisateur(u);
				a.setCategorie(c);

				// insertion dans l'encheres
				enchere = new Enchere();
				enchere.setUtilisateur(u);
				enchere.setArticle(a);
				enchere.setDateEnchere(a.getDateFinEncheres());
				enchere.setMontantEnchere(a.getPrixInitial());

				// ajout dans la liste
				listeEncheres.add(enchere);
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return listeEncheres;

}
	
	public static Enchere AfficherEncheresUtilisateursParNomArticle(String nomArticle) throws DALException, BusinessException {
		
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Enchere enchere = null;
		Utilisateur u = null;
		ArticleVendu a = null;
		Categorie c = null;
		//Retrait r = null; 

		cnx = DBConnexion.seConnecter();

		
		try {
			pstmt = cnx.prepareStatement(RECHERCHERPARNOMARTICLE);
			pstmt.setString(1, nomArticle);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// insertion de l'article
				a = new ArticleVendu();
				a.setNomArticle(rs.getString("nom_article"));
				a.setDescription(rs.getString("description"));
				a.setPrixInitial(rs.getInt("prix_initial"));
				a.setPrixVente(rs.getInt("prix_vente"));
				a.setDateFinEncheres(rs.getDate("date_fin_encheres"));

				// insertion de l'utilisateur
				u = new Utilisateur();
				u.setPseudo(rs.getString("pseudo"));

				// insertion de la catégorie
				c = new Categorie();
				c.setLibelle(rs.getString("libelle"));

				
//				//insertion d'un point de retrait 
//				r = new Retrait();
//				r.setRue(rs.getString("rue"));
//				r.setVille(rs.getString("ville"));
//				r.setCodePostal(rs.getString("code_postal"));
			
				
				// insertion dans l'article
				a.setUtilisateur(u);
				a.setCategorie(c);
				//a.setRetrait(r);
				// insertion dans l'encheres
				enchere = new Enchere();
				enchere.setUtilisateur(u);
				enchere.setArticle(a);
				enchere.setDateEnchere(a.getDateFinEncheres());
				enchere.setMontantEnchere(a.getPrixInitial());

				
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return enchere;

}


	public int selectByNoEnchere(int noArticle) throws DALException {
		Enchere enchere = new Enchere();
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int montantEnchereMax = 0;
		cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(SELECT_BY_NO_ENCHERE);
			pstmt.setInt(1, noArticle);
			rs = pstmt.executeQuery();
			if(rs.next())
				enchere.setMontantEnchere(rs.getInt("montantEnchereMax"));
			montantEnchereMax = enchere.getMontantEnchere();
			cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return montantEnchereMax;
	}

	public int insertEnchere(Enchere enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(
					"INSERT INTO ENCHERES(noEnchereur, noArticle, dateEnchere, montantEnchere) VALUES (?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			//pstmt.setDate(3,(Date)enchere.getDateEnchere());
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.getUtilisateur().setNoUtilisateur(rs.getInt(1));
				return rs.getInt(1);
			}
			
			cnx.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
