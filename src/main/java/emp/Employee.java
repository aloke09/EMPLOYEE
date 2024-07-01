package emp;

import java.util.*;

class Employee {
    private String employeeId;
    private String name;
    private String department;
    private List<Project> projects;

    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}