package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.BusinessException;
import fr.eni.projet.BO.ArticleVendu;
import fr.eni.projet.BO.Categorie;
import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.CodesResultatDAL;
import fr.eni.projet.dal.ConnectionProvider;

//Edit by Clément modifs by Etienne

public class ArticleDAOJdbcImpl implements ArticleDAO {

	String sqlInsert = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?)";	
	String sqlUpdate = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_categorie = ? WHERE no_article = ?";
	String sqlSelectById = "SELECT nom_article, description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,a.no_utilisateur,a.no_categorie,"
			+ "pseudo,email,code_postal,ville,"
			+ "libelle "
			+ "FROM ARTICLES_VENDUS a "
			+ "INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie "
			+ "WHERE no_article = ?";
	
	String sqlDelete = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";

	String sqlSelectAll = "SELECT no_article,nom_article, description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,a.no_utilisateur,a.no_categorie,"
			+ "pseudo,email,code_postal,ville,"
			+ "libelle "
			+ "FROM ARTICLES_VENDUS a "
			+ "INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur "
			+ "INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie ";
	

	//=======================================================================//
	//
	//								INSERT
	//
	//=======================================================================//
	@Override
	public void insert(ArticleVendu art) throws BusinessException {
		checkNull(art);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);){
			int i = 1;
			
			stmt.setString(i++, art.getNomArticle());					// NOM
			stmt.setString(i++, art.getDescription());					// DESCRIPTION
			stmt.setDate(i++,Date.valueOf(art.getDateDebutEncheres()));	// DATE DEBUT
			stmt.setDate(i++, Date.valueOf(art.getDateFinEncheres()));	// DATE FIN
			stmt.setInt(i++, art.getMiseAPrix());						// MISE A PRIX
			stmt.setInt(i++, art.getVendeur().getNoUtilisateur());		// VENDEUR
			stmt.setInt(i++, art.getCategorie().getNoCategorie());		// CATEGORIE
//			stmt.setByte(i++, Byte.valueOf(art.getimgArticle()));		// IMAGE
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

	//=======================================================================//
	//
	//									UPDATE
	//
	//=======================================================================//
	@Override
	public void update(ArticleVendu art) throws BusinessException {
		checkNull(art);
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);){
			int i = 1;
			
			stmt.setString(i++, art.getNomArticle());					// NOM
			stmt.setString(i++, art.getDescription());					// DESCRIPTION	
			stmt.setDate(i++,Date.valueOf(art.getDateDebutEncheres())); // DATE DEBUT
			stmt.setDate(i++, Date.valueOf(art.getDateFinEncheres()));	// DATE FIN
			stmt.setInt(i++, art.getMiseAPrix());						// MISE A PRIX
			stmt.setInt(i++, art.getCategorie().getNoCategorie());		// CATEGORIE
//			stmt.setByte(i++, Byte.valueOf(art.getimgArticle()));		// IMAGE
			stmt.setInt(i++, art.getNoArticle());						// NO ARTICLE (POUR LE WHERE)
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
	public ArticleVendu selectById(int idArt) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);){
			stmt.setInt(1, idArt);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
													//	NO_USER			PSEUDO			MAIL			VILLE			CODE POSTAL	
				Utilisateur vendeur = userConstructore(rs.getInt(7),rs.getString(9),rs.getString(10),rs.getString(12),rs.getString(11));
													//		NO_CAT			LIBELLE
				Categorie categorie = categorieConstructor(rs.getInt(8),rs.getString(14));
						
				ArticleVendu art = new ArticleVendu(
						idArt, 						//noArticle
						rs.getString(1),			//nom
						rs.getString(2),			//description
						rs.getDate(3).toLocalDate(),//date start
						rs.getDate(4).toLocalDate(),//date end
						rs.getInt(5),				//mise a prix
						rs.getInt(6),				//prix de vente
						vendeur,					//vendeur
						categorie					//categorie
//						rs.getByte(9)				//image
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

	//=======================================================================//
	//
	//									DELETE
	//
	//=======================================================================//
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

	
	//=======================================================================//
	//
	//									SELECT ALL
	//
	//=======================================================================//
	@Override
	public List<ArticleVendu> selectAll() throws BusinessException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectAll);
				ResultSet rs = stmt.executeQuery();){
			while(rs.next()) {
													//	NO_USER			PSEUDO			MAIL			VILLE			CODE POSTAL	
				Utilisateur vendeur = userConstructore(rs.getInt(8),rs.getString(10),rs.getString(11),rs.getString(13),rs.getString(12));
													//		NO_CAT			LIBELLE
				Categorie categorie = categorieConstructor(rs.getInt(9),rs.getString(14));
						
				ArticleVendu art = new ArticleVendu(
						rs.getInt(1), 						//noArticle
						rs.getString(2),			//nom
						rs.getString(3),			//description
						rs.getDate(4).toLocalDate(),//date start
						rs.getDate(5).toLocalDate(),//date end
						rs.getInt(6),				//mise a prix
						rs.getInt(7),				//prix de vente
						vendeur,					//vendeur
						categorie					//categorie
//						rs.getByte(10)				//image
						);
				lstArticles.add(art);
			}
			return lstArticles;
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJET_ECHEC);
			throw businessException;
		}
	}
	
	//=======================================================================//
	//
	//									CHECK NULL
	//
	//=======================================================================//
	
	public void checkNull(ArticleVendu art) throws BusinessException {
		if(art == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.OBJET_NULL);
			throw businessException;
		}		
	}
	//=======================================================================//
	//
	//									SELECT BY VENDEUR (WIP)
	//
	//=======================================================================//
	@Override
	public ArticleVendu selectByVendeur(Integer idVendeur) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	//=======================================================================//
	//
	//									SELECT BY CATEGORIE (WIP)
	//
	//=======================================================================//
	@Override
	public ArticleVendu selectByCategorie(Integer idCategorie) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	//=======================================================================//
	//
	//									CONSTRUCTORS
	//
	//=======================================================================//
	
	private Utilisateur userConstructore(Integer no, String pseudo, String mail, String ville, String cp) {
		return new Utilisateur(no, pseudo, mail, cp, ville);
	}
	
	private Categorie categorieConstructor(Integer no, String libelle) {
		return new Categorie(no, libelle);
	}
	
	
}
