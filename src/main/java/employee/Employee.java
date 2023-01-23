package employee;

public class Employee {
    String name;
    int experience;
    String job;
    int preferredSalary;
    int employmentCost;
    int dismissalCost;
    int complaintsRisk;

    public Employee(String name, int experience, String job, int preferredSalary, int employmentCost, int dismissalCost, int complaintsRisk) {
        this.name = name;
        this.experience = experience;
        this.job = job;
        this.preferredSalary = preferredSalary;
        this.employmentCost = employmentCost;
        this.dismissalCost = dismissalCost;
        this.complaintsRisk = complaintsRisk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getPreferredSalary() {
        return preferredSalary;
    }

    public void setPreferredSalary(int preferredSalary) {
        this.preferredSalary = preferredSalary;
    }

    public int getEmploymentCost() {
        return employmentCost;
    }

    public void setEmploymentCost(int employmentCost) {
        this.employmentCost = employmentCost;
    }

    public int getDismissalCost() {
        return dismissalCost;
    }

    public void setDismissalCost(int dismissalCost) {
        this.dismissalCost = dismissalCost;
    }

    public int getComplaintsRisk() {
        return complaintsRisk;
    }

    public void setComplaintsRisk(int complaintsRisk) {
        this.complaintsRisk = complaintsRisk;
    }
}
