package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.groupe2.bo.ArticleVendu;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

public class ArticleVenduDAOJdbcImpl implements DAO<ArticleVendu>{

	private final static String RECHERCHER = "SELECT * FROM ARTICLES_VENDUS WHERE no_article =?;";
	
	@Override
	public void insert(ArticleVendu u) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleVendu update(ArticleVendu u) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectByID(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArticleVendu articleVendu = new ArticleVendu();

		cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setNomArticle(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				
				rs.getInt("prix_initial");
				if (rs.wasNull())
					articleVendu.setPrixInitial(-1);
				else 
					articleVendu.setPrixInitial(rs.getInt("prix_initial"));
				
				rs.getInt("prix_vente");
				if (rs.wasNull())
					articleVendu.setPrixVente(-1);
				else 
					articleVendu.setPrixInitial(rs.getInt("prix_vente"));
				
				articleVendu.setNoUtilisateur(rs.getInt("no_utilisateur"));
				articleVendu.setNoUtilisateur(rs.getInt("no_categorie"));
			
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un articleVendus -" + e.getMessage());

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ArticleVendu u) {
		// TODO Auto-generated method stub
		
	}

	
	
}
