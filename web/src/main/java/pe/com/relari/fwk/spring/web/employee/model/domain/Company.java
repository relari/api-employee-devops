package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.fwk.spring.web.employee.model.api.CompanyRequest;

/**
 * <b>Class:</b> Company.<br>
 *
 * @author Relari.
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
