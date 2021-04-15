package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.ListeEnchere;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.messages.DALException;

public class EnchereDAOJdbcImpl implements DAO<Enchere> {

	private final static String LISTER = "SELECT * FROM ENCHERES;";
	private final static String RECHERCHERSPE ="SELECT ARTICLES_VENDUS.nom_article, ARTICLES_VENDUS.prix_initial, ARTICLES_VENDUS.date_fin_encheres, UTILISATEURS.pseudo FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur WHERE UTILISATEURS.no_utilisateur =? AND ARTICLES_VENDUS.no_article =?;";
	private final static String SELECT_BY_NO_ENCHERE = "SELECT MAX(montant_enchere) as montantEnchereMax  FROM ENCHERES WHERE noArticle=?";
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
	public List<Enchere> selectAll() throws DALException {

		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		Enchere enchere = null;
		List<Enchere> listeEnchere = new ArrayList<Enchere>();

		cnx = DBConnexion.seConnecter();

		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);

			while (rs.next()) {
				enchere = new Enchere();
				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontantEnchere(rs.getInt("montant_enchere"));
				listeEnchere.add(enchere);
			}

		} catch (SQLException e) {

			throw new DALException("Problème lister enchere -" + e.getMessage());

		} finally {

			DBConnexion.seDeconnecter(cnx, stmt);
		}

		return listeEnchere;
	}

	@Override
	public void delete(Enchere u) {
		// TODO Auto-generated method stub

	}
	
	
	public static ListeEnchere listerEncheres(int UtilisateurID, int ArticleID) throws DALException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ListeEnchere listeEnchere = new ListeEnchere();

		cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(RECHERCHERSPE);
			pstmt.setInt(1, UtilisateurID);
			pstmt.setInt(2,  ArticleID);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listeEnchere.setNomArticle(rs.getString("nom_article"));
				listeEnchere.setPrix(rs.getInt("prix_initial"));
				listeEnchere.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				listeEnchere.setPseudo(rs.getString("pseudo"));
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return listeEnchere;
		
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
			pstmt.setInt(1, enchere.getNoUtilisateur());
			pstmt.setInt(2, enchere.getNoArticle());
			pstmt.setDate(3,(Date) enchere.getDateEnchere());
			pstmt.setInt(4, enchere.getMontantEnchere());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoUtilisateur(rs.getInt(1));
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
