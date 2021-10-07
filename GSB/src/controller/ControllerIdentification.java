package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DAO.DBConnex;


public class ControllerIdentification implements Initializable {
	

	/**
	 * Les variables du fichier FXML associé
	 */
	@FXML private Label messageConnexionLabel;
	@FXML private TextField serveurTextField;
	@FXML private TextField portTextField;
	@FXML private TextField loginTextField;
	@FXML private PasswordField mdpPasswordField;
	
	
	/**
	 * Méthode associée à l'évènement click sur le bouton valider
	 * @param e
	 */
	@FXML	protected void buttonValiderIdentificationClick(ActionEvent e) {
			
		//Appel de la métode statique authentification de la classe DBConnex
		//En paramètre le login et mdp saisis et la déclaration de connexion.
		//Le ResultSet récupére la réponse du serveur SGBD.
		ResultSet rs = DBConnex.authentification(loginTextField.getText() , mdpPasswordField.getText(), DBConnex.connexion() );
		
		
		//Traitement de la réponse du SGBD
		//Chargement des différentes vues en fonction du statut de la personne authentifiée.
		try {
	
			if(rs != null) {
				
				
			 FXMLLoader loader = new FXMLLoader();
			 messageConnexionLabel.setText("");
			 
			 
			 if(rs.getNString("statut").equals("comptable")) {
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
		
			
	}

	/**
	 * Fermeture de l'application associée au click sur le boton quitter
	 * @param e
	 */
	@FXML
	protected void quitterIdentificationButton(ActionEvent e) {
		Platform.exit();
		
	}

	/**
	 * Valeurs par défaut pour la connexion au SGBD
	 * A l'inicilisation du contrôleur 
	 ***/
	@Override
	public void initialize(URL location , ResourceBundle ressources) {
		serveurTextField.setText("127.0.0.1");
		portTextField.setText("3306");
	}
	
	

}
