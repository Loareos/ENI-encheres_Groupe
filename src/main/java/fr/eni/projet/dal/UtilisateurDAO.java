package fr.eni.projet.dal;

import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.BusinessException;

public interface UtilisateurDAO extends DAO<Utilisateur> {
	
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	public Utilisateur selectByMail(String email) throws BusinessException;
	public boolean pseudoExist(String pseudo) throws BusinessException;
	public boolean mailExist(String email) throws BusinessException;
	
}
