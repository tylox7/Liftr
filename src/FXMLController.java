import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {
   @FXML private Text actionTarget;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField searchTarget;
   @FXML private Text searchResult;

   @FXML protected void handleSubmitButtonAction(ActionEvent event) {


      actionTarget.setText("Added " + firstNameTextField.getText() + " " +
                           lastNameTextField.getText());
   }

   @FXML protected void handleSearchButtonAction(ActionEvent event) {

   }
}
