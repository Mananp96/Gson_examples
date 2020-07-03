package gson_advanced;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Employee;
import util.Constants;

import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonEmployee {

    // pretty print
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        GsonEmployee gsonEmployee = new GsonEmployee();

        System.out.println(gsonEmployee.employeeDeserialize());

        Employee employee = gsonEmployee.createEmployeeObject();

        gsonEmployee.writeJson(employee);
    }

    private Employee createEmployeeObject() {
        Employee employee = new Employee();
        employee.setName("Manan");
        employee.setAge(25);
        employee.setPosition(new String[] {"Java Developer", "Software Developer"});
        employee.setSkills(Arrays.asList("java", "python"));
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2019", new BigDecimal(15));
            put("2020", new BigDecimal(20));
        }};
        employee.setSalary(salary);

        return employee;
    }

    public Employee employeeDeserialize() {
        try (FileReader reader = new FileReader(Constants.EMPLOYEE_FILE)) {

            // Deserialize Json File to Object (Object to JSON conversion)
            return gson.fromJson(reader, Employee.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeJson(Employee employee) {
        try (FileWriter writer = new FileWriter(Constants.OUTPUT_EMPLOYEE_FILE)) {

            // Java Object to File
            gson.toJson(employee, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
