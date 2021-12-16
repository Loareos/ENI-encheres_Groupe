package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficherArticleServlet
 */
@WebServlet("/AfficherArticleServlet")
public class AfficherArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherArticleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Récupérer les infos de l'annonce : 
		String titre = request.getParameter("titreAfficher");
		String photo = request.getParameter("photoAfficher");
		String description = request.getParameter("descriptionAfficher");
		Integer meilleurOffre = Integer.parseInt(request.getParameter("meilleurOffreAfficher"));
		Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrixAfficher"));
		LocalDateTime FinEnchere = LocalDateTime.parse(request.getParameter("FinEnchereAfficher"));
		String rueRetrait = request.getParameter("rueRetraitAfficher");
		String codePostal = request.getParameter("codePostalAfficher");
		String ville = request.getParameter("villeAfficher");
		String vendeur = request.getParameter("vendeurAfficher");
		Integer proposition = Integer.parseInt(request.getParameter("propositionAfficher"));
		String telephone = request.getParameter("telephoneAfficher");
		
		// FAUT RECUPERER TOUT L'OBJET ARTICLE ET ENSUITE ENVOYER SES INFOS
		
		
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
