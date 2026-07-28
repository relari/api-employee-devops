package pe.com.relari.audit.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: UserRequest.
 *
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

  private String id;
  private String ip;

}
