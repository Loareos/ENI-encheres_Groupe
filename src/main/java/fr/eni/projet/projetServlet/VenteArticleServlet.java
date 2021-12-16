package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BLL.ArticleVenduManager;
import fr.eni.projet.BLL.RetraitManager;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.messages.LecteurMessage;
/**
 * 
 * @author Clément Modif by Etienne
 * 
 */
/**
 * Servlet implementation class VenteArticleServlet
 */
@WebServlet("/VenteArticleServlet")
public class VenteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("WEB-INF/jsp/Vente/VenteArticle.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Categorie categorie = null;
		switch (request.getParameter("Categorie")) {
		case "1": categorie = new Categorie(1,"Informatique"); break;
		case "2": categorie = new Categorie(2,"Ameublement"); break;
		case "3": categorie = new Categorie(3,"Vêtement"); break;
		case "4": categorie = new Categorie(4,"Sport&Loisirs"); break;
		default: categorie = new Categorie(4,"Sport&Loisirs"); break;
		}
		
		//Récupérer les infos de l'annonce : 
		String nom = 				request.getParameter("Nom");
		String description = 		request.getParameter("Description");
		LocalDate DebutEnchere = 	LocalDate.parse(request.getParameter("DateDebut"));
		LocalDate FinEnchere = 		LocalDate.parse(request.getParameter("DateFin"));
		Integer miseAPrix = 		Integer.parseInt(request.getParameter("MiseAPrix"));
		
		// INFO RETRAIT
		String rueRetrait = 		request.getParameter("RueRetrait");
		String codePostal = 		request.getParameter("CodePostalRetrait");
		String ville = 				request.getParameter("VilleRetrait");

		
		//On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur user = (Utilisateur) sessionUser.getAttribute("utilisateur");
				
		try {
			//Ajouter l'article à la BDD
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			ArticleVendu art = avm.ajouterArticle(nom, description, DebutEnchere, FinEnchere, miseAPrix, user, categorie);

			RetraitManager rm = RetraitManager.getInstance();
			rm.ajouterRetrait(art.getNoArticle(), rueRetrait, codePostal, ville);
			
			RequestDispatcher rd = request.getRequestDispatcher("AccueilServlet");
			rd.forward(request, response);
			
		} catch (BusinessException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Une ou plusieurs erreurs se sont produites :");
			for(int i : e.getListeCodesErreur())
				sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));
			
			System.err.println(sb.toString());
			
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("WEB-INF/jsp/Vente/VenteArticle.jsp").include(request, response);
			out.print(sb.toString());
		}		
	}
}