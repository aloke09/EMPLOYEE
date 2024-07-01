package emp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Project project1 = new Project("P001", "BOJO SOLUTIONS", "active");
        Project project2 = new Project("P002", "BRIDGELABZ", "completed");
        Project project3 = new Project("P003", "BRISK", "active");

        Employee employee1 = new Employee("E001", "chandu", "HR");
        Employee employee2 = new Employee("E002", "alok", "Engineering");
        Employee employee3 = new Employee("E003", "sahil", "Marketing");

        employee1.addProject(project1);
        employee1.addProject(project2);
        employee2.addProject(project1);
        employee2.addProject(project3);
        employee3.addProject(project3);

        project1.addEmployee(employee1);
        project1.addEmployee(employee2);
        project2.addEmployee(employee1);
        project3.addEmployee(employee2);
        project3.addEmployee(employee3);

        EmployeeProjectManagementSystem system = new EmployeeProjectManagementSystem(Arrays.asList(employee1, employee2, employee3),Arrays.asList(project1, project2, project3));
        System.out.println("Projects by Employee E001: " + system.getProjectsByEmployee("E001"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Employees by Project P001: " + system.getEmployeesByProject("P001"));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Projects by Employee: " + system.getTotalProjectsByEmployee());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Employee Count by Department: " + system.getEmployeeCountByDepartment());
        System.out.println("----------------------------------------------------------------");
        System.out.println("All Unique Projects: " + system.getAllUniqueProjects());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Employees with more than 1 project: " + system.getEmployeesWithMoreThanNProjects(1));
        System.out.println("----------------------------------------------------------------");
        System.out.println("Active Projects and Employees: " + system.getActiveProjectsAndEmployees());
    }
}
