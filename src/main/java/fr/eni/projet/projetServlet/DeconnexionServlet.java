package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;

import fr.eni.projet.BO.Utilisateur;

/**
 * 
 * @author RobinFerre
 * 
 */

/**
 * Servlet implementation class DeconnexionServlet
 */
@WebServlet("/DeconnexionServlet")
public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

// tente de quitter en fermant et en renvoyant à l'accueil normalement

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//On envoie à index qu'on est déconnecté
		HttpSession sessionUser = request.getSession();
		sessionUser.setAttribute("utilisateur", null);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.jsp").include(request, response);
		out.print("Vous êtes déconnecté!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
