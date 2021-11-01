package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class PrintAllMinionNamesEx7 {
    public static void main(String[] args) throws SQLException {
        printAllMinionNames();
    }

    protected static void printAllMinionNames() throws SQLException {
        System.out.println("All minions names are: ");
        System.out.println();

        List<String> minionsNames = new ArrayList<>();
        Connection connection = QueryMethods.getConnection("minions_db");

        String query = "SELECT count(id) FROM minions";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        int minionsCount;
        int minionsId = 1;
        while (resultSet.next()) {
            minionsCount = resultSet.getInt(1);
            while (minionsId <= minionsCount / 2) {
                minionsNames.add(QueryMethods.getEntityById(minionsId, connection, "minions"));
                minionsNames.add(QueryMethods.getEntityById(minionsCount - minionsId + 1, connection, "minions"));
                minionsId++;
            }
            System.out.println(String.join("\n", minionsNames));
        }
    }


}
