package pe.com.relari.fwk.spring.web.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.commons.constant.Regex;

/**
 * <b>Class:</b> CompanyRequest.<br>
 *
 * @author Relari.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {

    @Schema(
            description = "Cargo del Empleado",
            name = "jobTitle",
            implementation = String.class,
            example = "Developer",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Pattern(regexp = Regex.REGEXP_JOBS_TITLES)
    private String jobTitle;

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            implementation = Double.class,
            example = "1000.00",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private Double salary;

}
