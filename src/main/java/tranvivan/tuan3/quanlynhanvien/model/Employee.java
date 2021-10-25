package tranvivan.tuan3.quanlynhanvien.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private Float basicSalary;
    private Integer overtimeHour;
    private Integer numberOfBugs;
    private String employeeType;
}
