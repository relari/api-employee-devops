package pe.com.relari.fwk.spring.audit.model.api;

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
