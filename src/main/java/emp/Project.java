package emp;

import java.util.*;

class Project {
    private String projectId;
    private String name;
    private String status;
    private List<Employee> employees;

    public Project(String projectId, String name, String status) {
        this.projectId = projectId;
        this.name = name;
        this.status = status;
        this.employees = new ArrayList<>();
    }

    // Getters and setters
    public String getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}