package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class AddMinionEx4 {
    public static void main(String[] args) throws SQLException {
        getVillainAndMinionsInfo();
    }

    protected static void getVillainAndMinionsInfo() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");

        System.out.println("Enter minions info - name, age, town name:");
        String[] minionsInfo = scanner.nextLine().split("\\s+");
        String minionName = minionsInfo[0];
        int minionAge = Integer.parseInt(minionsInfo[1]);
        String townName = minionsInfo[2];
        int townId = QueryMethods.getEntityIdByName(townName, connection, "towns");

        System.out.println("Enter villain name:");
        String villainName = scanner.nextLine();
        int villainId = QueryMethods.getEntityIdByName(villainName, connection, "villains");

        printAddedInfo(connection, minionName, minionAge, townName, townId, villainName, villainId);
    }

    private static void printAddedInfo(Connection connection, String minionName, int minionAge,
                                       String townName, int townId, String villainName, int villainId) throws SQLException {
        if (villainId < 0) {
            QueryMethods.insertData(villainName, connection, "villains");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        if (townId < 0) {
            QueryMethods.insertData(townName, connection, "towns");
            System.out.printf("Town %s was added to the database.%n", townName);
        } else {
            addMinion(minionName, minionAge, townId, connection);
            System.out.printf("Successfully added %s to be minion of %s%n", minionName, villainName);
        }
    }

    private static void addMinion(String minionName, int minionAge, int townId, Connection connection) throws SQLException {
        String query = """
                INSERT INTO minions(name, age, town_id) values(? , ? , ?)
                """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        statement.setInt(2, minionAge);
        statement.setInt(3, townId);
        statement.execute();
    }
}
