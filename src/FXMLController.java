import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {
   @FXML private Text actionTarget;
   @FXML private TextField nameTextField;
   @FXML private PasswordField secretLift;

   @FXML protected void handleSubmitButtonAction(ActionEvent event) {
      actionTarget.setText("Time to " + secretLift.getText() + " " +
                           nameTextField.getText());
   }
}
