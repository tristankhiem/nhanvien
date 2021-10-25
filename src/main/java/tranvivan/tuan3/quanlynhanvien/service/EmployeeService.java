package tranvivan.tuan3.quanlynhanvien.service;

import org.springframework.stereotype.Service;
import tranvivan.tuan3.quanlynhanvien.helper.UUIDHelper;
import tranvivan.tuan3.quanlynhanvien.model.Employee;
import tranvivan.tuan3.quanlynhanvien.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public boolean createListEmployees(List<Employee> employeeList) {
        for (Employee employee: employeeList) {
            employee.setId(UUIDHelper.generateType4UUID().toString());
            employeeRepository.save(employee);
        }

        return true;
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(String id) {
        return employeeRepository.getById(id);
    }

    public List<Employee> findEmployeesHaveUnderAverageSalary() {
        List<Employee> primaryEmployeeList = employeeRepository.findAll();
        Float avgSalary = calculateAverageSalary(primaryEmployeeList);
        List<Employee> finalEmployeeList = new ArrayList<>();

        for (Employee employee: primaryEmployeeList) {
            if (calculateSalary(employee) < avgSalary) {
                finalEmployeeList.add(employee);
            }
        }

        return finalEmployeeList;
    }

    private Float calculateAverageSalary(List<Employee> employeeList) {
        Float avgSalary = 0.0f;

        if (employeeList.size() == 0) {
            return 0.0f;
        }

        for (Employee employee: employeeList) {
            avgSalary += calculateSalary(employee);
        }

        return avgSalary / employeeList.size();
    }

    private Float calculateSalary(Employee employee) {
        if (employee.getEmployeeType().equals("DEV")) {
            return employee.getBasicSalary() + employee.getOvertimeHour()*200000;
        } else if (employee.getEmployeeType().equals("TESTER")) {
            return employee.getBasicSalary() + employee.getNumberOfBugs()*50000;
        }
        return 0.0f;
    }

    public void delete(String id) {
        employeeRepository.deleteById(id);
    }
}
