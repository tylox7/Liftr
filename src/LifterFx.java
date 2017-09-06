import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

      // Create GridPane with gaps and padding
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));

      // Header text for form
      Text sceneTitle = new Text("Welcome to Liftr.");
      sceneTitle.setId("sceneTitle");
      grid.add(sceneTitle, 0, 0, 2, 1);

      // Label for name field
      Label liftNameLabel = new Label("Name: ");
      grid.add(liftNameLabel, 0, 1);

      // Textfield input
      TextField nameTextField = new TextField();
      grid.add(nameTextField, 1, 1);

      // Label for favorite lift
      Label favoriteLift = new Label("Favorite Lift:");
      grid.add(favoriteLift, 0, 2);

      // Password field for favorite lift just cuz I want to see the dots
      PasswordField secretLift = new PasswordField();
      grid.add(secretLift, 1, 2);

      // Text button is added in a HBox so it can be out of normal flow of the
      // GridPane
      Button btn = new Button("Submit");
      HBox hbBtn = new HBox(10);
      hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
      hbBtn.getChildren().add(btn);
      grid.add(hbBtn, 1, 4);

      // Text control to display message after button is clicked
      final Text actionTarget = new Text();
      actionTarget.setId("actionTarget");
      grid.add(actionTarget, 1, 6);

      // Handle button click event
      btn.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            actionTarget.setText("Time to " + secretLift.getText()
               + " " + nameTextField.getText());
         }
      });

      // Set scene size and show it on the screen
      Scene scene = new Scene(grid, 500, 275);
      primaryStage.setScene(scene);
      scene.getStylesheets().add(LifterFx.class.getResource("liftrStyles.css").toExternalForm());
      primaryStage.show();
   }
}
