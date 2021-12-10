package fr.eni.projet.projetServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BO.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        //On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur re = (Utilisateur) sessionUser.getAttribute("utilisateur");


		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion/Profil.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String Nom = request.getParameter("Nom");
		String Prenom = request.getParameter("Prenom");
		String Email = request.getParameter("Email");
		String Telephone = request.getParameter("Telephone");
		String Rue = request.getParameter("Rue");
		String CodePostal = request.getParameter("CodePostal");
		String Ville = request.getParameter("Ville");

	}

}
