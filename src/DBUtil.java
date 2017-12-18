import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {
   // Static variable for database driver
   private static final String DRIVER = "com.mysql.jdbc.Driver";

   // Connection
   private static Connection connection = null;

   // Database location and login
   private static final String connectionString = "jdbc:mysql://scott/tiger@localhost/liftrdb";

   // Connect to database
   public static void dbConnect() throws SQLException, ClassNotFoundException {
      // Setup Driver
      try {
         Class.forName(DRIVER);
      } catch (ClassNotFoundException e) {
         System.out.println("Incorrect Driver String");
         e.printStackTrace();
         throw e;
      }

      // Establish Connection
      try {
         connection = DriverManager.getConnection(connectionString);
      } catch (SQLException e) {
         System.out.println("Connection String failed!");
         e.printStackTrace();
         throw e;
      }

   }

   public static void dbDisconnect() throws SQLException {
      try {
         if (connection != null && !connection.isClosed()) {
            connection.close();
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
      CachedRowSetImpl cachedRowSet = null;

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