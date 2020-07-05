package exec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/fx/splashscreen.fxml"));
		primaryStage.setTitle("Bibliothèque manga <3");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.centerOnScreen();
		
		Stage otherStage = new Stage();
		Parent root1 = FXMLLoader.load(getClass().getResource("/fx/connectionace.fxml"));
		otherStage.setTitle("Bibliothèque manga <3");
		Scene scene1  = new Scene(root1);
		otherStage.setScene(scene1);		
		otherStage.setResizable(false);
		
		//3 seconde pause avant cacher splashscreen
		Thread.sleep(3000);
		primaryStage.hide();
		otherStage.show();
		otherStage.centerOnScreen();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
