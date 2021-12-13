package fr.eni.projet.projetServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BLL.UtilisateurManager;
import fr.eni.projet.BO.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        //On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur re = (Utilisateur) sessionUser.getAttribute("utilisateur");
		
		//On récupère le nom du pseudo cliqué
		String pseudoSelectionne = request.getParameter("profilSelectionne").trim();

		//Profil de quelqu'un d'autre
		if(pseudoSelectionne.contains(re.getPseudo()) == false) {
			sessionUser.setAttribute("MonProfil", null);
			request.setAttribute("pseudo", "test");
			
			UtilisateurManager um;

			System.out.println("dans le if");
			
			try {
				System.out.println("dans try");
				um = UtilisateurManager.getInstance();
				Utilisateur users = um.rechercheUser(pseudoSelectionne); 
				
				Utilisateur profilSelectionneUser = new Utilisateur(users.getCredit(), users.getPseudo(),users.getNom(),users.getPrenom(),users.getEmail(),users.getRue(),users.getTelephone(),users.getCodePostal(),users.getVille(),users.getMotDePasse(),users.getAdministrateur());
				sessionUser.setAttribute("profilSelectionneUser", profilSelectionneUser);
				
				
				
				System.out.println(profilSelectionneUser.getEmail());
				
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		//Mon pseudo
		if(pseudoSelectionne.contains(re.getPseudo())) {
			sessionUser.setAttribute("MonProfil", "moi");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion/Profil.jsp");
		rd.forward(request, response);
	}
}
