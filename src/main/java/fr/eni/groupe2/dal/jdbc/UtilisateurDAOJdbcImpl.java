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
import fr.eni.groupe2.dal.jdbc.helper.DBConnexion;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

public class UtilisateurDAOJdbcImpl implements DAO<Utilisateur> {

	private final static String LISTER = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur "
										+ " FROM UTILISATEURS;";
	
	private final static String RECHERCHER = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur  "
											+ "FROM UTILISATEURS "
											+ "WHERE no_utilisateur =?;";
	
	private final static String RECHERCHERPARPSEUDO = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur  "
											+ "FROM UTILISATEURS "
											+ "WHERE pseudo = ?;";
	
	private final static String CONNEXION = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur  "
											+ "FROM UTILISATEURS WHERE pseudo =? AND mot_de_passe=?;";

	private final static String INSERER = "INSERT INTO UTILISATEURS(no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur )"
										+ " VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	
	private final static String MODIFIER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?"
										+ "WHERE no_utilisateur = ?;";

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

			throw new DALException("Probleme lors de l'insertion d'un utilisateur -" + e.getMessage());

		} finally {

			DBConnexion.seDeconnecter(cnx, pstmt);
		}
	}

	public Utilisateur update(Utilisateur u) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		cnx = DBConnexion.seConnecter();

		try {
			pstmt = cnx.prepareStatement(MODIFIER);
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getNoUtilisateur());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Probleme lors de la modification d'un utilisateur -" + e.getMessage());
		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}
		return u;
	}

	@Override
	public Utilisateur selectByID(int noUtilisateur) throws DALException, BusinessException {

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
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));

				rs.getString("telephone");
				if (rs.wasNull())
					utilisateur.setTelephone("inconnu");
				else
					utilisateur.setTelephone(rs.getString("telephone"));

				utilisateur.setRue(rs.getString("rue"));

				utilisateur.setCodePostal(rs.getString("code_postal"));

				utilisateur.setVille(rs.getString("ville"));

				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));

				utilisateur.setCredit(rs.getInt("credit"));

				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un utilisateur -", e);

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return utilisateur;
	}

	/**
	 * Methode implementée permettant de lister les utilisateurs
	 */
	@Override
	public List<Utilisateur> selectAll() throws DALException, BusinessException {

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

				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));

				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));

				rs.getString("telephone");
				if (rs.wasNull())
					utilisateur.setTelephone("<<inconnu>>");
				else
					utilisateur.setTelephone(rs.getString("telephone"));

				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				listeUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {

			throw new DALException("Problème lors de la tentative de listage des Utilisateurs -", e);
		} finally {
			DBConnexion.seDeconnecter(cnx, stmt);
		}
		return listeUtilisateurs;
	}

	@Override
	public void delete(Utilisateur u) {
		// TODO Auto-generated method stub

	}

	public static Utilisateur validerConnection(String login, String password) throws DALException, BusinessException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;

		cnx = DBConnexion.seConnecter();

		try {
			pstmt = cnx.prepareStatement(CONNEXION);
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"),
						(rs.wasNull() ? "<<inconnu>>" : rs.getString("telephone")), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("problème de validation sur la connexion à l'application", e);
		}

		return utilisateur;
	}


	public static Utilisateur AffichierUtilisateur(String Pseudo) throws DALException, BusinessException {
		
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = new Utilisateur();

		cnx = DBConnexion.seConnecter();
		try {
			pstmt = cnx.prepareStatement(RECHERCHERPARPSEUDO);
			pstmt.setString(1,  Pseudo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));

				rs.getString("telephone");
				if (rs.wasNull())
					utilisateur.setTelephone("inconnu");
				else
					utilisateur.setTelephone(rs.getString("telephone"));

				utilisateur.setRue(rs.getString("rue"));

				utilisateur.setCodePostal(rs.getString("code_postal"));

				utilisateur.setVille(rs.getString("ville"));

				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));

				utilisateur.setCredit(rs.getInt("credit"));

				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("Probleme lors de la rechercher d'un utilisateur -", e);

		} finally {
			DBConnexion.seDeconnecter(cnx, pstmt);
		}

		return utilisateur;
	}
	
}
	
		
