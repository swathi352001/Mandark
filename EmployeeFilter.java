import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputManagerFile = "managers.csv";
        String outputSingleNameFile = "single_name_employees.csv";

        List<String[]> employees = readEmployees(inputFile);

        List<String[]> managers = filterManagersInRnD(employees);
        writeEmployees(managers, outputManagerFile);

        List<String[]> singleNameEmployees = filterSingleNameEmployees(employees);
        writeEmployees(singleNameEmployees, outputSingleNameFile);
    }

    private static List<String[]> readEmployees(String inputFile) {
        List<String[]> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static List<String[]> filterManagersInRnD(List<String[]> employees) {
        List<String[]> managersInRnD = new ArrayList<>();
        for (String[] employee : employees) {
            String role = employee[1];
            String division = employee[2];
            if (role.equals("Manager") && division.equals("R&D")) {
                managersInRnD.add(employee);
            }
        }
        return managersInRnD;
    }

    private static List<String[]> filterSingleNameEmployees(List<String[]> employees) {
        List<String[]> singleNameEmployees = new ArrayList<>();
        for (String[] employee : employees) {
            String name = employee[0];
            if (!name.contains(" ")) {
                singleNameEmployees.add(employee);
            }
        }
        return singleNameEmployees;
    }

    private static void writeEmployees(List<String[]> employees, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String[] employee : employees) {
                String line = String.join(",", employee) + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
