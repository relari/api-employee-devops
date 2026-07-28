package pe.com.relari.audit.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class: AuditValues.
 *
 * @author Relari
 */

@Getter
@Setter
@Builder
public class AuditValues {

  private AuditType type;
  private String action;
  private AuditStatus status;
  private Integer statusCode;
  private String message;
  private String trace;

}
