package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import fr.eni.projet.BO.Utilisateur;

/**
 * @author Loareos // Etienne 
 *
 */



public class UserDAOJdbcImpl implements DAO<Utilisateur> {

	String sqlInsert = "INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code-postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,b?)";
	String sqlUpdate = "UPDATE UTILISATEUR SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code-postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ?";
	String sqlSelectById = "SELECT pseudo, nom, prenom, email, telephone, rue, code-postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEUR WHERE no_utilisateur = ?";
	String sqlDelete = "DELETE FROM UTILISATEUR WHERE no_utilisateur = ?";
	
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
			stmt.setString(i++, utilisateur.getMotDePasse);
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
			return new DALException();
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
			stmt.setString(i++, utilisateur.getMotDePasse);
			stmt.setInt(i++, utilisateur.getCredit());
			if(utilisateur.getAdministrateur())
				stmt.setString(i++, "1");
			else
				stmt.setString(i++, "0");
			stmt.setInt(i++, utilisateur.getNoUtilisateur());
			stmt.execute();
		}catch(SQLException e) {
			return new DALException();
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
							rs.getString(1), // PSEUDO
							rs.getString(2), // NOM
							rs.getString(3), // PRENOM
							rs.getString(4), // EMAIL
							rs.getString(5), // TELEPHONE
							rs.getString(6), // RUE
							rs.getString(7), // CODE POSTAL
							rs.getString(8), // VILLE
							rs.getString(9), // MOT DE PASSE
							rs.getInt(10),	// CREDIT
							rs.getString(11).equals(b"0") ? false : true); // ADMINISTRATEUR ===> PAS CERTAIN DE CE QUE JE VIENS DE FAIRE
				return u;
			}
		}catch(SQLException e) {
			return new DALException();
		}
	}

	@Override
	public void delete(int idUtilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sqlDelete);){
			stmt.setInt(1, idUtilisateur);
			stmt.execute();
		}catch(SQLException e) {
			return new DALException();
		}
	}
}




















