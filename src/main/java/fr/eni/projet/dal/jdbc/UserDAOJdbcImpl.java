package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import fr.eni.projet.BO.Utilisateur;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.UtilisateurDAO;

/**
 * @author Loareos // Etienne 
 *
 */

public class UserDAOJdbcImpl implements UtilisateurDAO {

	String sqlInsert = "INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code-postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,b?)";
	String sqlUpdate = "UPDATE UTILISATEUR SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code-postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ?";
	String sqlSelectById = "SELECT pseudo, nom, prenom, email, telephone, rue, code-postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEUR WHERE no_utilisateur = ?";
	String sqlDelete = "DELETE FROM UTILISATEUR WHERE no_utilisateur = ?";
	
	String sqlSelectByPseudo = "SELECT no_utilisateur, credit, nom, prenom, email, telephone, rue, code-postal, ville, mot_de_passe, administrateur FROM UTILISATEUR WHERE pseudo = ?";
	String sqlSelectByMail = "SELECT no_utilisateur, credit, pseudo, nom, prenom, telephone, rue, code-postal, ville, mot_de_passe, administrateur FROM UTILISATEUR WHERE email = ?";
	String sqlPseudoExiste = "SELECT COUNT (*) FROM UTILISATEUR WHERE pseudo = ?";
	String sqlMailExiste = "SELECT COUNT (*) FROM UTILISATEUR WHERE email = ?";
	
	
	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);){
			int i = 1;
			stmt.setString(i++, utilisateur.getPseudo());
			stmt.setString(i++, utilisateur.getNom());
			stmt.setString(i++, utilisateur.getPrenom());
			stmt.setString(i++, utilisateur.getEmail());
			stmt.setString(i++, utilisateur.getTelephone());
			stmt.setString(i++, utilisateur.getRue());
			stmt.setString(i++, utilisateur.getCodePostal()); 
			stmt.setString(i++, utilisateur.getVille());
			stmt.setString(i++, utilisateur.getMotDePasse());
			stmt.setInt(i++, utilisateur.getCredit());
			if(utilisateur.getAdministrateur())
				stmt.setString(i++, "1");
			else
				stmt.setString(i++, "0");
			stmt.execute();
			try(ResultSet rs = stmt.getGeneratedKeys()){
				rs.next();
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlUpdate);){
			int i = 1;
			stmt.setString(i++, utilisateur.getPseudo());
			stmt.setString(i++, utilisateur.getNom());
			stmt.setString(i++, utilisateur.getPrenom());
			stmt.setString(i++, utilisateur.getEmail());
			stmt.setString(i++, utilisateur.getTelephone());
			stmt.setString(i++, utilisateur.getRue());
			stmt.setString(i++, utilisateur.getCodePostal()); 
			stmt.setString(i++, utilisateur.getVille());
			stmt.setString(i++, utilisateur.getMotDePasse());
			stmt.setInt(i++, utilisateur.getCredit());
			if(utilisateur.getAdministrateur())
				stmt.setString(i++, "1");
			else
				stmt.setString(i++, "0");
			stmt.setInt(i++, utilisateur.getNoUtilisateur());
			stmt.execute();
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public Utilisateur selectById(int idUtilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectById);){
			stmt.setInt(1, idUtilisateur);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				Utilisateur u = new Utilisateur(idUtilisateur,  // ADAPTER L'ORDRE AVEC LE CONSTRUCTEUR
							rs.getInt(10),	// CREDIT
							rs.getString(1), // PSEUDO
							rs.getString(2), // NOM
							rs.getString(3), // PRENOM
							rs.getString(4), // EMAIL
							rs.getString(5), // TELEPHONE
							rs.getString(6), // RUE
							rs.getString(7), // CODE POSTAL
							rs.getString(8), // VILLE
							rs.getString(9), // MOT DE PASSE
							rs.getString(11).equals("0") ? false : true); // ADMINISTRATEUR ===> PAS CERTAIN DE CE QUE JE VIENS DE FAIRE
				return u;
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public void delete(int idUtilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);){
			stmt.setInt(1, idUtilisateur);
			stmt.execute();
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectByPseudo);){
			stmt.setString(1, pseudo);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				Utilisateur u = new Utilisateur(rs.getInt(1),  // No Identifiant
							rs.getInt(2),	// CREDIT
							pseudo, 		// PSEUDO
							rs.getString(3), // NOM
							rs.getString(4), // PRENOM
							rs.getString(5), // EMAIL
							rs.getString(6), // TELEPHONE
							rs.getString(7), // RUE
							rs.getString(8), // CODE POSTAL
							rs.getString(9), // VILLE
							rs.getString(10), // MOT DE PASSE
							rs.getString(11).equals("0") ? false : true); // ADMINISTRATEUR ===> PAS CERTAIN DE CE QUE JE VIENS DE FAIRE
				return u;
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public Utilisateur selectByMail(String email) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlSelectByMail);){
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				Utilisateur u = new Utilisateur(rs.getInt(1),  // No Identifiant
							rs.getInt(2),	// CREDIT
							rs.getString(3), // PSEUDO
							rs.getString(4), // NOM
							rs.getString(5), // PRENOM
							email, 			// EMAIL
							rs.getString(6), // TELEPHONE
							rs.getString(7), // RUE
							rs.getString(8), // CODE POSTAL
							rs.getString(9), // VILLE
							rs.getString(10), // MOT DE PASSE
							rs.getString(11).equals("0") ? false : true); // ADMINISTRATEUR ===> PAS CERTAIN DE CE QUE JE VIENS DE FAIRE
				return u;
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}

	
// RENVOIE TRUE SI LE PSEUDO EXISTE DEJA	
	@Override
	public boolean pseudoExist(String pseudo) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlPseudoExiste);){
			stmt.setString(1, pseudo);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				if(rs.getInt(1) > 0)
					return true;
				else
					return false;
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}

// RENVOIE TRUE SI LE MAIL EXISTE DEJA		
	@Override
	public boolean mailExist(String email) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlMailExiste);){
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery();){
				rs.next();
				if(rs.getInt(1) > 0)
					return true;
				else
					return false;
			}
		}catch(SQLException e) {
			throw new DALException();
		}
	}
}




















