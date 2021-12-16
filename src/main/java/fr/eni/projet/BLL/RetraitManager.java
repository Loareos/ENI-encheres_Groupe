/**
 * 
 */
package fr.eni.projet.BLL;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Retrait;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.RetraitDAO;

/**
 * @author Etienne
 */
public class RetraitManager extends Manager {


	private RetraitDAO retraitDAO;

	//======================================================================//
	//								INSTANCE
	//======================================================================//

	private static RetraitManager instance;

	//=================================getInstance===========================================	

	public static RetraitManager getInstance() throws BusinessException{
		if(instance == null) {
			try {
				instance = new RetraitManager();
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

	public RetraitManager() throws BusinessException{
		retraitDAO = DAOFactory.getRetraitDAO();
	}

	//==============================  AjouterRetrait  ===========================
	public void ajouterRetrait(Integer noArticle,String rue,String code_postal,String ville) throws BusinessException{
		BusinessException exception = new BusinessException();
		
		//Verifie que le retrait n'existe pas
		if (this.retraitDAO.retraitExiste(noArticle))
			modifRetrait(noArticle,rue,code_postal,ville);
		else {
			Retrait retrait = new Retrait(noArticle, rue, code_postal, ville);
			verif(retrait, exception);
			if(!exception.hasErreurs())
				this.retraitDAO.insert(retrait);
			else
				throw exception;
		}
	}


	//========  MODIFICATION  ===========================================	
	
		public void modifRetrait(Integer noArticle,String rue,String code_postal,String ville) throws BusinessException{
			BusinessException exception = new BusinessException();
			Retrait retrait = new Retrait(noArticle, rue, code_postal, ville);
			verif(retrait, exception);
			if(!exception.hasErreurs()) {
				this.retraitDAO.update(retrait);
			}else
				throw exception;
		}
		
	//========  SELECT BY SEARCH  ===========================================	
		
		public Retrait RetraitById(Integer id) throws BusinessException {
			BusinessException exception = new BusinessException();
	
			if(this.retraitDAO.retraitExiste(id))
				return this.retraitDAO.selectById(id);
			else
				exception.ajouterErreur(CodesResultatBLL.POINT_RETRAIT_INCONNU);
			throw exception;
		}
		
		
	//========  SUPPRESSION  ===========================================	
	
		public void suppressionUser(Retrait retrait) throws BusinessException {
			this.retraitDAO.delete(retrait.getNoArticle());
		}
	
		
//	========  VERIFICATIONS  ===========================================	
		
		private static void verif(Retrait ret, BusinessException exception) {
			verifStringNombreEtVide(ret.getRue(),30,exception);
			verifStringNombreEtVide(ret.getCode_postal(),15,exception);
			verifStringNombreEtVide(ret.getVille(),30,exception);			
		}
}
