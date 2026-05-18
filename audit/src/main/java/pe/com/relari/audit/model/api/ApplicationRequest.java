package pe.com.relari.audit.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class: ApplicationRequest.
 *
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {

  private String name;
  private String version;

}
