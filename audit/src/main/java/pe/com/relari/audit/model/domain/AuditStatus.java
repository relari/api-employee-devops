package pe.com.relari.audit.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum: AuditStatus.
 *
 * @author Relari
 */

@Getter
@RequiredArgsConstructor
public enum AuditStatus {

  SUCCESS("SUCCESS"),
  FAILURE("FAILURE");

  private final String value;

}
