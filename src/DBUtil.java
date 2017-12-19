import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {
   // Static variable for database driver
   private static final String DRIVER = "com.mysql.jdbc.Driver";

   // Connection
   private static Connection connection = null;

   // Connect to database
   private static void dbConnect() throws SQLException, ClassNotFoundException {
      // Setup Driver
      try {
         Class.forName(DRIVER);
         System.out.println("Driver setup...");
      } catch (ClassNotFoundException e) {
         System.out.println("Incorrect Driver String");
         e.printStackTrace();
         throw e;
      }

      // Establish Connection
      try {
         connection = DriverManager.getConnection("jdbc:mysql://localhost/liftrdb",
            "scott", "tiger");
         System.out.println("Connected to database...");
      } catch (SQLException e) {
         System.out.println("Connection String failed!");
         e.printStackTrace();
         throw e;
      }

   }

   private static void dbDisconnect() throws SQLException {
      try {
         if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connection closed...");
         }
      } catch (SQLException e) {
         System.out.println("Something wrong with disconnecting.");
         throw e;
      }
   }

   // Execute Query
   public static ResultSet dbExecuteQuery(String query) throws SQLException, ClassNotFoundException {
      Statement statement = null;
      ResultSet resultSet = null;
      CachedRowSetImpl cachedRowSet;

      try {
         // Connect to db
         dbConnect();

         // Create statement
         statement = connection.createStatement();

         // Execute select (query) operation
         resultSet = statement.executeQuery(query);

         // CachedRowSet Implementation
         cachedRowSet = new CachedRowSetImpl(); // why the Impl?
         cachedRowSet.populate(resultSet);
      } catch (SQLException e) {
         e.printStackTrace();
         throw e;
      } finally {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         dbDisconnect();
      }
      return cachedRowSet;
   }

   // Database Execute Update for Update/Insert/Delete
   public static void dbExecuteUpdate(String sqlStatement) throws SQLException, ClassNotFoundException {
      Statement statement = null;
      try {
         // Connect to db
         dbConnect();

         // Create a statement
         statement = connection.createStatement();

         // Run update with specified SQL statement
         statement.executeUpdate(sqlStatement);
      } catch (SQLException e) {
         System.out.println("Problem at executeUpdate!");
         e.printStackTrace();
         throw e;
      } finally {
         if (statement != null) {
            statement.close();
         }
         // Disconnect from DB
         dbDisconnect();
      }
   }
}