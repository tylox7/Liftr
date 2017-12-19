import com.sun.rowset.CachedRowSetImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FXMLController {
   @FXML private Text actionTarget;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField searchTarget;
   @FXML private Text searchResult;

   @FXML protected void handleSubmitButtonAction(ActionEvent event) throws SQLException,
      ClassNotFoundException {

      String sqlStatement = "insert into athlete (firstName, lastName) values ('" +
         firstNameTextField.getText() + "', '" + lastNameTextField.getText() + "')";
       try {
         DBUtil.dbExecuteUpdate(sqlStatement);
      } catch(SQLException e) {
          e.printStackTrace();
         throw e;
      }


      actionTarget.setText("Added " + firstNameTextField.getText() + " " +
                           lastNameTextField.getText());
   }

   @FXML protected void handleSearchButtonAction(ActionEvent event) throws SQLException,
      ClassNotFoundException {
      try {
         ResultSet query = DBUtil.dbExecuteQuery("select * from athlete where athlete.lastName='" +
            searchTarget.getText() + "'");
         if (!query.isBeforeFirst()) searchResult.setText("Not Found");
         while (query.next()) {
            String firstName = query.getString("firstName");
            String lastName = query.getString("lastName");
            searchResult.setText(firstName + " " + lastName);
         }
      } catch(SQLException e) {
         e.printStackTrace();
         System.out.println("Something wrong with search.");
         throw e;
      }
   }
}
