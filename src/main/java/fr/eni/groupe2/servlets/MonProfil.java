package fr.eni.groupe2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.groupe2.bll.UtilisateurManager;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * @author groupe 2
 * @projet ENI ENCHERES 2021
 * 
 * @description Servlet implementation class Profil Permet l'affiche du profil
 *              d'un utilisateur via ses donn?es de sessions.
 * 
 */

@WebServlet("/MonProfil")
public class MonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur utilisateurConnecter = new Utilisateur();
		String errorMessage = "";

		// R?cup?ration de la session
		HttpSession session = request.getSession();

		if (session.getAttribute("utilisateurConnecter") == null) {
			// si pas d'objet utilisateur dans la session alors
			// redirection vers la page d'acceuil
			response.sendRedirect(request.getContextPath()+"/Accueil");
		} else {
			
			utilisateurConnecter = (Utilisateur) session.getAttribute("utilisateurConnecter");
			try {
				request.setAttribute("utilisateur",
						UtilisateurManager.rechercherUtilisateur(utilisateurConnecter.getNoUtilisateur()));
			} catch (DALException | BusinessException e) {

				errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);
			}
			request.getRequestDispatcher("/WEB-INF/Profil.jsp").forward(request, response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
