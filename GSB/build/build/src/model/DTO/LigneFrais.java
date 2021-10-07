package model.DTO;

public class LigneFrais {

	private int idFiche;
    private String idTypeFrais;
    private int quantiteDeclaree;
    private TypeFrais typeFrais;

    public LigneFrais(int unIdFiche, String unIdTypeFrais, int uneQuantiteDeclaree , TypeFrais unTypeFrais)
    {
    	idFiche = unIdFiche;
        idTypeFrais = unIdTypeFrais;
        quantiteDeclaree = uneQuantiteDeclaree;
        typeFrais = unTypeFrais;
    }



       public int getIdFiche()
       {
           return idFiche;
       }

       public String getIdTypeFrais()
       {
           return idTypeFrais;
       }

       public int getQuantiteDeclaree()
       {
           return quantiteDeclaree;
       }

       public TypeFrais getTypeFrais()
       {
           return typeFrais;
       }	
}
