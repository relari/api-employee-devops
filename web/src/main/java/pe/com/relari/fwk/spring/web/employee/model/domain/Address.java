package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.fwk.spring.web.employee.model.api.AddressRequest;

/**
 * <b>Class:</b> Address.<br>
 *
 * @author Relari.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Address {

  private String email;
  private String phoneNumber;

  /**
   * Constructor: Address.
   *
   * @param addressRequest {@link AddressRequest}
   */
  public Address(AddressRequest addressRequest) {
    this.email = addressRequest.getEmail();
    this.phoneNumber = addressRequest.getPhoneNumber();
  }

}
