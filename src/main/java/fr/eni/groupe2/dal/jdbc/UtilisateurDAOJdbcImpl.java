package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;


public class UtilisateurDAOJdbcImpl implements DAO<Utilisateur> {

	private final static String LISTER = "SELECT * FROM UTILISATEURS;";
	private final static String INSERER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur ) values (?,?,?,?,?,?,?,?,?,?,?);";
	private final static String RECHERCHER = "SELECT * FROM UTILISATEURS WHERE no_utilisateur =?";

	@Override
	public void insert(Utilisateur u) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
	
			cnx = DBConnexion.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement(INSERER);
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11, u.isAdministrateur());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			throw new DALException("Probleme lors de l'insertion d'un utilisateur -"+e.getMessage());

		} finally {

				DBConnexion.seDeconnecter(cnx, pstmt);
		}
	}

	@Override
	public void update(Utilisateur u) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectByID(int noUtilisateur) throws DALException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = new Utilisateur();

		
			cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setInt(1, noUtilisateur);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));

				rs.getString("pseudo");
				if (rs.wasNull())
					utilisateur.setPseudo("inconnu");
				else
					utilisateur.setPseudo(rs.getString("pseudo"));

				rs.getString("nom");
				if (rs.wasNull())
					utilisateur.setNom("inconnu");
				else
					utilisateur.setNom(rs.getString("nom"));

				rs.getString("prenom");
				if (rs.wasNull())
					utilisateur.setPrenom("inconnu");
				else
					utilisateur.setPrenom(rs.getString("prenom"));

				rs.getString("email");
				if (rs.wasNull())
					utilisateur.setEmail("inconnu");
				else
					utilisateur.setEmail(rs.getString("email"));

				rs.getString("telephone");
				if (rs.wasNull())
					utilisateur.setTelephone("inconnu");
				else
					utilisateur.setTelephone(rs.getString("telephone"));

				rs.getString("rue");
				if (rs.wasNull())
					utilisateur.setRue("inconnu");
				else
					utilisateur.setRue(rs.getString("rue"));

				rs.getString("code_postal");
				if (rs.wasNull())
					utilisateur.setCodePostal("inconnu");
				else
					utilisateur.setCodePostal(rs.getString("code_postal"));

				rs.getString("ville");
				if (rs.wasNull())
					utilisateur.setVille("inconnu");
				else
					utilisateur.setVille(rs.getString("ville"));

				rs.getString("mot_de_passe");
				if (rs.wasNull())
					utilisateur.setMotDePasse("inconnu");
				else
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));

				utilisateur.setCredit(rs.getInt("credit"));

				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException | BusinessException e) {
			throw new DALException("Probleme lors de la rechercher d'un utilisateur -"+e.getMessage());
			
		} finally {
				DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {

		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

	
			cnx = DBConnexion.seConnecter();
		

		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);

			while (rs.next()) {
				utilisateur = new Utilisateur();
				try {
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));

					rs.getString("pseudo");
					if (rs.wasNull())
						utilisateur.setPseudo("inconnu");
					else
						utilisateur.setPseudo(rs.getString("pseudo"));

					rs.getString("nom");
					if (rs.wasNull())
						utilisateur.setNom("inconnu");
					else
						utilisateur.setNom(rs.getString("nom"));

					rs.getString("prenom");
					if (rs.wasNull())
						utilisateur.setPrenom("inconnu");
					else
						utilisateur.setPrenom(rs.getString("prenom"));

					rs.getString("email");
					if (rs.wasNull())
						utilisateur.setEmail("inconnu");
					else
						utilisateur.setEmail(rs.getString("email"));

					rs.getString("telephone");
					if (rs.wasNull())
						utilisateur.setTelephone("inconnu");
					else
						utilisateur.setTelephone(rs.getString("telephone"));

					rs.getString("rue");
					if (rs.wasNull())
						utilisateur.setRue("inconnu");
					else
						utilisateur.setRue(rs.getString("rue"));

					rs.getString("code_postal");
					if (rs.wasNull())
						utilisateur.setCodePostal("inconnu");
					else
						utilisateur.setCodePostal(rs.getString("code_postal"));

					rs.getString("ville");
					if (rs.wasNull())
						utilisateur.setVille("inconnu");
					else
						utilisateur.setVille(rs.getString("ville"));

					rs.getString("mot_de_passe");
					if (rs.wasNull())
						utilisateur.setMotDePasse("inconnu");
					else
						utilisateur.setMotDePasse(rs.getString("mot_de_passe"));

					utilisateur.setCredit(rs.getInt("credit"));

					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				} catch (BusinessException e) {

					e.printStackTrace();
				}

				listeUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {

			throw new DALException("Problème lors de la tentative de listage des Utilisateurs -"+e.getMessage());
		} finally {
				DBConnexion.seDeconnecter(cnx, stmt);
		}
		return listeUtilisateurs;
	}

	@Override
	public void delete(Utilisateur u) {
		// TODO Auto-generated method stub

	}

	public static Utilisateur validerConnection(String login, String password) {

		Connection cnx = null;
		try {
			cnx = DBConnexion.seConnecter();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String reqSql = "SELECT * FROM UTILISATEURS WHERE pseudo ='" + login + "' AND mot_de_passe='" + password
					+ "'";
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(reqSql);
			if (rs.next()) {
				return new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			} else
				return null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}

}