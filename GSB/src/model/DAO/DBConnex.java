package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnex {
	/**
	 * M�thode de connexion � la base de donn�es
	 * @return  Statement
	 */
	public static Statement connexion() {
		
		Statement statement = null;
		 try {
				Connection	connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gsb?user=root&password=");
			
				statement = connection.createStatement();
				
				
				return statement;
				
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				System.out.println(e.getMessage()); 
				return statement;
			}
	}
	
	/**
	 * M�thode d'authentification des l'utilisteur
	 * @param login
	 * @param mdp
	 * @param unStatement
	 * @return ResultSet
	 */
	public static ResultSet  authentification(String login , String mdp, Statement unStatement) {
		
		ResultSet rs = null ;
		try {
			String sql ="SELECT id , nom , prenom, login, statut  FROM utilisateur where login = '" + login + "' and mdp = '"+ mdp +"'";
			rs = unStatement.executeQuery(sql);
			if (!rs.next()) {
				rs =null;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
		}
		 return rs;
	}
	
	
	/**
	 * M�thode permettant l'envoi de requ�tes "select" � la base de donn�es
	 * @param requete
	 * @param unStatement
	 * @return ResultSet
	 */
	public static ResultSet  getRS(String requete ,Statement unStatement) {
		
		ResultSet rs = null ;
		 try {
				rs = unStatement.executeQuery(requete);		
				if (!rs.next()) {
					rs =null;
				}
								
		    } catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
				
			}
		 return rs;
	}
	
	/**
	  * M�thode permettant l'envoi de requ�tes "update, insert, delete" � la base de donn�es
	 * @param requete
	 * @param unStatement
	 * @return Integer
	 */
	public static Integer  noQuery(String requete ,Statement unStatement) {
		
		Integer reponse = -1 ;
		 try {
				reponse  = unStatement.executeUpdate(requete);		
				
								
		    } catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()); 
				
			}
		 return reponse;
	}
	

}
