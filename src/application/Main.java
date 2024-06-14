package Application;
	
import java.io.IOException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
public class Main extends Application {
            		Path currentRelativePath = Paths.get("");
                        String s = currentRelativePath.toAbsolutePath().toString();

	@Override
	public void start(Stage stage) throws IOException {
		//System.out.println("javafx.runtime.version: " + System.getProperty("javafx.runtime.version"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
                //FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene (2).fxml"));
                System.out.print(loader.getResources());
		Parent root = null;	
            try {
                root = loader.load();
                
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
//                Parent root=FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Controller controller = loader.getController();
		Scene scene = new Scene(root);		
		
		//stage.getIcons().add(new Image("icon.png"));
		//stage.setTitle("Bro web browser");
		stage.setScene(scene);
		stage.show();
	}	

	public static void main(String[] args) {

		launch(args);
	}
}

