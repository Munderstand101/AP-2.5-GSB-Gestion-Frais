package model.DAO;

import java.sql.ResultSet;

public class VisiteurDAO {
	
	public static ResultSet unVisiteur(String id)
     {
		 	 
	     String requete = "SELECT *  FROM visiteur where  id = '" + id + "'";
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
 			
     }
}
