package DatabaseAppsIntroductionExercises;

import java.sql.*;

public class QueryMethods {
    public static int getEntityIdByName(String entityName, Connection connection, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

   public static String getEntityById(int entityId, Connection connection, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

   public static Connection getConnection(String database) throws SQLException {
        return DriverManager.getConnection(MyConnectionInfo.LOCALHOST + String.format("%s", database), MyConnectionInfo.NAME, MyConnectionInfo.PASSWORD);
    }

    public static void insertData(String name, Connection connection, String tableName) throws SQLException {
        String query = String.format("INSERT INTO %s(name) value(?)", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.execute();
    }
}
