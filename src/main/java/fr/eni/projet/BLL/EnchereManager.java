/**
 * 
 */
package fr.eni.projet.BLL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Enchere;
import fr.eni.projet.BO.Retrait;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.EnchereDAO;
import fr.eni.projet.dal.RetraitDAO;
import fr.eni.projet.dal.UtilisateurDAO;

/**
 * @author /!\ /!\ /!\ /!\ /!\ /!\ Clement /!\ /!\ /!\ /!\ /!\ 
 *	Modif by
 */
public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	private UtilisateurDAO userDao;
	private ArticleDAO articleDAO;

	//======================================================================//
	//								INSTANCE
	//======================================================================//

	private static EnchereManager instance;

	//=================================getInstance===========================================	

	public static EnchereManager getInstance() throws BusinessException{
		if(instance == null) {
			try {
				instance = new EnchereManager();
			} catch (Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatBLL.GET_INSTANCE);
				throw businessException;
			}
		}
		return instance;
	}

	//======================================================================//
	//								Constructeurs
	//======================================================================//
	/**
	 *		Constructeur Vide
	 */

	public EnchereManager() throws BusinessException{
		enchereDAO = DAOFactory.getEnchereDAO();
		userDao = DAOFactory.getUserDAO();
		articleDAO = DAOFactory.getArticleDAO();
	}

	//==============================  AjouterEnchere  ===========================
	public Enchere ajouterEnchere(Utilisateur acheteur, ArticleVendu article, LocalDate dateEnchere, Integer montant) throws BusinessException {
		BusinessException exception = new BusinessException();

		Enchere enchere = new Enchere(acheteur, article, dateEnchere, montant);

		verif(enchere, exception);
		if (!this.userDao.idExist(acheteur.getNoUtilisateur()))
			exception.ajouterErreur(CodesResultatBLL.VENDEUR_INCONNU);
		if (!this.articleDAO.idExist(article.getNoArticle()))
			exception.ajouterErreur(CodesResultatBLL.ARTICLE_INCONNU);

		//Ajouts
		if (!exception.hasErreurs()) {
			if (SelectAll(article.getNoArticle()) != null) {
				if (montant <= SelectAll(article.getNoArticle()).getMontant_enchere()) {
					exception.ajouterErreur(CodesResultatBLL.MISE_INSUFISANTE);
				}
				if (montant > SelectAll(article.getNoArticle()).getMontant_enchere()) {
					if (this.enchereDAO.enchereExist(acheteur.getNoUtilisateur(), article.getNoArticle())) {
						this.enchereDAO.update(enchere);
					}
					if (!this.enchereDAO.enchereExist(acheteur.getNoUtilisateur(), article.getNoArticle())) {
						this.enchereDAO.insert(enchere);
					}
				}
			}
			if (SelectAll(article.getNoArticle()) == null) {
				if (this.enchereDAO.enchereExist(acheteur.getNoUtilisateur(), article.getNoArticle())) {
					this.enchereDAO.update(enchere);
				}
				if (!this.enchereDAO.enchereExist(acheteur.getNoUtilisateur(), article.getNoArticle())) {
					this.enchereDAO.insert(enchere);
				}
			}
			

			return enchere;
		}else
			throw exception;
		
		
	}
		
	//========  SELECT BY SEARCH  ===========================================	
		
		public Enchere EnchereById(Integer idUtilisateur, Integer idArticle) throws BusinessException {
			BusinessException exception = new BusinessException();
	
			System.out.println(this.enchereDAO.enchereExist(idUtilisateur, idArticle));
			if(this.enchereDAO.enchereExist(idUtilisateur, idArticle))
				return this.enchereDAO.selectById(idUtilisateur, idArticle);
			if(!this.enchereDAO.enchereExist(idUtilisateur, idArticle)) {
				exception.ajouterErreur(CodesResultatBLL.ENCHERE_INEXISTANTE);
				return null;
				}
			throw exception;
		}
		
		//========  SELECT ALL  ===========================================	
		
				public Enchere SelectAll(Integer idArticle) throws BusinessException {
					BusinessException exception = new BusinessException();
					List<Enchere> lstEnchere = new ArrayList<Enchere>();
					lstEnchere = this.enchereDAO.selectAll(idArticle);
					
					if(lstEnchere.isEmpty()) {
						System.out.println("vide");
	                    return null;
					}
					if(lstEnchere != null) {
						System.out.println("pas vide");
						int montantMax = 0;
						int i = 0;
						while (i < lstEnchere.size()) {
							List<Integer> montants = new ArrayList<Integer>();
							montants.add(lstEnchere.get(i).getMontant_enchere());

							Collections.sort(montants);
							
							montantMax = montants.get(montants.size() - 1);
							i += 1;
						}
						
						Enchere enchere = this.enchereDAO.selectByIdMontant(idArticle, montantMax);
	                    return enchere;
					}
				
					throw exception;
				}
				
		
	//========  SUPPRESSION  ===========================================	
	
		public void suppressionUser(Enchere enchere) throws BusinessException {
			this.enchereDAO.delete(enchere.getidAcheteur(),enchere.getidArticle());
		}
	
		
//	========  VERIFICATIONS  ===========================================	
		
		private static void verif(Enchere enchere, BusinessException exception) {
			if (enchere.getMontant_enchere() < 0)
				exception.ajouterErreur(CodesResultatBLL.CREDIT_NEGATIF);		
		}
}
