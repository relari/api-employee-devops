package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>Enum:</b> JobTitle.<br>
 *
 * @author Relari.
 */

@Getter
@RequiredArgsConstructor
public enum JobTitle {

  DEVELOPER("Developer"),
  MANAGER("Manager"),
  ARCHITECT("Architect"),
  SCRUM_MASTER("Scrum Master"),
  TEAM_LEAD("Team Lead");

  private final String description;

}
