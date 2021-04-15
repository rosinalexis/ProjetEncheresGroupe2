package fr.eni.groupe2.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe2.bll.EnchereManager;
import fr.eni.groupe2.bo.Enchere;
import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.groupe2.messages.DALException;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/Encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noArticleAEncherir = request.getParameter("noArticleAEncherir");
		request.getSession().setAttribute("noArticleAEncherir", noArticleAEncherir);
		request.getServletContext().getRequestDispatcher("/WEB-INF/Encherir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ici sera le code pour rentrer un objet enchère dans la BDD:
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
		String errorMessage = "";
		
		int noUtilisateur = utilisateur.getNoUtilisateur();
		
		int noArticle = Integer.valueOf(request.getSession().getAttribute("noArticleAEncherir").toString());
		
		Date dateEnchere = Date.valueOf(LocalDate.now());
		
		int montantEnchere = Integer.valueOf(request.getParameter("montantEnchere"));
		
		EnchereDAOJdbcImpl enchereDAO = new EnchereDAOJdbcImpl();
		int montantEnchereMax = 0;
		try {
			montantEnchereMax = enchereDAO.selectByNoEnchere(noArticle);
		} catch (DALException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.getSession().setAttribute("montantEnchereMax", montantEnchereMax);
		
		EnchereManager enchereManager = new EnchereManager();
		Enchere enchere = new Enchere();

		try {
			enchere = enchereManager.insertEnchere(noUtilisateur, noArticle, dateEnchere, montantEnchere);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("enchere", enchere);
		request.getServletContext().getRequestDispatcher("/WEB-INF/pageAccueil.jsp").forward(request, response);
	}

}
