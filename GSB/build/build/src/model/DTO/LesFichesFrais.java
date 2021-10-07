package model.DTO;

import java.util.ArrayList;

public class LesFichesFrais {

	
	 private static ArrayList<FicheFrais> lesFichesFrais;

     public static void remplirLesFichesFrais(ArrayList<FicheFrais> uneListeFchesFrais)
     {
         lesFichesFrais = uneListeFchesFrais;
     }

     public static ArrayList<FicheFrais>  obtenirLesFichesFrais()
     {
         return lesFichesFrais;
     }

     public static FicheFrais chercherFicheFrais(int idFicheFrais)
     {
         for (FicheFrais uneFicheFrais : lesFichesFrais)
         {
             if (uneFicheFrais.getIdFiche() == idFicheFrais)
             {
                 return uneFicheFrais;
             }
         }
         return null;
     }



     public static int nbFichesFrais()
     {
         return lesFichesFrais.size();
     }
}
