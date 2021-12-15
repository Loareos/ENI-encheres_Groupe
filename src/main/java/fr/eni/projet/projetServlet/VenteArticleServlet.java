package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BLL.ArticleVenduManager;
import fr.eni.projet.BLL.UtilisateurManager;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.messages.LecteurMessage;
/**
 * 
 * @author Clément
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
		
		//Récupérer les infos de l'annonce : 
		String titre = request.getParameter("Article");
		Byte photo = Byte.parseByte(request.getParameter("Photo"));
		String description = request.getParameter("Description");
		Integer categorie = Integer.parseInt(request.getParameter("Categorie"));
		Integer miseAPrix = Integer.parseInt(request.getParameter("MiseAPrix"));
		LocalDate DebutEnchere = LocalDate.parse(request.getParameter("DateDebut"));
		LocalDate FinEnchere = LocalDate.parse(request.getParameter("DateFin"));
		String rueRetrait = request.getParameter("RueRetrait");
		String codePostal = request.getParameter("CodePostalRetrait");
		String ville = request.getParameter("VilleRetrait");
		
		//On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur user = (Utilisateur) sessionUser.getAttribute("utilisateur");
		
		Integer id = Integer.parseInt(sessionUser.getId());
		String pseudo = user.getPseudo();
		
		try {
			//Ajouter l'article à la BDD
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			ArticleVendu article = avm.ajouterArticle(titre, description, DebutEnchere, FinEnchere, miseAPrix, user, categorie, photo);
			
			//Récupérer tous mes articles
			ArrayList<ArticleVendu> listeArticleVendu = avm.rechercheArticlesByPseudo(pseudo);
			sessionUser.setAttribute("MesArticles", listeArticleVendu);
			
		} catch (BusinessException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Une ou plusieurs erreurs se sont produites :");
			for(int i : e.getListeCodesErreur())
				sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));
			
			System.err.println(sb.toString());
			
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("WEB-INF/jsp/Connexion/CreationCompte.jsp").include(request, response);
			out.print(sb.toString());
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("AccueilServlet");
		rd.forward(request, response);
		
	}

}