package fr.eni.groupe2.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.DAO;
import fr.eni.groupe2.db.BusinessException;

public class UtilisateurDAOJdbcImpl implements DAO <Utilisateur> {

	private final static String LISTER = "SELECT * FROM UTILISATEURS;";
	private final static String INSERER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit,  administrateur ) values (?,?,?,?,?,?,?,?,?,?,?);";
	
	@Override
	public void insert(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		try {
			cnx = DBConnexion.seConnecter();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

			e.printStackTrace();

		} finally {

			try {
				DBConnexion.seDeconnecter(cnx, pstmt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		
	
	@Override
	public void update(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectById(int noUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll()  {
		
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		try {
			cnx = DBConnexion.seConnecter();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			
			e.printStackTrace();

		} finally {

			try {
				DBConnexion.seDeconnecter(cnx, stmt);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

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
			String reqSql = "SELECT * FROM UTILISATEURS WHERE pseudo ='" + login + "' AND mot_de_passe='" + password + "'";
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(reqSql);
			if (rs.next()) {
				return new Utilisateur(
					rs.getInt("noUtilisateur"),
					rs.getString("pseudo"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("email"),
					rs.getString("telephone"),
					rs.getString("rue"),
					rs.getString("codePostal"),
					rs.getString("ville"),
					rs.getString("motDePasse"),
					rs.getInt("credit"),
					rs.getBoolean("administrateur")
				);
			}else 
				return null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	

	
}
