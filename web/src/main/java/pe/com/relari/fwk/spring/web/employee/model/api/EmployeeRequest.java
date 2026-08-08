
package pe.com.relari.fwk.spring.web.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import pe.com.relari.commons.constant.Regex;

/**
 * <b>Class:</b> EmployeeRequest.<br>
 *
 * @author Relari.
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @Schema(
            description = "Nombre del Empleado",
            name = "firstName",
            implementation = String.class,
            example = "Renzo",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            implementation = String.class,
            example = "Lavado",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            implementation = String.class,
            example = "Lavado",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "gender",
            implementation = String.class,
            example = "M o F",
            pattern = Regex.REGEXP_GENDER,
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Pattern(regexp = Regex.REGEXP_GENDER)
    private String gender;

    @Schema(
            description = "Fecha de Nacimiento del Empleado",
            name = "dateOfBirth",
            implementation = String.class,
            example = "01/01/1990",
            pattern = Regex.REGEXP_DATE,
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    @Pattern(regexp = Regex.REGEXP_DATE)
    private String dateOfBirth;

    @Valid
    @NotNull
    private DocumentRequest document;

    @Valid
    @NotNull
    private CompanyRequest company;

    @Valid
    @NotNull
    private AddressRequest address;

}