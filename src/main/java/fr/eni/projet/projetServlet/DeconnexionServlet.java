package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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