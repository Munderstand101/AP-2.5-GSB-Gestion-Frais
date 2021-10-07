package controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	 private Pane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		
		 
		
				try {
							
					
					 FXMLLoader loader = new FXMLLoader();
			            loader.setLocation(Main.class.getResource("../view/viewConnexion.fxml"));
			            rootLayout = (Pane) loader.load();
			            
			            // Show the scene containing the root layout.
			            Scene scene = new Scene(rootLayout);
			            primaryStage.setScene(scene);
			            primaryStage.show();
			            primaryStage.setTitle("GSB Gestion des frais - Compta Fiche de frais");
					
				} catch(Exception e) {
					e.printStackTrace();
				}

		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
