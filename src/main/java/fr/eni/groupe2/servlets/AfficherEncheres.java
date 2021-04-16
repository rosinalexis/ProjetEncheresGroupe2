package fr.eni.groupe2.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.groupe2.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;


@WebServlet("/AfficherEncheres")
public class AfficherEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enchere enchere = new Enchere();
		
		String errorMessage = "";
		String nomArticle =  request.getParameter("nomArticle");
		
		
			try {
				enchere =EnchereDAOJdbcImpl.AfficherEncheresUtilisateursParNomArticle(nomArticle);
				System.out.println(enchere);
				request.setAttribute("enchere",enchere);
			} catch (DALException | BusinessException e) {

				errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);
			}
			request.getRequestDispatcher("/WEB-INF/AfficherEnchere.jsp").forward(request, response);
		}		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}


