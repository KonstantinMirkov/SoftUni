import java.io.*;

public record Engine(Manager manager, BufferedReader reader) implements Runnable {

    public void run() {
        while (true) {
            System.out.println("Please enter exercise number from 2-9, which you want to test.");
            System.out.println("For exit, you can press 0.");
            int exerciseNumber;
            try {
                exerciseNumber = Integer.parseInt(this.reader.readLine());

                if (exerciseNumber == 0) {
                    System.out.println("You are exiting the program.");
                    break;
                }

                switch (exerciseNumber) {
                    case 2 -> this.manager.changeCasingEx2();
                    case 3 -> this.manager.containsEmployeeEx3();
                    case 4 -> this.manager.employeesWithSalaryOver50000Ex4();
                    case 5 -> this.manager.employeesFromDepartmentEx5();
                    case 6 -> this.manager.addingNewAddressAndUpdatingEmployeeEx6();
                    case 7 -> this.manager.AddressesWithEmployeeCountEx7();
                    case 8 -> this.manager.GetEmployeeWithProjectEx8();
                    case 9 -> this.manager.FindLatest10ProjectsEx9();
                    case 10 -> this.manager.IncreaseSalariesEx10();
                    case 11 -> this.manager.FindEmployeesByFirstNameEx11();
                    case 12 -> this.manager.EmployeesMaximumSalariesEx12();
                    case 13 -> this.manager.RemoveTownsEx13();
                    default -> System.out.println("There is no such exercise.");
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
