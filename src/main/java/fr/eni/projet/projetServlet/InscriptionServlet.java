package fr.eni.projet.projetServlet;

import java.io.IOException;

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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String texteIdentifiant = request.getParameter("texteIdentifiant");
		String texteNom = request.getParameter("texteNom");
		String textePrénom = request.getParameter("textePrénom");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String texteRue = request.getParameter("texteRue");
		int codePostal = Integer.parseInt(request.getParameter("codePostal"));
		String texteVille = request.getParameter("texteVille");
		String passwordConfirm = request.getParameter("passwordConfirm");
	}
}
