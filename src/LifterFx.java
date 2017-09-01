import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LifterFx extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) {
      // Set window pane title
      primaryStage.setTitle("Liftr");

      // Create GridPane with gaps and padding
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));

      Text sceneTitle = new Text("Welcome to Liftr.");
      sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
      grid.add(sceneTitle, 0, 0, 2, 1);

      Label liftNameLabel = new Label("Lift Name: ");
      grid.add(liftNameLabel, 0, 1);

      Scene scene = new Scene(grid, 300, 275);
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
