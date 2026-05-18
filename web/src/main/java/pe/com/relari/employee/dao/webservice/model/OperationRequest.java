package pe.com.relari.employee.dao.webservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class: OperationRequest.
 *
 * @author Relari
 */

@Getter
@Setter
@Builder
public class OperationRequest {

  private String type;
  private String action;
  private String status;
  private Integer statusCode;
  private String message;
  private String trace;
  private String timestamp;
  private String requestId;
  private String sessionId;

}
