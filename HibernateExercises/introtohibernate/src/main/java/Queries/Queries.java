package Queries;

public final class Queries {
    //EX2
    public static final String EX2_TOWNS_BY_LENGTH_QUERY = "SELECT t FROM Town t WHERE length(t.name) <= 5";


    //Ex3
    public static final String EX3_FULL_NAME_QUERY = "SELECT e FROM Employee e " +
            "WHERE concat(e.firstName, ' ', e.lastName) = :name ";


    //EX4
    public static final String EX4_SALARIES_OVER_50000_QUERY = "SELECT e FROM Employee e WHERE e.salary > 50000";


    //EX5
    public static final String EX5_EMPLOYEES_FROM_DEPARTMENT_QUERY = "SELECT e FROM Employee e WHERE e.department.name = 'Research and Development' " +
            "ORDER BY e.salary, e.id";


    //EX6
    public static final String EX6_FIND_EMPLOYEE_LAST_NAME_QUERY = "SELECT e FROM Employee e WHERE e.lastName = :name";


    //EX7
    public static final String EX7_ADDRESSES_WITH_EMPLOYEES_COUNT_QUERY = "SELECT a FROM Address a ORDER BY a.employees.size DESC";


    //EX9
    public static final String EX9_FIND_PROJECTS_QUERY = "SELECT p FROM Project p ORDER BY p.startDate DESC";


    //EX10
    public static final String EX10_INCREASE_SALARIES_QUERY = "UPDATE Employee e SET e.salary = e.salary * 1.12 " +
            "WHERE e.department.id IN (1,2,4,11)";

    public static final String EX10_EMPLOYEES_WITH_INCREASED_SALARIES_QUERY = "SELECT e FROM Employee e WHERE e.department.id IN (1,2,4,11)";


    //EX11
    public static final String EX11_FIND_EMPLOYEES_BY_FIRSTNAME_PATTERN_QUERY = "SELECT e FROM Employee e WHERE e.firstName LIKE concat(:name, '%')";


    //EX12
    public static final String EX12_MAXIMUM_SALARIES_IN_DEPARTMENTS_QUERY = """
            SELECT d.name, max(e.salary) FROM departments d
            JOIN employees e ON e.department_id = d.department_id
            GROUP BY d.name
            HAVING max(e.salary) NOT BETWEEN 30000 AND 70000
            """;


    //EX13
    public static final String EX13_FIND_TOWN_NAME_QUERY = "SELECT t FROM Town t WHERE t.name LIKE :name";

    public static final String EX13_ALTER_EMPLOYEE_ADDRESSES_QUERY = """
            UPDATE employees e
            JOIN addresses a ON e.address_id = a.address_id
            JOIN towns t ON t.town_id = a.town_id
            SET e.address_id = null WHERE a.town_id = :townId
            """;

    public static final String EX13_DELETE_ADDRESSES_QUERY = "DELETE FROM Address a WHERE a.town.id = :id";

    public static final String EX13_DELETE_TOWNS_QUERY = "DELETE FROM Town t WHERE t.id = :id";
}
