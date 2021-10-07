package model.DTO;


import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FicheFrais {

	private int idFiche;
	private int mois;
	private int annee;
	private Date dateCreation;
	private Date dateCloture;
	private String etat;
	private float montantDeclare;
	private Visiteur utilisateur;
	private ArrayList<LigneFrais> lesLignes;

	        
	        public FicheFrais(int unIdFiche , int unMois, int uneAnnee,  Date uneDateCreation, Date uneDateCloture, String unEtat, float unMontantDeclare  ,Visiteur unUtilisateur) {
	            idFiche = unIdFiche;
	            mois = unMois;
	            annee = uneAnnee;
	            dateCreation = uneDateCreation;
	            dateCloture = uneDateCloture;
	            etat = unEtat;
	            montantDeclare = unMontantDeclare;
	            utilisateur = unUtilisateur;
	            lesLignes = new ArrayList<LigneFrais>();
	         }
	        
	     /*   public FicheFrais(int unIdFiche , int unMois, int uneAnnee,   String unEtat, float unMontantDeclare , Visiteur unUtilisateur) {
	            idFiche = unIdFiche;
	            mois = unMois;
	            annee = uneAnnee;
	            etat = unEtat;
	            montantDeclare = unMontantDeclare;
	            utilisateur = unUtilisateur;
	         }
	        */
	       

	        public int getIdFiche()
	        {
	            return idFiche;
	        }

	        public int getMois()
	        {
	            return mois;
	        }
	        public int getAnnee()
	        {
	            return annee;
	        }

	        public Date getDateCreation()
	        {
	            return dateCreation;
	        }
	        public Date getDateCloture()
	        {
	            return dateCloture;
	        }

	        public String getEtat()
	        {
	            return etat;
	        }

	        public float getMontantDeclare()
	        {
	            return montantDeclare;
	        }

	  
	        public Visiteur getUtilisateur()
	        {
	            return utilisateur;
	        }


	        public String getEtatLong()
	        {
	           switch (etat){
	                case "EC":
	                    return "EC-En cours de saisie";
	                case "CL":
	                    return "CL-Clôturée";
	                case "VA":
	                    return "VA-Validée";
	                case "MP":
	                    return "MP-Mise en paiement";
	                default:
	                    return "RB Remboursée";
	            }
	                
	        }

	        public String getMoisAnnee()
	        {
	        	
	        	String s_mois = new DateFormatSymbols().getMonths()[mois - 1];
	        	return String.valueOf(annee) + '-'+ String.format("%02d",mois) + '[' +s_mois +']';
	        	
	        }
	        	
	        public String getMoisLettre()
	 	    {
	 	        	
	 	       return new DateFormatSymbols().getMonths()[mois - 1];
	 	          
	        }
	        
	        
	        
	        
	        public String getNomPrenomUtilisateur() {
	        	return utilisateur.getNomComplet();
	        }

	   
	     /*  public float getTotalDeclare()
	        {
	            
	            float total = 0;
	            foreach (LigneFrais uneLigneFrais in lesLignes)
	            {
	                total += unLigneFrais.getQuantiteDeclaree() * unLigneFrais.getTypeFrais().getMontant();
	            }
	            return total;
	        }
*/
	        
	        public void setLignesFrais(ArrayList<LigneFrais> uneListeLignesFrais)
	        {
	            lesLignes = uneListeLignesFrais;
	        }

	        public void changerEtatFiche(String nouvelEtat)
	        {
	            etat = nouvelEtat;
	        }
	    }


