package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BLL.ArticleVenduManager;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.messages.LecteurMessage;
/**
 * 
 * @author RobinFerre
 * Edit clément
 */
/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//Récupérer les infos de l'annonce : 
//		if(request.getParameter("titreAfficher") != null) {
//			String titre = request.getParameter("titreAfficher");
//			String photo = request.getParameter("photoAfficher");
//			Integer meilleurOffre = Integer.parseInt(request.getParameter("meilleurOffreAfficher"));
//			LocalDateTime FinEnchere = LocalDateTime.parse(request.getParameter("FinEnchereAfficher"));
//			String codePostal = request.getParameter("codePostalAfficher");
//			String ville = request.getParameter("villeAfficher");
//			String vendeur = request.getParameter("vendeurAfficher");
//		}
		
		try {
			ArticleVenduManager avm = ArticleVenduManager.getInstance();
			List<ArticleVendu> lstArtEnCours = avm.getArticlesEnVente();
			request.setAttribute("listeArticles", lstArtEnCours);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);			

		} catch (BusinessException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Une ou plusieurs erreurs se sont produites :");
			for(int i : e.getListeCodesErreur())
				sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));

			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
		doGet(request, response);
	}
}
