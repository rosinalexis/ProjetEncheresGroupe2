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
import fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * Servlet implementation class AfficherProfil
 */
@WebServlet("/AfficherProfil")
public class AfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorMessage = "";
		String pseudo =  request.getParameter("pseudo");
		
			try {
				request.setAttribute("utilisateur", UtilisateurDAOJdbcImpl.AffichierUtilisateur(pseudo));
			} catch (DALException | BusinessException e) {

				errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);
			}
			request.getRequestDispatcher("/WEB-INF/AfficherProfil.jsp").forward(request, response);
		}		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
