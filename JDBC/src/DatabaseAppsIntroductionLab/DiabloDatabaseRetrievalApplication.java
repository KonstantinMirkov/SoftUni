package DatabaseAppsIntroductionLab;

import DatabaseAppsIntroductionExercises.MyConnectionInfo;

import java.sql.*;
import java.util.*;

public class DiabloDatabaseRetrievalApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");

        String username = scanner.nextLine().trim();
        username = username.length() > 0 ? username : "";

        try (Connection connection = DriverManager.getConnection(MyConnectionInfo.LOCALHOST + "diablo", MyConnectionInfo.NAME, MyConnectionInfo.PASSWORD);
             PreparedStatement stmt = connection.prepareStatement("SELECT user_name, first_name, last_name, COUNT(ug.game_id) count " +
                     "FROM users u JOIN users_games AS ug ON u.id = ug.user_id " +
                     "WHERE user_name = ?")) {
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                if (username.equals("")) {
                    System.out.println("No such user exists");
                } else {
                    System.out.printf("| %s | %s | %s | %d |%n",
                            resultSet.getString("user_name"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("count"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
