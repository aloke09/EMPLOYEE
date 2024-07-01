package emp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeProjectManagementSystem {
    private List<Employee> employees;
    private List<Project> projects;

    public EmployeeProjectManagementSystem(List<Employee> employees, List<Project> projects) {
        this.employees = employees;
        this.projects = projects;
    }

    // Generate a list of all project names an employee is working on.
    public List<String> getProjectsByEmployee(String employeeId) {
        return employees.stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Generate a list of all employees working on a specific project.
    public List<String> getEmployeesByProject(String projectId) {
        return projects.stream()
                .filter(p -> p.getProjectId().equals(projectId))
                .flatMap(p -> p.getEmployees().stream())
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Find the total number of projects each employee is working on.
    public Map<String, Long> getTotalProjectsByEmployee() {
        return employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        e -> (long) e.getProjects().size()
                ));
    }

    // Generate a list of departments and the number of employees in each.
    public Map<String, Long> getEmployeeCountByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }

    // Generate a list of all unique projects across all employees.
    public Set<String> getAllUniqueProjects() {
        return employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName)
                .collect(Collectors.toSet());
    }

    // Find employees who are assigned to more than a specified number of projects.
    public List<String> getEmployeesWithMoreThanNProjects(int n) {
        return employees.stream()
                .filter(e -> e.getProjects().size() > n)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    // Generate a list of active projects and their assigned employees.
    public Map<String, List<String>> getActiveProjectsAndEmployees() {
        return projects.stream()
                .filter(p -> p.getStatus().equalsIgnoreCase("active"))
                .collect(Collectors.toMap(
                        Project::getName,
                        p -> p.getEmployees().stream()
                                .map(Employee::getName)
                                .collect(Collectors.toList())
                ));
    }
}
