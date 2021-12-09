package fr.eni.projet.projetServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifProfilServlet
 */
@WebServlet("/ModifProfilServlet")
public class ModifProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
	}

}
