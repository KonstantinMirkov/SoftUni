import entities.*;

import static Queries.Queries.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

public class Manager {
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Manager(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    protected void changeCasingEx2() {
        List<Town> towns = this.entityManager.createQuery(EX2_TOWNS_BY_LENGTH_QUERY, Town.class).getResultList();
        this.entityManager.getTransaction().begin();
        towns.forEach(this.entityManager::detach);
        towns.forEach(town -> town.setName(town.getName().toLowerCase(Locale.ROOT)));
        towns.forEach(this.entityManager::merge);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();

        System.out.println("Towns names with length lower or equal to 5 where made into lower case.");
    }

    protected void containsEmployeeEx3() throws IOException {
        System.out.println("Enter employee's full name to check if exists:");
        String fullName = this.reader.readLine();

        List<Employee> employees = this.entityManager
                .createQuery(EX3_FULL_NAME_QUERY, Employee.class)
                .setParameter("name", fullName)
                .getResultList();

        System.out.println(employees.size() == 0 ? "NO" : "YES");
    }

    protected void employeesWithSalaryOver50000Ex4() {
        this.entityManager.createQuery(EX4_SALARIES_OVER_50000_QUERY, Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    protected void employeesFromDepartmentEx5() {
        this.entityManager.createQuery(EX5_EMPLOYEES_FROM_DEPARTMENT_QUERY, Employee.class).getResultStream()
                .forEach(employee -> System.out.printf("%s %s from Research and Development - $%.2f%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary()));
    }

    protected void addingNewAddressAndUpdatingEmployeeEx6() throws IOException {
        Address address = createAddress("Vitoshka 15");
        System.out.println("Enter employee's last name:");
        String lastname = this.reader.readLine();

        Employee employee = this.entityManager.createQuery(EX6_FIND_EMPLOYEE_LAST_NAME_QUERY, Employee.class)
                .setParameter("name", lastname)
                .getSingleResult();

        this.entityManager.getTransaction().begin();
        employee.setAddress(address);
        this.entityManager.getTransaction().commit();

        System.out.println(lastname + "'s address has been changed to Vitoshka 15");
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();
        return address;
    }

    protected void AddressesWithEmployeeCountEx7() {
        List<Address> addresses = this.entityManager
                .createQuery(EX7_ADDRESSES_WITH_EMPLOYEES_COUNT_QUERY, Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> System.out.printf("%s, %s %d employees%n",
                address.getText(), address.getTown().getName(), address.getEmployees().size()));
    }


    protected void GetEmployeeWithProjectEx8() throws IOException {
        System.out.println("Enter valid employee Id:");
        int id = Integer.parseInt(this.reader.readLine());

        Employee employee = this.entityManager.find(Employee.class, id);
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("\t %s%n", project.getName()));
    }

    protected void FindLatest10ProjectsEx9() {
        List<Project> projects = this.entityManager
                .createQuery(EX9_FIND_PROJECTS_QUERY, Project.class)
                .setMaxResults(10)
                .getResultList();

        StringBuilder print = new StringBuilder();
        projects.sort(Comparator.comparing(Project::getName));
        projects.forEach(project -> print.append("Project name: ").append(project.getName()).append(System.lineSeparator())
                .append("\tProject Description:").append(project.getDescription()).append(System.lineSeparator())
                .append("\tProject Start Date:").append(project.getStartDate()).append(System.lineSeparator())
                .append("\tProject End Date:").append(project.getEndDate()).append(System.lineSeparator()));
        System.out.println(print.toString());
    }

    protected void IncreaseSalariesEx10() {
        this.entityManager.getTransaction().begin();
        int affectedEmployeesSalaries = this.entityManager.createQuery(EX10_INCREASE_SALARIES_QUERY).executeUpdate();
        this.entityManager.getTransaction().commit();

        System.out.println("Affected employees salaries after the increase - " + affectedEmployeesSalaries);
        System.out.println();

        System.out.println("Employees with affected salaries:");
        this.entityManager
                .createQuery(EX10_EMPLOYEES_WITH_INCREASED_SALARIES_QUERY, Employee.class)
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s ($%.2f)%n",
                        employee.getFirstName(), employee.getLastName(), employee.getSalary()));

    }

    protected void FindEmployeesByFirstNameEx11() throws IOException {
        System.out.println("Enter Employee's first name pattern:");
        String firstNamePattern = this.reader.readLine();

        List<Employee> employees = this.entityManager.createQuery(EX11_FIND_EMPLOYEES_BY_FIRSTNAME_PATTERN_QUERY, Employee.class)
                .setParameter("name", firstNamePattern)
                .getResultList();

        System.out.println(employees.isEmpty() ? "No employees found with this pattern." : printEmployeesWithThePattern(employees));

    }

    private List<Employee> printEmployeesWithThePattern(List<Employee> employees) {
        employees.forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                employee.getSalary()));
        return employees;
    }

    protected void EmployeesMaximumSalariesEx12() {
        Query query = this.entityManager.createNativeQuery(EX12_MAXIMUM_SALARIES_IN_DEPARTMENTS_QUERY);

        List<Object[]> resultList = query.getResultList();
        resultList.forEach(department -> System.out.println(department[0] + " " + department[1]));
    }

    protected void RemoveTownsEx13() throws IOException, NullPointerException, NoResultException {
        System.out.println("Enter valid town's name, which you want to remove:");
        String townName = this.reader.readLine();

        Town town = this.entityManager
                .createQuery(EX13_FIND_TOWN_NAME_QUERY, Town.class)
                .setParameter("name", townName)
                .getSingleResult();


        this.entityManager.getTransaction().begin();
        this.entityManager.createNativeQuery(EX13_ALTER_EMPLOYEE_ADDRESSES_QUERY)
                .setParameter("townId", town.getId()).executeUpdate();

        int affectedTowns = this.entityManager.createQuery(EX13_DELETE_ADDRESSES_QUERY)
                .setParameter("id", town.getId()).executeUpdate();

        this.entityManager.createQuery(EX13_DELETE_TOWNS_QUERY)
                .setParameter("id", town.getId())
                .executeUpdate();
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();

        switch (affectedTowns) {
            case 0 -> System.out.printf("No addresses in %s deleted.%n", townName);
            case 1 -> System.out.printf("%d address in %s deleted.%n", affectedTowns, townName);
            default -> System.out.printf("%d addresses in %s deleted.%n", affectedTowns, townName);
        }
    }
}
