package employee;

import java.util.ArrayList;
import java.util.Random;

public abstract class ManageEmployee {
    private static String[] names = {"Daniel Andrysiak", "Ireneusz Żbik", "Klaudia Zima", "Bogdan Bukowski", "Hanna Wójcik", "Paweł Sokołowski", "Magdalena Kozioł", "Dominik Dębowski", "Anna Koń", "Bartosz Lis", "Lidia Szwed", "Justyna Serafin", "Andrzej Gajos", "Łukasz Ostrowski", "Aleks Wolant", "Konrad Bukowski", "Adam Słowacki", "Juliusz Mickiewicz", "Bartosz Nowakowski", "Krystyna Kałuża", "Klaudia Wawrzyn", "Marlena Wit", "Jakub Wrona", "Stefan Witkiewicz", "Konrad Marek", "Agnieszka Ptak", "Paulina Włodarczyk", "Dawid Kożuch", "Maria Pawlak", "Jolanta Majewska"};
    private static ArrayList<Employee> hiredEmployees = new ArrayList<>();

    public static Employee generateEmployee(String job, int experience) {
        Random random = new Random();
        String name = "";
        boolean leave;
        do {
            leave = false;
            name = names[random.nextInt(names.length)];
            if (hiredEmployees.size() != 0) {
                for(Employee employee: hiredEmployees) {
                    if (employee.getName().equals(name)) {
                        leave = true;
                        break;
                    }
                }
            }

        } while (leave);
        int complaintsRisk = 0;
        int employmentCost = 0;
        int dismissalCost = 0;
        int preferredSalary = 0;
        switch (experience) {
            case 1:
                complaintsRisk = random.nextInt(6) + 11;
                employmentCost = (int) ((random.nextInt(100) + 150) * 1.1);
                dismissalCost = employmentCost + employmentCost * (random.nextInt(1) + 2);
                preferredSalary = (int) ((random.nextInt(300) + 1800) * 1.5);
                break;
            case 2:
                complaintsRisk = random.nextInt(7) + 6;
                employmentCost = (int) ((random.nextInt(100) + 250) * 1.3);
                dismissalCost = employmentCost + employmentCost * (random.nextInt(1) + 2);
                preferredSalary = (int) ((random.nextInt(300) + 1800) * 1.8);
                break;
            case 3:
                complaintsRisk = random.nextInt(5) + 2;
                employmentCost = (int) ((random.nextInt(150) + 400) * 1.5);
                dismissalCost = employmentCost + employmentCost * (random.nextInt(1) + 2);
                preferredSalary = (int) ((random.nextInt(300) + 1800) * 2.1);
                break;
        }
        Employee e = new Employee(name, experience, job, preferredSalary, employmentCost, dismissalCost, complaintsRisk);
        hiredEmployees.add(e);
        return e;
    }

    public static ArrayList<Employee> getHiredEmployees() {
        return hiredEmployees;
    }

    public static void reset() {
        hiredEmployees = new ArrayList<Employee>();
    }

}
