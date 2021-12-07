package fr.eni.projet.dal;

import fr.eni.projet.BO.Utilisateur;
/**
 * @author Loareos // Etienne
 *
 */


public class DAOFactory {
	public static DAO<Utilisateur> getUserDAO(){
		return new UserDAOJdbcImpl();
	}
}
