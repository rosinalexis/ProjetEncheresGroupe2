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
import fr.eni.groupe2.messages.DALException;

/**
 * Servlet implementation class ModifProfil
 */
@WebServlet("/ModifProfil")
public class ModifProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurConnecter = new Utilisateur(); 
        String errorMessage ="";
        
        HttpSession session = request.getSession(true);
        utilisateurConnecter =(Utilisateur) session.getAttribute("utilisateurConnecter");
            
        try {
            request.setAttribute("utilisateur", UtilisateurManager.rechercherUtilisateur(utilisateurConnecter.getNoUtilisateur()));
        } catch (DALException e) {
            
            errorMessage = e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
        }
        request.getRequestDispatcher("/WEB-INF/ModifProfil.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurRecupNum = new Utilisateur();
		utilisateurRecupNum = (Utilisateur) request.getSession().getAttribute("utilisateurConnecter");
		int noUtilisateur = utilisateurRecupNum.getNoUtilisateur();
		System.out.println(noUtilisateur);
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = utilisateurManager.modificationUtilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, confirmation, 0, false);
		
		request.getSession().setAttribute("utilisateurConnecter", utilisateur);
		System.out.println(utilisateur);
		request.getServletContext().getRequestDispatcher("/WEB-INF/ModifProfil.jsp").forward(request, response);
		
	}

}
