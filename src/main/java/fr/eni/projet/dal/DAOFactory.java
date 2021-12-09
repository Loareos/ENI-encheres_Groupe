package fr.eni.projet.dal;

import fr.eni.projet.dal.jdbc.UserDAOJdbcImpl;
/**
 * @author Loareos // Etienne
 *
 */

public class DAOFactory {
	public static UtilisateurDAO getUserDAO(){
		return new UserDAOJdbcImpl();
	}
}
