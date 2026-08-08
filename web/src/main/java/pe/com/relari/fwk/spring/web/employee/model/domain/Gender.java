package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>Enum:</b> Gender.<br>
 *
 * @author Relari.
 */

@Getter
@RequiredArgsConstructor
public enum Gender {

  M("Male"), F("Female");

  private final String description;

}
