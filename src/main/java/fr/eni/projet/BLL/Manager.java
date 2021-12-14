package fr.eni.projet.BLL;

import fr.eni.projet.BusinessException;

public abstract class Manager {
	
	/**
	 * Cette méthode permet de vérifier 
	 * les règles à respecter sur le nombre de caractère et qu'il ne soit pas vide.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet BLLException.
	 * @param utilisateurStrd
	 * @throws BusinessException 
	 * @param BusinessException 
	 */
	protected static void verifStringNombreEtVide(String test, int max,BusinessException exception){
		if(test == null || test.length() == 0)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_NULL);
		if(test.length() > max)
			exception.ajouterErreur(CodesResultatBLL.INSERT_PARAMETER_LENGTH_MAX);
	}
}
