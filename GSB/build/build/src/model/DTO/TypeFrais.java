package model.DTO;

public class TypeFrais {

	  private String id;
      private String libelle;
      private float montant;
   


      
      public TypeFrais(String unId, String unLibelle, float unMontant)
      {
          id = unId;
          libelle = unLibelle;
          montant = unMontant;
      }



      public String getId()
      {
          return id;
      }

      public String getLibelle()
      {
          return libelle;
      }

      public float getMontant()
      {
          return montant;
      }

  
}
