package pe.com.relari.audit.model;

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
