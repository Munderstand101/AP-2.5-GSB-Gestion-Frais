package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.DBConnex;
import model.DAO.FicheFraisDAO;
import model.DAO.VisiteurDAO;
import model.DTO.FicheFrais;
import model.DTO.LesFichesFrais;
import model.DTO.Visiteur;

public class controllerComptableListeFiches {

	
	 @FXML 	private TableView<FicheFrais> tableListeFichesComptable;
	 @FXML 	private TableColumn<FicheFrais , Integer > colIdFiche;
	 @FXML 	private TableColumn<FicheFrais , String > colNomVisiteur;
	 @FXML 	private TableColumn<FicheFrais , Integer > colMoisFiche;
	 @FXML  private TableColumn<FicheFrais , String > colEtatFiche;
	 @FXML  private Button closeButtonListeFichesComptable;
	 
	 private ObservableList<FicheFrais> data = FXCollections.observableArrayList();
	 
	 
		@FXML
		private void buttonOuvrirFicheComptableClick(ActionEvent e) {
	
		
			
			
			
			
			int index = tableListeFichesComptable.getSelectionModel().getSelectedIndex();
			
			System.out.printf(String.valueOf(index));
			
			if(index >= 0) {
			
			
			FicheFrais uneFiche = tableListeFichesComptable.getSelectionModel().getSelectedItem();
			
			System.out.printf(uneFiche.getNomPrenomUtilisateur());
			
		
					
			
		
			
			try {
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("../view/viewComptableFiche.fxml"));
				
				
				Parent comptableFicheLayout = (Parent) loader.load();
				
				controllerComptableFiche setController= loader.getController();
		 		setController.transfertFunction(uneFiche);
				 
				Stage comptableFicheStage = new Stage();	
				
		 		comptableFicheStage.setScene(new Scene(comptableFicheLayout));	 
		 		comptableFicheStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");	
		 		comptableFicheStage.initModality(Modality.APPLICATION_MODAL); 		
		 		comptableFicheStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText("Sélectionnez une fiche de frais");
				alert.getDialogPane().setContentText("Vous devez sélectionner une fiche de frais afin de la visualiser");
				alert.showAndWait();
			}
		
				 		
		}
	 
	 
			
	 
	 private void viewListeFichesComptable() {
		 try {
			 
			
			 
			 
			 ResultSet rsListeFichesComptable = FicheFraisDAO.chargerFichesFrais();
			 
			
			 rsListeFichesComptable.beforeFirst();
			 while (rsListeFichesComptable.next()) {
				 
				 ResultSet rsUnVisiteur = VisiteurDAO.unVisiteur(rsListeFichesComptable.getString(2));
				 
				
				
				 
				 Visiteur visiteur = new Visiteur(rsUnVisiteur.getString(1), rsUnVisiteur.getString(2)  , rsUnVisiteur.getString(3)   , rsUnVisiteur.getString(4)  , rsUnVisiteur.getString(5) , rsUnVisiteur.getString(6) , rsUnVisiteur.getString(7) , rsUnVisiteur.getString(8)  , rsUnVisiteur.getDate(9)) ;
					
				 
				 data.add(new FicheFrais(rsListeFichesComptable.getInt(1) ,rsListeFichesComptable.getInt(3) ,rsListeFichesComptable.getInt(4)  ,rsListeFichesComptable.getDate(5)  ,rsListeFichesComptable.getDate(6)  ,rsListeFichesComptable.getString(7) , rsListeFichesComptable.getFloat(8), visiteur));			 
			 }
			 
			 
			 
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		colIdFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,Integer>("idFiche"));
		colMoisFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,Integer>("moisAnnee"));
		colNomVisiteur.setCellValueFactory(new PropertyValueFactory<FicheFrais,String>("nomPrenomUtilisateur"));
		colEtatFiche.setCellValueFactory(new PropertyValueFactory<FicheFrais,String>("etatLong"));
		
		tableListeFichesComptable.setItems(data);
	 
	 }
	 
	 


	public void buttonCloseListeFichesComptableClick(ActionEvent e) {
			
		Stage stage = (Stage) closeButtonListeFichesComptable.getScene().getWindow();
	    stage.close();
		 
	 }
	
	 public void initialize() {
		     	 
			viewListeFichesComptable(); 
	 }  

	

	
	

}
