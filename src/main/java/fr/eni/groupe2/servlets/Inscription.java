package fr.eni.groupe2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe2.bll.UtilisateurManager;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;


@WebServlet(name ="Inscritption" ,
			urlPatterns=("/Inscription"))
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur utilisateur = new Utilisateur();
		String errorMessage = "";

		try {
			utilisateur.setPseudo(request.getParameter("pseudo").toLowerCase());
			utilisateur.setNom(request.getParameter("nom").toLowerCase());
			utilisateur.setPrenom(request.getParameter("prenom").toLowerCase());
			utilisateur.setEmail(request.getParameter("email").toLowerCase());
			utilisateur.setTelephone(request.getParameter("telephone").toLowerCase());
			utilisateur.setRue(request.getParameter("rue").toLowerCase());
			utilisateur.setCodePostal(request.getParameter("codePostal").toLowerCase());
			utilisateur.setVille(request.getParameter("ville").toLowerCase());
			utilisateur.setCredit(0);
			utilisateur.setAdministrateur(false);

			
			if (request.getParameter("motDePasse").equals(request.getParameter("confirmation"))) {
				utilisateur.setMotDePasse(request.getParameter("motDePasse"));

				boolean ok = UtilisateurManager.ajouterUtilisateur(utilisateur);

				if (!ok) {
					errorMessage = "l'utilisateur existe deja!( pseudo , nom, email identique) ";
					request.setAttribute("errorMessage", errorMessage);
				} else {
					
					// je retourne un msg pour dire que l'inscription est ok
					request.setAttribute("etatInscription", "inscription ok");
					request.setAttribute("utilisateurs", UtilisateurManager.listerUtlisateur());
				}

			} else {
				errorMessage = "Les mots de passe sont différents !";
				request.setAttribute("errorMessage", errorMessage);
			}

		} catch (BusinessException | DALException e) {
			
			errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}
}
