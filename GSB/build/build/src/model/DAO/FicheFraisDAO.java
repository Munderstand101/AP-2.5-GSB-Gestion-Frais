package model.DAO;


import java.sql.ResultSet;
import java.util.ArrayList;

import model.DTO.FicheFrais;
public class FicheFraisDAO {
	
	
	 public static ResultSet chargerFichesFrais()
     {
		 
        // String requete = "SELECT idFiche, nom,  idUtilisateur,  mois, annee, dateCreation, dateCloture , idEtat , montantDeclare  FROM fichefrais join utilisateur on fichefrais.idUtilisateur = utilisateur.id";

		 
	     String requete = "SELECT *  FROM fichefrais order by annee desc , mois desc";
                 
         return DBConnex.getRS(requete, DBConnex.connexion());
 		
 		
 		
 		
 		
     }
}
