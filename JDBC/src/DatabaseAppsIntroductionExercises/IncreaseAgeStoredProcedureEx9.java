package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;

public class IncreaseAgeStoredProcedureEx9 {
    public static void main(String[] args) throws SQLException {
        increaseAgeStoredProcedure();
    }

    protected static void increaseAgeStoredProcedure() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");

        System.out.println("Enter minion id here:");
        int minionId = Integer.parseInt(scanner.nextLine());

        increaseAge(connection, minionId);
        printMinionWithIncreasedAge(connection, minionId);
    }

    private static void increaseAge(Connection connection, int minionId) throws SQLException {
        String query = "CALL usp_get_older(?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }

    private static void printMinionWithIncreasedAge(Connection connection, int minionId) throws SQLException {
        String minionName = QueryMethods.getEntityById(minionId, connection, "minions");
        System.out.printf("%s's years has been increased by 1%n", minionName);
    }
}
