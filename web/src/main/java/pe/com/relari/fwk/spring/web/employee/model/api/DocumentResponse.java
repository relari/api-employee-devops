
package pe.com.relari.fwk.spring.web.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <b>Record:</b> DocumentResponse.<br>
 *
 * @param type {@link String}
 * @param number {@link String}
 */

public record DocumentResponse (

    @Schema(
            description = "Representa el tipo de documento del empleado",
            name = "type",
            implementation = String.class,
            example = "DNI")
    String type,

    @Schema(
            description = "Representa el numero de documento del empleado",
            name = "number",
            implementation = String.class,
            example = "12345678")
    String number
) {}
