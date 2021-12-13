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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        //On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur re = (Utilisateur) sessionUser.getAttribute("utilisateur");
		
		//On récupère le nom du pseudo cliqué
		String pseudo = request.getParameter("test").trim();

		if(pseudo.contains(re.getPseudo())) {
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion/Profil.jsp");
		rd.forward(request, response);
	}
}
