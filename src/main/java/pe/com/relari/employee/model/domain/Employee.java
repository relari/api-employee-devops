package pe.com.relari.employee.model.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class: Employee.
 *
 * @author Relari
 */

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  private Integer idEmployee;
  private Document document;
  private String fatherLastName;
  private String motherLastName;
  private String firstName;
  private Gender gender;
  private LocalDate dateOfBirth;
  private Address address;
  private Company company;
  private LocalDateTime createdAt;
  private Boolean status;

  public String getFullName() {
    return String.format("%s %s, %s", fatherLastName, motherLastName, firstName);
  }
}