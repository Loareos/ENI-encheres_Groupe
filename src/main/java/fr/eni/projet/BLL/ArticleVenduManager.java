package fr.eni.projet.BLL;

import java.time.LocalDate;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

/**
 * @author /!\ /!\ /!\ /!\ /!\ auteur à mettre /!\ /!\ /!\ /!\ /!\ Modif by Etienne
 */
public class ArticleVenduManager extends Manager {

	private ArticleDAO articleDao;
	private UtilisateurDAO userDao;
	private CategorieDAO categorieDao;
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
		userDao = DAOFactory.getUserDAO();
		categorieDao = DAOFactory.getCategorieDAO();
	}

////=======================  CREATION ARTICLE  ===========================================	
	public void ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres,LocalDate dateFinEncheres, Integer miseAPrix, Utilisateur vendeur, Categorie Categorie, Byte imgArticle)
			throws BusinessException {
		BusinessException exception = new BusinessException();

		ArticleVendu art = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, vendeur, Categorie, imgArticle);

		verif(art, exception);
		if (!this.userDao.idExist(vendeur.getNoUtilisateur()))
			exception.ajouterErreur(CodesResultatBLL.VENDEUR_INCONNU);
		if (!this.categorieDao.idExist(Categorie.getNoCategorie()))
			exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);

		if (!exception.hasErreurs())
			this.articleDao.insert(art);
		else
			throw exception;
	}

////==========================  MODIFICATION ARTICLE  ===========================================	
	public void modifArticle(ArticleVendu art, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Utilisateur vendeur, Categorie Categorie, Byte imgArticle)
			throws BusinessException {

		BusinessException exception = new BusinessException();

		ArticleVendu artModif = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix,
				vendeur, Categorie, imgArticle);

		verif(artModif, exception);

		if (!this.userDao.idExist(vendeur.getNoUtilisateur()))
			exception.ajouterErreur(CodesResultatBLL.VENDEUR_INCONNU);
		if (!this.categorieDao.idExist(Categorie.getNoCategorie()))
			exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);

		if (!exception.hasErreurs())
			this.articleDao.insert(artModif);
		else
			throw exception;
	}

	// ======== SELECT BY SEARCH ===========================================

	public ArticleVendu rechercheArticle(Utilisateur id1, Categorie id2) throws BusinessException {
		BusinessException exception = new BusinessException();

		if (!this.userDao.idExist(id1.getNoUtilisateur()) && !this.categorieDao.idExist(id2.getNoCategorie())) {
				exception.ajouterErreur(CodesResultatBLL.VENDEUR_INCONNU);
				exception.ajouterErreur(CodesResultatBLL.CATEGORIE_INCONNU);
		}else if(this.userDao.idExist(id1.getNoUtilisateur()))
			return this.articleDao.selectByVendeur(id1.getNoUtilisateur());
		else 
			return this.articleDao.selectByCategorie(id2.getNoCategorie());

		throw exception;
	}

////==========================  SUPPRESSION  ===========================================	

	public void suppressionArticle(ArticleVendu art) throws BusinessException {
		this.articleDao.delete(art.getNoArticle());
	}

////==========================  VERIFICATIONS  ===========================================	

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
