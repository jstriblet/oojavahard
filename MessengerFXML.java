import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Stage;

public class MessengerFXML extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("messenger.fxml"));
		Scene scene = new Scene(root, 300, 200);

		stage.setTitle("Messenger FML");
		stage.setScene(scene);
		stage.show();
	}

	public static void main( String[] args ) {
		launch(args);
	}
}
