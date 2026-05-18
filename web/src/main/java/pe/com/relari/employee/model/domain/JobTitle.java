package pe.com.relari.employee.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
