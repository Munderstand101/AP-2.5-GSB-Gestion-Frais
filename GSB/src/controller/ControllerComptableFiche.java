package controller;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DAO.FicheFraisDAO;
import model.DTO.FicheFrais;
import model.DTO.LigneFrais;

public class ControllerComptableFiche implements Initializable  {
	
	
	/**
	 * Les variables du fichier FXML associe
	 */
	@FXML	private Label nomPrenomLabel;
	@FXML	private Label adresseVisiteurLabel;
	@FXML	private Label cpVilleVisiteurLabel;
	@FXML	private Label dateEmbaucheLabel;
	@FXML	private Label dateClotureLabel;
	@FXML	private Label etatLabel;
	@FXML	private Label montantDeclareLabel;
	@FXML	private Label montantValideLabel;
	@FXML	private Label quantiteValideLabel;
	@FXML	private TextField mtDeclarerTextField;
	@FXML	private TextField mtValideTextField;
	@FXML	private TextField qtValideextField;

	@FXML	private Label numFicheLabel;


	@FXML	private Button buttonCloseFicheComptable;
	
	@FXML	private Button buttonValiderFicheComptable;
	
	
	
	
	// construction de la TableView 
	 @FXML 	private TableView<LigneFrais> tableDetailFicheComptable;
	 // les colonnes de la tableView
	 @FXML 	private TableColumn<LigneFrais , String > colLibelleTypeFrais;
	 @FXML 	private TableColumn<LigneFrais , Float > colTarifTypeFrais;
	 @FXML 	private TableColumn<LigneFrais , Integer > colQuantiteDeclaree;
	 @FXML  private TableColumn<LigneFrais , Float >  colTotalDeclaree;

	 
	 
	 private FicheFrais ficheActive ;
	 
	 //Declaration de l'ObservableList necessaire au remplissage de la tableView
	 private ObservableList<LigneFrais> dataLignes  = FXCollections.observableArrayList();;
	
	
	
	
	
	/**
	 * Fonction de transfert permettant d'afficher dans la vue "viewComptableFiche" 
	 * les informations relatives e la fiche selectionnee dans la vue "viewComptableListeFiches"
	 * @param uneFiche
	 */
	public void transfertFunction(FicheFrais uneFiche) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");     	
		numFicheLabel.setText("Fiche de frais ne " +uneFiche.getIdFiche() + " - " + uneFiche.getMoisLettre() +  " " + uneFiche.getAnnee());
		nomPrenomLabel.setText(uneFiche.getNomPrenomUtilisateur());
		adresseVisiteurLabel.setText(uneFiche.getUtilisateur().getAdresse());
		cpVilleVisiteurLabel.setText(uneFiche.getUtilisateur().getCPVille());
		dateEmbaucheLabel.setText("Date d'embauche : "+ dateFormat.format(uneFiche.getUtilisateur().getDateEmbauche()));
		if (uneFiche.getDateCloture()!=null) {
			dateClotureLabel.setText("Date cleture : "+ dateFormat.format(uneFiche.getDateCloture()));
		}
		else {
			dateClotureLabel.setText("date cleture : ");
		}
		etatLabel.setText("Etat : "+ uneFiche.getEtatLong());
		montantDeclareLabel.setText("Montant declare : "+ String.format("%.2f", uneFiche.getMontantDeclare())+ " €");
		montantValideLabel.setText("Montant Valide : 0.00 €"); // a faire
		qtValideextField.setText("0.00 €"); // a faire

		if(uneFiche.nbLignes()>0) {
			
			
		
			for(LigneFrais uneLigne :uneFiche.getLesLignes() ) {
				dataLignes.add(uneLigne);
			}

			colLibelleTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,String>("libelle"));
			colTarifTypeFrais.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("tarif"));
			colQuantiteDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Integer>("quantiteDeclaree"));
			colTotalDeclaree.setCellValueFactory(new PropertyValueFactory<LigneFrais,Float>("montant"));
						
			tableDetailFicheComptable.setItems(dataLignes);
			
			
		}
		
		ficheActive = uneFiche;

	}
	
	/**
	 * Fermeture de la vue 
	 * Click sur le bouton "Quitter"
	 * @param e
	 */
	public void buttonCloseFicheComptableClick(ActionEvent e) {
		Stage stage = (Stage) buttonCloseFicheComptable.getScene().getWindow();
	    stage.close();
	}
	
	/**
	 * Validation de la fiche
	 * Click sur le bouton "Valider"
	 * @param e
	 */
	public void buttonValiderFicheComptableClick(ActionEvent e) {
		if( ficheActive.getEtat().compareTo("EC")==0) {
		
			Integer reponse = FicheFraisDAO.changerEtat(ficheActive.getIdFiche() , "VA");
			if(reponse == 1) {
				ficheActive.changerEtatFiche("VA");
				etatLabel.setText("Etat : "+ ficheActive.getEtatLong());
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Modification impossible");
				alert.getDialogPane().setContentText("Validation de la fiche non effectuee.");
				alert.showAndWait();
			}
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}
	