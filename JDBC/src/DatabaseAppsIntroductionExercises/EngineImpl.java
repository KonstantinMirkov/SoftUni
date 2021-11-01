package DatabaseAppsIntroductionExercises;

import java.io.*;
import java.sql.*;

public class EngineImpl implements Runnable {
    private final BufferedReader reader;

    public EngineImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Please enter exercise number from 2-9, which you want to test.");
            System.out.println("For exit, you can press 0.");
            int exerciseNumber;
            try {
                exerciseNumber = Integer.parseInt(this.reader.readLine());
                if (exerciseNumber == 0) {
                    break;
                }
                switch (exerciseNumber) {
                    case 2 -> GetVillainsNamesEx2.getVillainsNames();
                    case 3 -> GetMinionNamesEx3.getVillainAndMinionsNames();
                    case 4 -> AddMinionEx4.getVillainAndMinionsInfo();
                    case 5 -> ChangeTownNamesCasingEx5.changeTownNamesCasing();
                    case 6 -> RemoveVillainEx6.removeVillain();
                    case 7 -> PrintAllMinionNamesEx7.printAllMinionNames();
                    case 8 -> IncreaseMinionsAgeEx8.increaseMinionsAge();
                    case 9 -> IncreaseAgeStoredProcedureEx9.increaseAgeStoredProcedure();
                    default -> System.out.println("There is no such exercise.");
                }
            } catch (SQLException | IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
