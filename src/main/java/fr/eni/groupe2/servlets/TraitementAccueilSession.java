package fr.eni.groupe2.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.groupe2.bll.EnchereManager;
import fr.eni.groupe2.bo.Categorie;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.groupe2.messages.BusinessException;
import fr.eni.groupe2.messages.DALException;

/**
 * Servlet implementation class TraitementAccueilSession
 */
@WebServlet("/TraitementAccueilSession")
public class TraitementAccueilSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageAccueilTest.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enchere> listeEncheres = new ArrayList<Enchere>() ;
		List<Categorie> listeCategories = new ArrayList<Categorie>() ;
		Utilisateur utilisateurConnecter = new Utilisateur();
	
		String errorMessage =""; 
		String description ="";
		String categorie =""; 
		String checkChoix=""; 
		String etatAchat=""; 
		
		// Récupération de la session
		HttpSession session = request.getSession();
		utilisateurConnecter = (Utilisateur) session.getAttribute("utilisateurConnecter");
		
		description = request.getParameter("description");
		categorie =request.getParameter("categorie");
		
		try {
			if(!description.isEmpty()) {
				listeEncheres= EnchereManager.listerEnchereParMot(description);
			}
			if(!categorie.isEmpty()) {
				listeEncheres= EnchereManager.listerEnchereParCategorie(categorie);
			}
			if(checkChoix.equals("Ventes")) {
				listeEncheres= EnchereManager.listerEnchereParPseudo(utilisateurConnecter.getPseudo());
			}
			if(checkChoix.equals("Achat")) {
				listeEncheres= EnchereManager.listerEnchere();
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageAccueilTest.jsp").forward(request, response);
	}

}
