package model.DTO;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Locale;


public class Visiteur {

    private String id;
    private String nom ;
    private String prenom;
    private String login;
    private String mdp;
    private String adresse;
    private String cp;
    private String ville;
    private Date dateEmbauche;
    private ArrayList<FicheFrais> mesFiches;
    

    public Visiteur(String unId, String unNom , String unPrenom  , String unLogin , String unMdp , String uneAdresse , String unCp , String uneVille , Date uneDateEmb)
    {
        id = unId;
        nom = unNom;
        prenom = unPrenom;
        login = unLogin;
        mdp = unMdp;
        adresse = uneAdresse;
        cp = unCp;
        ville = uneVille;
        dateEmbauche = uneDateEmb;
        mesFiches = new ArrayList<FicheFrais>();
    }


    public String getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public String getCodePostal()
    {
        return cp;
    }

    public String getVille()
    {
        return ville;
    }

    public Date getDateEmbauche()
    {
        return dateEmbauche;
    }

    public String getNomComplet()
    {
        return  nom + " " + prenom;
    }

    public String getCPVille()
    {
        return cp + " " +  ville;
    }

    public ArrayList<FicheFrais> getFichesDeFrais()
    {
        return mesFiches;
    }
   

}
	

