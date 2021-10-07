package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.DBConnex;
import model.DAO.FicheFraisDAO;
import model.DTO.FicheFrais;
import model.DTO.LesFichesFrais;

public class controllerIdentification implements Initializable {
	

	
	@FXML
	private Label messageConnexionLabel;
	
	@FXML
	private TextField serveurTextField;
	
	@FXML
	private TextField portTextField;
	
	
	@FXML
	private TextField loginTextField;
	
	@FXML
	private PasswordField mdpPasswordField;
	
	

	@FXML
	protected void buttonValiderIdentificationClick(ActionEvent e) {
			
	
		ResultSet rs = DBConnex.authentification(loginTextField.getText() , mdpPasswordField.getText(), DBConnex.connexion() );
		
		try {
	
			if(rs != null) {
				
				
			 FXMLLoader loader = new FXMLLoader();
			 messageConnexionLabel.setText("");
			 
			 
			 if(rs.getNString("login").equals("compta")) {
			 		loader.setLocation(Main.class.getResource("../view/viewComptableListeFiches.fxml"));
			 		Pane comptableListeFichesLayout = (Pane) loader.load();
	            
			 		Stage comptableListeFichesStage = new Stage();
			 		Scene comptableListeFichesScene = new Scene(comptableListeFichesLayout);
			 		comptableListeFichesStage.setScene(comptableListeFichesScene);
	           		
			 		comptableListeFichesStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");
	            
			 		comptableListeFichesStage.initModality(Modality.APPLICATION_MODAL);
				
			 		
			 		comptableListeFichesStage.show();
			 	}
	        
	        	
	        	
	       	
	         
			}
			else {
				messageConnexionLabel.setText("Login ou mot de passe incorrect !");
			}
	        
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		DBConnex.connexion();
		
	}

	@FXML
	protected void quitterIdentificationButton(ActionEvent e) {
		Platform.exit();
		
	}

	
	@Override
	public void initialize(URL location , ResourceBundle ressources) {
		serveurTextField.setText("127.0.0.1");
		portTextField.setText("3306");
	}
	
	

}
