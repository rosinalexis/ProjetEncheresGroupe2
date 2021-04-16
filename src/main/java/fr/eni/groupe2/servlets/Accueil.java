package fr.eni.groupe2.servlets;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.groupe2.bll.EnchereManager;
import fr.eni.groupe2.bo.Categorie;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String errorMessage =""; 
		 List<Enchere> listeEncheres = new ArrayList<Enchere>() ;
		 List<Categorie> listeCategories = new ArrayList<Categorie>() ;
		 
		try {
			listeEncheres= EnchereManager.listerEnchere();
			listeCategories= CategorieDAOJdbcImpl.selectAll();
			
		} catch (DALException | BusinessException e) {
			
			errorMessage =e.getMessage();
		}
		if (!errorMessage.isEmpty()) {
			request.setAttribute("errorMessage", errorMessage);
		}else {
			
			request.setAttribute("listeEncheres", listeEncheres);
			request.setAttribute("listeCategories", listeCategories);
			request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Enchere> listeEncheres = new ArrayList<Enchere>() ;
		List<Categorie> listeCategories = new ArrayList<Categorie>() ;
		
		String errorMessage =""; 
		String description ="";
		String categorie =""; 
		
		description = request.getParameter("description");
		categorie =request.getParameter("categorie");
		
		try {
			if(!description.isEmpty()) {
				listeEncheres= EnchereManager.listerEnchereParMot(description);
			}
			if(!categorie.isEmpty()) {
				listeEncheres= EnchereManager.listerEnchereParCategorie(categorie);
			}
			
			listeCategories= CategorieDAOJdbcImpl.selectAll();
		} catch (DALException|BusinessException e) {
			errorMessage =e.getMessage();
		} 
		
		if (!errorMessage.isEmpty()) {
			request.setAttribute("errorMessage", errorMessage);
		}else {
			
			request.setAttribute("listeEncheres", listeEncheres);
			request.setAttribute("listeCategories", listeCategories);
			
		}
		
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		
		
		
	}

}