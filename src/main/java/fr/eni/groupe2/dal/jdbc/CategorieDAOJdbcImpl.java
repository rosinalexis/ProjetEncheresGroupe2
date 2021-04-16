package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.groupe2.bo.Categorie;
import fr.eni.groupe2.dal.jdbc.helper.DBConnexion;
import fr.eni.groupe2.messages.DALException;

public class CategorieDAOJdbcImpl {

	private final static String LISTER = "SELECT  libelle FROM CATEGORIES;";

	public static List<Categorie> selectAll() throws DALException {

		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;

		Categorie categorie;

		List<Categorie> listeCategorie = new ArrayList<Categorie>();

		cnx = DBConnexion.seConnecter();

		try {

			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);

			while (rs.next()) {

				categorie = new Categorie();

				categorie.setLibelle(rs.getString("libelle"));

				listeCategorie.add(categorie);
			}

		} catch (SQLException e) {

			throw new DALException("Problème lors de la tentative de listage des Catégories -", e);
		} finally {
			DBConnexion.seDeconnecter(cnx, stmt);
		}

		return listeCategorie;
	}
}
