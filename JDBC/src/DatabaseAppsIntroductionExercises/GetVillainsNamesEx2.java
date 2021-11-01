package DatabaseAppsIntroductionExercises;

import java.sql.*;

public class GetVillainsNamesEx2 {
    public static void main(String[] args) throws SQLException {
        getVillainsNames();
    }

    protected static void getVillainsNames() throws SQLException {
        Connection connection = QueryMethods.getConnection("minions_db");

        ResultSet resultSet = selectVillainNames(connection);

        printNames(resultSet);
    }

    private static ResultSet selectVillainNames(Connection connection) throws SQLException {
        String query = """
                SELECT v.name, COUNT(mv.minion_id) AS 'count' FROM villains AS v
                JOIN minions_villains AS mv ON v.id = mv.villain_id
                GROUP BY v.id HAVING `count` > 15 ORDER BY `count` DESC
                """;

        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    private static void printNames(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
    }
}
