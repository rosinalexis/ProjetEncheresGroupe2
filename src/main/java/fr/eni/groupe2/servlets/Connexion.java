package fr.eni.groupe2.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.groupe2.bo.Utilisateur;
import  fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;

@WebServlet(urlPatterns="/Connexion", loadOnStartup = 1)
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("errorMessage", "");
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
		
	};	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("id");
		String password = request.getParameter("mdp");
		
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		
		Utilisateur utilisateurConnecter = UtilisateurDAOJdbcImpl.validerConnection(login, password);
		if(utilisateurConnecter != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateurConnecter", utilisateurConnecter);
			request.getRequestDispatcher("/WEB-INF/pageAccueil.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "MAUVAISE CONNEXION");
			request.getRequestDispatcher("WEB-INF/Connexion.jsp").forward(request, response);
		}
		
	}

}
