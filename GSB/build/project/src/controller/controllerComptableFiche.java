package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.DTO.FicheFrais;

public class controllerComptableFiche {
	
	
	
	@FXML
	private Label nomPrenomLabel;
	@FXML
	private Label adresseVisiteurLabel;
	@FXML
	private Label cpVilleVisiteurLabel;
	@FXML
	private Label dateEmbaucheLabel;
	@FXML
	private Label dateClotureLabel;
	@FXML
	private Label etatLabel;
	@FXML
	private Label montantDeclareLabel;
	@FXML
	private Label numFicheLabel;
	@FXML
	private Button buttonCloseFichesComptable;
	
	
	
	
	public void transfertFunction(FicheFrais uneFiche) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");     	
		numFicheLabel.setText("Fiche de frais n° " +uneFiche.getIdFiche() + " - " + uneFiche.getMoisLettre() +  " " + uneFiche.getAnnee());
		nomPrenomLabel.setText(uneFiche.getNomPrenomUtilisateur());
		adresseVisiteurLabel.setText(uneFiche.getUtilisateur().getAdresse());
		cpVilleVisiteurLabel.setText(uneFiche.getUtilisateur().getCPVille());
		dateEmbaucheLabel.setText("date d'embauche : "+ dateFormat.format(uneFiche.getUtilisateur().getDateEmbauche()));
		if (uneFiche.getDateCloture()!=null) {
			dateClotureLabel.setText("date clôture : "+ dateFormat.format(uneFiche.getDateCloture()));
		}
		else {
			dateClotureLabel.setText("date clôture : ");
		}
		etatLabel.setText("Etat : "+ uneFiche.getEtatLong());
		montantDeclareLabel.setText("MontantDéclaré : "+ String.format("%.2f", uneFiche.getMontantDeclare())+ " €");
	}
	
	
	public void buttonCloseFichesComptableClick(ActionEvent e) {
		Stage stage = (Stage) buttonCloseFichesComptable.getScene().getWindow();
	    stage.close();
	}

}
	