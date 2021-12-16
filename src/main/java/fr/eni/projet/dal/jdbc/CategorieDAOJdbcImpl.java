package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	String sqlInsert = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	String sqlUpdate = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";
	String sqlSelectById = "SELECT nom_article FROM CATEGORIES WHERE no_categorie = ?";
	String sqlDelete = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
	
	String sqlSelectAll = "SELECT no_categorie,libelle FROM CATEGORIES";
	String sqlIdExiste = "SELECT COUNT(*) FROM CATEGORIES WHERE no_categorie = ?";

	@Override
	public void insert(Categorie cat) throws BusinessException {
		checkNull(cat);
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, cat.getLibelle());
			stmt.execute();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				rs.next();
				cat.setNoCategorie(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void update(Categorie cat) throws BusinessException {
		checkNull(cat);
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);) {
			stmt.setString(1, cat.getLibelle());
			stmt.setInt(2, cat.getNoCategorie());
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public Categorie selectById(int idCat) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);) {
			stmt.setInt(1, idCat);
			try (ResultSet rs = stmt.executeQuery();) {
				rs.next();
				return new Categorie(idCat, rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int idCat) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);) {
			stmt.setInt(1, idCat);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
			throw businessException;
		}
	}

	public void checkNull(Categorie cat) throws BusinessException {
		if (cat == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}
	}

	@Override
	public boolean idExist(Integer id) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlIdExiste);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				rs.next();
				if (rs.getInt(1) > 0)
					return true;
				else
					return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.IS_EXISTING_OBJET_ECHEC);
			throw businessException;
		}
	}
//		==============SELECT ALL==============

	@Override
	public List<Categorie> selectAllCategorie() throws BusinessException {
		List<Categorie> lstCategorie = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectAll);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
															// NO_CAT 		LIBELLE
				Categorie categorie = new Categorie(rs.getInt(1), rs.getString(2));
				lstCategorie.add(categorie);
			}
			return lstCategorie;
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}
}
