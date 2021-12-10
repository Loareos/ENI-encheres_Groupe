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
	 * @see HttpServlet#HttpServlet()
	 */
	public DeconnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// tente de quitter en fermant et en renvoyant à l'accueil normalement

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		boolean cookiePresent = false;

		// Cookie mot de passe souvenir, est enlever

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("connexion") && cookie.getValue().equals("ok")) {
					cookie.setMaxAge(7 * 24 * 60 * 70);
					response.addCookie(cookie);
				}
			}
		}

		// Cookie qui déconnecte et renvoie à l'accueil (logiquement) mais reste dans la
		// servlet (url)

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("index.jsp").include(request, response);

		Cookie ck = new Cookie("deconnexion", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
		//On envoie à index qu'on est déconnecté
		request.setAttribute("utilisateur", null);
		out.print("Vous êtes déconnecté!");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
	}

}
