package DatabaseAppsIntroductionExercises;

import java.sql.*;
import java.util.*;


public class IncreaseMinionsAgeEx8 {
    protected static PreparedStatement statement;

    public static void main(String[] args) throws SQLException {
        increaseMinionsAge();
    }

    protected static void increaseMinionsAge() throws SQLException {
         System.out.println("Enter minions Ids to increase their years by 1 here: ");
        Scanner scanner = new Scanner(System.in);
        Connection connection = QueryMethods.getConnection("minions_db");
        String[] ids = scanner.nextLine().split("\\s+");

        String query = String.format(
                "update minions " +
                "set name = lower(name), " +
                "age = age + 1 " +
                "where id in (%s)", String.join(", ", ids));

        statement = connection.prepareStatement(query);
        statement.execute();

        String query2 = "select name, age from minions";
        statement = connection.prepareStatement(query2);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %s%n", resultSet.getString(1), resultSet.getInt(2));
        }
    }
}
