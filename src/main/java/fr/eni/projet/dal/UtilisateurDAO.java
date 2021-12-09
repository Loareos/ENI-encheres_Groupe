package fr.eni.projet.dal;

import fr.eni.projet.BO.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur> {
	
	public Utilisateur selectByPseudo(String pseudo) throws DALException;
	public Utilisateur selectByMail(String email) throws DALException;
	public boolean pseudoExist(String pseudo) throws DALException;
	public boolean mailExist(String email) throws DALException;
	
}
