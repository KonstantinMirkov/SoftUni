package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class ChangeTownNamesCasingEx5 {
    public static void main(String[] args) throws SQLException {
        changeTownNamesCasing();
    }

    protected static void changeTownNamesCasing() throws SQLException {
        System.out.println("Enter country name: ");
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");

        String countryName = scanner.nextLine();

        int townsAffected = getAffectedTowns(connection, countryName);
        printAffectedTowns(townsAffected);
    }

    private static int getAffectedTowns(Connection connection, String countryName) throws SQLException {
        String query = """
                UPDATE towns SET name = UPPER(name) WHERE country = ?
                """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, countryName);
        return statement.executeUpdate();
    }

    private static void printAffectedTowns(int townsAffected) {
        switch (townsAffected) {
            case 0 -> System.out.println("No town names were affected.");
            case 1 -> System.out.printf("%d town name was affected.%n", townsAffected);
            default -> System.out.printf("%d town names were affected.%n", townsAffected);
        }
    }
}
