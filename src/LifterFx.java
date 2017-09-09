import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LifterFx extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      // Set window pane title
      primaryStage.setTitle("Liftr");

      Parent root = FXMLLoader.load(getClass().
         getResource("fxml_initial.fxml"));

      // Set scene size and show it on the screen
      Scene scene = new Scene(root, 500, 275);
      primaryStage.setScene(scene);
      scene.getStylesheets().add(LifterFx.class.
         getResource("liftrStyles.css").toExternalForm());
      primaryStage.show();
   }
}
