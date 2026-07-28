package pe.com.relari.employee.dao.repository.entity;

import jakarta.persistence.*;

import pe.com.relari.employee.model.domain.DocumentType;
import pe.com.relari.employee.model.domain.Gender;
import pe.com.relari.employee.model.domain.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * <b>Class:</b> EmployeeEntity.</br>
 * 
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "documentType", nullable = false)
  private DocumentType documentType;

  @Column(name = "documentNumber", length = 10, nullable = false)
  private String documentNumber;

  @Column(name = "fatherLastName", length = 50, nullable = false)
  private String fatherLastName;

  @Column(name = "motherLastName", length = 50, nullable = false)
  private String motherLastName;

  @Column(name = "firstName", length = 50, nullable = false)
  private String firstName;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender", length = 1, nullable = false)
  private Gender gender;

  @Column(name = "dateOfBirth", length = 10, nullable = false, columnDefinition = "DATE")
  private LocalDate dateOfBirth;

  @Enumerated(EnumType.STRING)
  @Column(name = "jobTitle", length = 50, nullable = false)
  private JobTitle jobTitle;

  @Column(name = "salary", nullable = false)
  private Double salary;

  @Column(name = "email", length = 100, nullable = false)
  private String email;

  @Column(name = "phoneNumber", length = 15, nullable = false)
  private String phoneNumber;

  @Column(name = "createdAt", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(name = "status", nullable = false)
  private Boolean status;

}
