package fr.eni.projet.projetServlet;

import java.io.IOException;

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
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		boolean cookiePresent = false;

		// Cookie mot de passe souvenir, renvoie à l'acceuil(index.jsp) si condition
		// pour se
		// souvenir

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("connexion") && cookie.getValue().equals("ok")) {
					cookiePresent = true;
				}
			}
		}

		if (cookiePresent) {
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			rd = request.getRequestDispatcher("CreationCompte.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texteIdentifiantC = request.getParameter("texteIdentifiant");
		String passwordC = request.getParameter("password");

		// Condition pour se connecter, renvoie à l'acceuil(index.jsp)

		RequestDispatcher rd;
		if (texteIdentifiantC.equals("") && passwordC.equals("")) {
			if (request.getParameter("souv") != null) {
				if (request.getParameter("souv").equals("ok")) {
					Cookie cookie = new Cookie("connexion", "ok");
					cookie.setMaxAge(7 * 24 * 60 * 70);
					response.addCookie(cookie);
				}
			}

			rd = request.getRequestDispatcher("index.jsp");
		} else {

			rd = request.getRequestDispatcher("index.jsp");
		}

		rd.forward(request, response);

	}

}
