package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Utilisateur;
import dal.DAOContext;
import dal.UtilisateurDAO;

@WebServlet(urlPatterns="/connexion", loadOnStartup = 1)
public class connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("errorMessage", "");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	};	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("id");
		String password = request.getParameter("mdp");
		
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		
		Utilisateur utilisateurConnecter = UtilisateurDAO.validerConnection(login, password);
		if(utilisateurConnecter != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateurConnecter", utilisateurConnecter);
			request.getRequestDispatcher("/pageAccueil.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "MAUVAISE CONNEXION");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
