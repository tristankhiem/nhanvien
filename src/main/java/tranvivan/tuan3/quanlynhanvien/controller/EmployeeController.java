package tranvivan.tuan3.quanlynhanvien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tranvivan.tuan3.quanlynhanvien.model.Employee;
import tranvivan.tuan3.quanlynhanvien.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-employees")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @GetMapping("/report")
    public ResponseEntity<?> report() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeesHaveUnderAverageSalary());
    }

    @GetMapping("/get-employee/{id}")
    public ResponseEntity<?> GetAEmployee(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
    }

    @PostMapping("/create-list")
    public ResponseEntity<?> Create(@RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createListEmployees(employees));
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable String id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee is deleted");
    }
}
