package fr.eni.projet.dal;
/**
 * @author Loareos // Etienne
 *
 */
import fr.eni.projet.BusinessException;

// POURRA ETRE UTILISER AVEC LES DIFFERENTES INFOS A ENREGISTRER
public interface DAO<T> {
	public void insert(T obj) throws BusinessException;
	public void update(T obj) throws BusinessException;
	public T selectById(int idObj) throws BusinessException;
	public void delete(int idObj) throws BusinessException;
}
