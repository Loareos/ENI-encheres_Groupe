package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	String sqlInsert = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_vendeur,no_categorie) VALUES (?,?,?,?,?,?,?)"; //RAJOUTER L'ACHETEUR DANS LA BDD
	String sqlUpdate = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_acheteur = ?, no_categorie = ? WHERE no_article = ?";
	String sqlSelectById = "SELECT nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_vendeur,no_acheteur,no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?";
	String sqlDelete = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
	
	
	@Override
	public void insert(ArticleVendu art) throws BusinessException {
		checkNull(art);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);){
			int i = 1;
			
			stmt.setString(i++, art.getNomArticle());
			stmt.setString(i++, art.getDescription());
			Date dateStart = Date.valueOf(art.getDateDebutEncheres().toLocalDate()); // BESOIN D'UNE HEURE ?
			stmt.setDate(i++,dateStart);
			Date dateEnd = Date.valueOf(art.getDateFinEncheres().toLocalDate()); //BESOIN D'UNE HEURE ?
			stmt.setDate(i++, dateEnd);
			stmt.setInt(i++, art.getMiseAPrix());
			stmt.setInt(i++, art.getNoUtilisateur()); //CHANGER POUR NO_VENDEUR
			stmt.setInt(i++, art.getNoCategorie());
			stmt.execute();
			try(ResultSet rs = stmt.getGeneratedKeys()){
				rs.next();
				art.setNoArticle(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void update(ArticleVendu art) throws BusinessException {
		checkNull(art);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);){
			int i = 1;
			
			stmt.setString(i++, art.getNomArticle());
			stmt.setString(i++, art.getDescription());
			Date dateStart = Date.valueOf(art.getDateDebutEncheres().toLocalDate()); // BESOIN D'UNE HEURE ?
			stmt.setDate(i++,dateStart);
			Date dateEnd = Date.valueOf(art.getDateFinEncheres().toLocalDate()); //BESOIN D'UNE HEURE ?
			stmt.setDate(i++, dateEnd);
			stmt.setInt(i++, art.getMiseAPrix());
//			stmt.setInt(i++, art.()); //CHANGER POUR NO_ACHETEUR
			stmt.setInt(i++, art.getNoCategorie());
			stmt.setInt(i++, art.getNoArticle());
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public ArticleVendu selectById(int idArt) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);){
			stmt.setInt(1, idArt);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				LocalDateTime ldtStart = LocalDateTime.of(rs.getDate(3).toLocalDate(), LocalTime.of(0, 0));
				LocalDateTime ldtEnd = 	LocalDateTime.of(rs.getDate(4).toLocalDate(), LocalTime.of(0, 0));			
				ArticleVendu art = new ArticleVendu(
						(Integer)idArt, //noArticle
						rs.getString(1),//nom
						rs.getString(2),//description
						ldtStart,//date start
						ldtEnd,//date end
						rs.getInt(5),//mise a prix
						rs.getInt(6),//prix de vente
						(Integer)rs.getInt(7),//noVendeur
						(Integer)rs.getInt(8),//noAcheteur // A AJOUTER
						(Integer)rs.getInt(9)//noCategorie
						);
				return art;
			}
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int idArt) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);){
			stmt.setInt(1, idArt);
			stmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_ECHEC);
			throw businessException;
		}
	}

	public void checkNull(ArticleVendu art) throws BusinessException {
		if(art == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}		
	}
	
}
