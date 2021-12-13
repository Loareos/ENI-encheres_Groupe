package fr.eni.projet.dal.jdbc;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Retrait;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	@Override
	public void insert(Retrait ret) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Retrait ret) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Retrait selectById(int idRet) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idRet) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	public void checkNull(Retrait ret) throws BusinessException {
		if(ret == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}		
	}

}
