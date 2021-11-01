package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class RemoveVillainEx6 {
    protected static PreparedStatement statement;
    public static void main(String[] args) throws SQLException {
        removeVillain();
    }

    protected static void removeVillain() throws SQLException {
        System.out.println("Enter the villain's id, which you want to remove:");
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");
        int villainId = Integer.parseInt(scanner.nextLine());
        String villainName = QueryMethods.getEntityById(villainId, connection, "villains");

        String query = "DELETE FROM minions_villains WHERE villain_id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        int affectedMinions = statement.executeUpdate();

        String query2 = "DELETE FROM villains WHERE id = ?";
        statement = connection.prepareStatement(query2);
        statement.setInt(1, villainId);

        printDeletedVillainName(villainName, affectedMinions);
    }

    private static void printDeletedVillainName(String villainName, int affectedMinions) {
        if (villainName == null) {
            System.out.println("No such villain was found.%n");
        } else {
            System.out.printf("%s was deleted.%n", villainName);
            System.out.printf("%d minions released%n", affectedMinions);
        }
        System.out.println();
    }
}
