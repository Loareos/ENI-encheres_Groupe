package fr.eni.projet.projetServlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import fr.eni.projet.messages.LecteurMessage;

/**
 * Servlet implementation class ModifProfilServlet
 */
@WebServlet("/ModifProfilServlet")
public class ModifProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion/ModificationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String pseudoI = request.getParameter("PseudoI").trim();
		String nomI = request.getParameter("NomI").trim();
		String prenomI = request.getParameter("PrenomI").trim();
		String emailI = request.getParameter("emailI").trim();
		String rueI = request.getParameter("RueI").trim();
		String telI = request.getParameter("telI").trim();
		String codePostalI = request.getParameter("codePostalI").trim();
		String villeI = request.getParameter("VilleI").trim();
		String passwordI = request.getParameter("passwordI"); // Refuser les espaces dans le mot de passe
		String passwordConfirmI = request.getParameter("passwordConfirmI");


        //On récupère les infos de l'user connecté
		HttpSession sessionUser = request.getSession();
		Utilisateur user = (Utilisateur) sessionUser.getAttribute("utilisateur");
		String ancienMdp = user.getMotDePasse();
		
		System.out.println("le pseudo : ");
		System.out.println(pseudoI);
		
		// Modification Profil
		try {
			//Si le mot de passe ne change pas, on renvoie le meme.
			System.out.println("avant if : ");
			System.out.println(passwordI);
			if (passwordI == null) {
				passwordI = ancienMdp;
				passwordConfirmI = passwordI;
				System.out.println("pas de mdp");
			}
			System.out.println("mdp : ");
			System.out.println(passwordI);
			
			UtilisateurManager um = UtilisateurManager.getInstance();
			Utilisateur userModifie = um.modifProfil(user, pseudoI, nomI, prenomI, emailI, rueI, telI, codePostalI, villeI,
					passwordI, passwordConfirmI);

			System.out.println("modif faite");

			sessionUser.setAttribute("utilisateur", userModifie);

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion/Profil.jsp");
			rd.forward(request, response);

		} catch (BusinessException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Une ou plusieurs erreurs se sont produites :");
			for (int i : e.getListeCodesErreur())
				sb.append("\n").append("CODE ").append(i).append(" - ").append(LecteurMessage.getMessageErreur(i));

			System.err.println(sb.toString());

			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("WEB-INF/jsp/Connexion/CreationCompte.jsp").include(request, response);
			out.print(sb.toString());
		}


	}
}
