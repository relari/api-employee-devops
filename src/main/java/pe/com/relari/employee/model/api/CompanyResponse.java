package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * record: CompanyResponse.
 *
 * @param jobTitle {@link String}
 * @param salary {@link Double}
 */

public record CompanyResponse(

    @Schema(
            description = "Cargo del Empleado",
            name = "jobTitle",
            implementation = String.class,
            example = "Developer")
    String jobTitle,

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            implementation = Double.class,
            example = "1000.00")
    Double salary

) {}
