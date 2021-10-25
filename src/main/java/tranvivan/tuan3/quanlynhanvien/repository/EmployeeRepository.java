package tranvivan.tuan3.quanlynhanvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tranvivan.tuan3.quanlynhanvien.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
