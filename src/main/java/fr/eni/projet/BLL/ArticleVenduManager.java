package fr.eni.projet.BLL;

import java.time.LocalDate;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.DAOFactory;

/**
 * @author /!\ /!\ /!\ /!\ /!\ auteur à mettre /!\ /!\ /!\ /!\ /!\ Modif by
 */
public class ArticleVenduManager extends Manager {

	private ArticleDAO articleDao;
	private static ArticleVenduManager instance;

	public static ArticleVenduManager getInstance() throws BusinessException {
		if (instance == null) {
			try {
				instance = new ArticleVenduManager();
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatBLL.GET_INSTANCE);
				throw businessException;
			}
		}
		return instance;
	}

	private ArticleVenduManager() throws BusinessException {
		articleDao = DAOFactory.getArticleDAO();
	}

//
////=======================  CREATION ARTICLE  ===========================================	
	public void ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer noVendeur, Integer noCategorie)
			throws BusinessException {
		BusinessException exception = new BusinessException();

		ArticleVendu art = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix,
				noVendeur, noCategorie);

		verif(art, exception);

		if (articleDao.vendeurExiste(noVendeur))
			exception.ajouterErreur(CodesResultatBLL.VENDEUR_INCONNU);
		if (articleDao.categorieExiste(noCategorie))
			exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);

		if (!exception.hasErreurs())
			this.articleDao.insert(art);
		else
			throw exception;

	}

//	
////==========================  MODIFICATION ARTICLE  ===========================================	
//
//	public  ArticleVendu modifArticle(Integer noArticle, String nomArticle, String description,
//			LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, Integer miseAPrix, Integer prixVente,
//			Integer noVendeur, Integer noAcheteur, Integer noCategorie) throws BusinessException {
//		BusinessException exception = new BusinessException();
//		return null;

	// Verifie que le mot de passe et la confirmation sont les mêmes
//		if(!mdp.equals(verifMdp))
//			exception.ajouterErreur(CodesResultatBLL.MDP_VERIF_DIFFERENTS);
//		
//		if(!art.getPseudo().equals(pseudo))
//			if(this.articleDao.pseudoExist(user.getPseudo()))
//				exception.ajouterErreur(CodesResultatBLL.EXISTING_PSEUDO);
//			
//		if(!art.getEmail().equals(email))
//			if(this.articleDao.mailExist(user.getEmail()))
//				exception.ajouterErreur(CodesResultatBLL.EXISTING_MAIL);
//
//		ArticleVendu modifArticle = new Utilisateur(Integer noArticle, String nomArticle, String description,
//		LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres, Integer miseAPrix, Integer prixVente,
//		Integer noVendeur, Integer noAcheteur, Integer noCategorie));
//		verifArticleVendu(modifArticle, exception);	
//
//		if(!exception.hasErreurs()) {
//			this.articleDao.update(userModif);
//			return userModif;
//		}else
//			throw exception;
//	}

	// ======== SELECT BY SEARCH ===========================================

//		public ArtivcleVendu rechercheArticle(String id) throws BusinessException {
//			ArtivcleVendu art = null;
//			BusinessException exception = new BusinessException();
//
//			if(this.articleDao.pseudoExist(id))
//				return this.articleDao.selectByPseudo(id);
//			else if (this.articleDao.mailExist(id))
//				return this.articleDao.selectByMail(id);
//			else
//				exception.ajouterErreur(CodesResultatBLL.UTILISATEUR_INCONNU);
//			throw exception;
//		}

////==========================  SUPPRESSION  ===========================================	

//	public void suppressionArticle(ArticleVendu art) throws BusinessException {
//		this.articleDao.delete(art.getNoArticle());
//	}
//
//	
////==========================  VERIFICATIONS  ===========================================	
//	
	private static void verif(ArticleVendu art, BusinessException exception) {
		verifStringNombreEtVide(art.getNomArticle(), 30, exception);
		verifStringNombreEtVide(art.getDescription(), 300, exception);
		if (art.getDateDebutEncheres().isBefore(LocalDate.now()))
			exception.ajouterErreur(CodesResultatBLL.DATE_DEBUT_ENCHERE_INVALIDE);
		if (art.getDateFinEncheres().isBefore(art.getDateDebutEncheres())
				|| art.getDateFinEncheres().isEqual(art.getDateDebutEncheres()))
			exception.ajouterErreur(CodesResultatBLL.DATE_FIN_ENCHERE_INVALIDE);
		if (art.getMiseAPrix() < 0)
			exception.ajouterErreur(CodesResultatBLL.CREDIT_NEGATIF);

	}

}
