package DatabaseAppsIntroductionLab;

import DatabaseAppsIntroductionExercises.MyConnectionInfo;

import java.sql.*;
import java.util.Scanner;

public class AccessingDatabaseViaSimpleJavaApplication_Demo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT first_name, last_name FROM employees WHERE salary > ?");
        String salary = scanner.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        }

    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(MyConnectionInfo.LOCALHOST + "soft_uni", MyConnectionInfo.NAME, MyConnectionInfo.PASSWORD);
    }
}
