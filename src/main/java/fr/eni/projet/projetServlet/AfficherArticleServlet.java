package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BLL.ArticleVenduManager;
import fr.eni.projet.BLL.EnchereManager;
import fr.eni.projet.BLL.UtilisateurManager;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Enchere;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.messages.LecteurMessage;

/**
 * @author Clement
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

		//Récupérer l'id de l'annonce : 
		Integer idArticle = Integer.valueOf(request.getParameter("id"));

		System.out.println("mon id" + idArticle);
        //On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur user = (Utilisateur) sessionUser.getAttribute("utilisateur");
		System.out.println("2" + user);

		if (user == null) {
			request.setAttribute("user", false);
		} 
		if (user != null) {
			request.setAttribute("user", true);
		}
		
		try {
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			List<ArticleVendu> listeArticle = avm.getArticlesEnVente();
			
			int compte = 0;
			while(compte < listeArticle.size()) {
				if (idArticle == listeArticle.get(compte).getNoArticle()) {
					
					
					ArticleVendu article = new 
							ArticleVendu(idArticle, listeArticle.get(compte).getNomArticle(), listeArticle.get(compte).getDescription(),
									listeArticle.get(compte).getDateDebutEncheres(), listeArticle.get(compte).getDateFinEncheres(),
									listeArticle.get(compte).getMiseAPrix(), listeArticle.get(compte).getPrixVente(), listeArticle.get(compte).getVendeur(),
									listeArticle.get(compte).getCategorie());
					
					Enchere enchere = new Enchere();
					request.setAttribute("article", article);
					request.setAttribute("acheteur", enchere);
				}
				compte += 1;
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Vente/Article.jsp");
			rd.forward(request, response);
		} catch (BusinessException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Une ou plusieurs erreurs se sont produites :");
			for(int i : e.getListeCodesErreur())
				sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));

			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("AccueilServlet");
			rd.forward(request, response);
			out.print(sb.toString());
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur user = (Utilisateur) sessionUser.getAttribute("utilisateur");
		System.out.println(user);

		//Recupérer les infos de l'enchere
		Integer montant_enchere = Integer.parseInt(request.getParameter("montant"));
		Integer idArticle = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(montant_enchere);
		
		
				try {
					ArticleVenduManager avm = ArticleVenduManager.getInstance();
					List<ArticleVendu> listeArticle = avm.getArticlesEnVente();
					
					int compte = 0;
					while(compte < listeArticle.size()) {
						if (idArticle == listeArticle.get(compte).getNoArticle()) {
							
							
							ArticleVendu article = new 
									ArticleVendu(idArticle, listeArticle.get(compte).getNomArticle(), listeArticle.get(compte).getDescription(),
											listeArticle.get(compte).getDateDebutEncheres(), listeArticle.get(compte).getDateFinEncheres(),
											listeArticle.get(compte).getMiseAPrix(), listeArticle.get(compte).getPrixVente(), listeArticle.get(compte).getVendeur(),
											listeArticle.get(compte).getCategorie());
							

							EnchereManager em = EnchereManager.getInstance();
							Enchere enchere = em.ajouterEnchere(user, article, LocalDate.now(), montant_enchere);
							
							request.setAttribute("article", article);
							request.setAttribute("acheteur", enchere);
						}
						compte += 1;
					}
					
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Vente/Article.jsp");
					rd.forward(request, response);
				} catch (BusinessException e) {
					StringBuffer sb = new StringBuffer();
					sb.append("Une ou plusieurs erreurs se sont produites :");
					for(int i : e.getListeCodesErreur())
						sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));

					PrintWriter out = response.getWriter();
					RequestDispatcher rd = request.getRequestDispatcher("AccueilServlet");
					rd.forward(request, response);
					out.print(sb.toString());
				}
		

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Vente/Article.jsp");
		request.setAttribute("id", idArticle);
		doGet(request, response);
	}
	
	

}
