package pe.com.relari.fwk.spring.audit.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum: AuditType.
 *
 * @author Relari
 */

@Getter
@RequiredArgsConstructor
public enum AuditType {
  CREATE("CREATE"),
  UPDATE("UPDATE"),
  DELETE("DELETE"),
  READ("READ");

  public final String value;
}
