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

		// Cookie mot de passe souvenir, renvoie à l'acceuil(index.jsp) si condition
		// pour se
		// souvenir

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("connexion") && cookie.getValue().equals("ok")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
		
		
		
//		response.setContentType("");
		PrintWriter out = response.getWriter();
//
		request.getRequestDispatcher("index.jsp").include(request, response);
//
//		HttpSession session = request.getSession();
//		session.invalidate();

		out.print("Vous êtes déconnecté!");

		out.close();

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
