package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class GetMinionNamesEx3 {
    public static void main(String[] args) throws SQLException {
        getVillainAndMinionsNames();
    }

    protected static void getVillainAndMinionsNames() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");

        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scanner.nextLine());

        String villainName = QueryMethods.getEntityById(villainId, connection, "villains");

        printVillainName(villainId, villainName);

        getAndPrintMinions(connection, villainId, villainName);
    }

    private static void printVillainName(int villainId, String villainName) {
        if (villainName == null) {
            System.out.printf("No villain with id %d exists in the database.%n", villainId);
        } else {
            System.out.println("Villain: " + villainName);
        }
        System.out.println();
    }

    private static void getAndPrintMinions(Connection connection, int villainId, String villainName) throws SQLException {
        String query = """
                SELECT m.name, m.age FROM minions AS m
                JOIN minions_villains AS mv ON m.id = mv.minion_id
                WHERE mv.villain_id = ?
                 """;

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();

        if (villainName == null) {
            System.out.print("");
        } else {
            System.out.println("His minions are:");
            int counter = 1;
            while (resultSet.next()) {
                System.out.printf("%d. %s %d%n",
                        counter++,
                        resultSet.getString("m.name"),
                        resultSet.getInt("m.age"));
            }
        }
    }
}
