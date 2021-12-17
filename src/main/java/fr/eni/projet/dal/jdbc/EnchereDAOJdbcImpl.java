package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Enchere;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.EnchereDAO;

//Par Clément
public class EnchereDAOJdbcImpl implements EnchereDAO {

	String sqlInsert = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere, montant_enchere) VALUES (?,?,?,?)";
	String sqlUpdate = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ? WHERE no_utilisateur = ? AND no_article = ?";
	String sqlSelectById = "SELECT date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	String sqlDelete = "DELETE FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	
	String sqlEnchereExiste = "SELECT COUNT(*) FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	String sqlSelectByIdMontant = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_article = ? AND montant_enchere = ?";
	String sqlSelectAll = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_article = ? ";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		checkNull(enchere);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert);){
			int i = 1;
			stmt.setInt(i++, enchere.getAcheteur().getNoUtilisateur());
			stmt.setInt(i++, enchere.getArticle().getNoArticle());
			stmt.setDate(i++,Date.valueOf(enchere.getDateEnchere()));
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
			stmt.setDate(i++,Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(i++, enchere.getMontant_enchere());
			stmt.setInt(i++, enchere.getAcheteur().getNoUtilisateur());
			stmt.setInt(i++, enchere.getArticle().getNoArticle());
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}		
	}
	
	    //=======================================================================//
		//
		//									SELECT ALL
		//
		//=======================================================================//
		@Override
		public List<Enchere> selectAll(int idArticle) throws BusinessException {
			List<Enchere> lstEnchere = new ArrayList<Enchere>();
			try(Connection cnx = ConnectionProvider.getConnection()){
					PreparedStatement stmt = cnx.prepareStatement(sqlSelectAll);
					stmt.setInt(1, idArticle);
					ResultSet rs = stmt.executeQuery();
				while(rs.next()) {

					int idUtilisateur = rs.getInt(1);
					
					Enchere enchere = new Enchere(
							rs.getInt(1), 				//noUtilisateur
							rs.getInt(2),			    //noArticle
							rs.getDate(3).toLocalDate(),//date
							rs.getInt(4)                //Montant
							);
					lstEnchere.add(enchere);
				}
				return lstEnchere;
			}catch(Exception e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
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
				LocalDate date = rs.getDate(1).toLocalDate();
				Enchere enchere = new Enchere(idUser,
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
	
	//===========================enchereExiste=============================//
		// renvoie true si il existe
		
	@Override
	public boolean enchereExist(int noUtilisateur, int noArticle) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlEnchereExiste);) {
			stmt.setInt(1, noUtilisateur);
			stmt.setInt(2, noArticle);
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

	@Override
	public Enchere selectByIdMontant(int idEnchere, int montant) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectByIdMontant);){
			stmt.setInt(1, idEnchere);
			stmt.setInt(2, montant);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				System.out.println("elelel");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(4));
				
				Enchere newEnchere = new Enchere(rs.getInt(1), rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getInt(4));

				System.out.println(rs.getInt(1));
				System.out.println("avant mana" + newEnchere);
				return newEnchere;
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}

}
