package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Enchere;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	String sqlInsert = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere, montant_enchere) VALUES (?,?,?,?)";
	String sqlUpdate = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ? WHERE no_utilisateur = ? AND no_article = ?";
	String sqlSelectById = "SELECT date_enchere, montant_enchere, no_vendeur FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	String sqlDelete = "DELETE FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		checkNull(enchere);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert);){
			int i = 1;
			stmt.setInt(i++, enchere.getNoUtilisateur());
			stmt.setInt(i++, enchere.getNoArticle());
			Date date = Date.valueOf(enchere.getDateEnchere().toLocalDate());
			stmt.setDate(i++, date);
			stmt.setInt(i++, enchere.getMontant_enchere());
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void update(Enchere enchere) throws BusinessException {
		checkNull(enchere);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);){
			int i = 1;
			Date date = Date.valueOf(enchere.getDateEnchere().toLocalDate());
			stmt.setDate(i++, date);
			stmt.setInt(i++, enchere.getMontant_enchere());
			stmt.setInt(i++, enchere.getNoUtilisateur());
			stmt.setInt(i++, enchere.getNoArticle());
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}		
	}

	@Override // NE PAS UTILISER
	public Enchere selectById(int idEnchere) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // NE PAS UTILISER
	public void delete(int idEnchere) throws BusinessException {
		// TODO Auto-generated method stub
	}

	public void checkNull(Enchere enchere) throws BusinessException {
		if(enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}		
	}

	@Override
	public Enchere selectById(int idUser, int idArticle) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);){
			stmt.setInt(1, idUser);
			stmt.setInt(2, idArticle);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				LocalDateTime date = LocalDateTime.of(rs.getDate(1).toLocalDate(), LocalTime.of(0, 0));
				Enchere enchere = new Enchere(idUser,
												rs.getInt(3),
												idArticle,
												date,
												rs.getInt(2));
				 return enchere;
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int idUser, int idArticle) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);){
			stmt.setInt(1, idUser);
			stmt.setInt(2, idArticle);
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
			throw businessException;
		}		
	}

}
