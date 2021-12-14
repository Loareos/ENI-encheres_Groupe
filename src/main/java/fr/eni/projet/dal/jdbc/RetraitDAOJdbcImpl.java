package fr.eni.projet.dal.jdbc;
/**
 * @author junisaru69
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.Retrait;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

	String sqlInsert = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) "
						+ "VALUES (?,?,?,?)";
	
	String sqlUpdate = "UPDATE RETRAITS SET no_article = ?, rue = ?, code_postal = ?, ville = ? "
						+ "WHERE no_retrait = ?";
	
	String sqlSelectById = "SELECT no_article,rue,code_postal,ville "
						+ "FROM RETRAITS WHERE no_retrait = ?";
	
	String sqlDelete = "DELETE FROM RETRAITS WHERE no_retrait = ?";
	
	String sqlRetraitExiste = "SELECT COUNT(*) FROM RETRAITS WHERE no_article = ?";
	

	//=======================================================================//
	//
	//								INSERT
	//
	//=======================================================================//

	@Override
	public void insert(Retrait ret) throws BusinessException {

		checkNull(ret);

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(sqlInsert);){

			int i = 1;
			stmt.setInt		(i++, ret.getNoArticle());
			stmt.setString	(i++, ret.getRue());
			stmt.setString	(i++, ret.getCode_postal());
			stmt.setString	(i++, ret.getVille());
			stmt.execute();

			try(ResultSet rs = stmt.getGeneratedKeys()){
				rs.next();
				ret.setNoRetrait(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	//=======================================================================//
	//
	//									UPDATE
	//
	//=======================================================================//

	@Override
	public void update(Retrait ret) throws BusinessException {

		checkNull(ret);

		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);){

			int i = 1;
			stmt.setInt		(i++, ret.getNoArticle());
			stmt.setString	(i++, ret.getRue());
			stmt.setString	(i++, ret.getCode_postal());
			stmt.setString	(i++, ret.getVille());
			stmt.setInt		(i++, ret.getNoRetrait());
			stmt.execute();

		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_ECHEC);
			throw businessException;
		}
	}

	//=======================================================================//
	//
	//									SELECT BY ID
	//
	//=======================================================================//

	@Override
	public Retrait selectById(int noRetrait) throws BusinessException {

		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);){

			stmt.setInt(1, noRetrait);

			try (ResultSet rs = stmt.executeQuery()){

				Retrait retrait = new Retrait(noRetrait,
						rs.getInt("no_article"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville")
						);
				return retrait;
			} 
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}

	//=======================================================================//
	//
	//									DELETE
	//
	//=======================================================================//

	@Override
	public void delete(int noRetrait) throws BusinessException {

		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);){

			stmt.setInt(1, noRetrait);
			stmt.execute();

		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
			throw businessException;
		}
	}
	
	//===========================retraitExiste=============================//
	// renvoie true si il existe
	
	@Override
	public boolean retraitExiste(int noArticle) throws BusinessException {
		
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlRetraitExiste);){
			stmt.setInt(1, noArticle);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				if(rs.getInt(1) > 0)
					return true;
				else
					return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.IS_EXISTING_OBJET_ECHEC);
			throw businessException;
		}
	}

	//									
	//==================================checkNull=============================//

	public void checkNull(Retrait retrait) throws BusinessException {
		if(retrait == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}		
	}

}
