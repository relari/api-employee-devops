package pe.com.relari.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.employee.model.api.CompanyRequest;

/**
 * Class: Company.
 *
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Company {

  private JobTitle jobTitle;
  private Double salary;

  /**
   * Constructor: Address.
   *
   * @param companyRequest {@link CompanyRequest}
   */
  public Company(CompanyRequest companyRequest) {
    this.jobTitle = JobTitle.valueOf(companyRequest.getJobTitle());
    this.salary = companyRequest.getSalary();
  }

}
