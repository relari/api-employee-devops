package pe.com.relari.employee.dao.webservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class: AuditRequest.
 *
 * @author Relari
 */

@Getter
@Setter
@Builder
public class AuditRequest {

  private ApplicationRequest application;
  private UserRequest user;
  private OperationRequest operation;

}
