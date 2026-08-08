package pe.com.relari.fwk.spring.web.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <b>Class:</b> AddressResponse.<br>
 *
 * @author Relari.
 */

public record AddressResponse(

    @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          implementation = String.class,
          example = "email@mail.com")
    String email,

    @Schema(
          description = "Correo Electronico del Empleado",
          name = "phoneNumber",
          implementation = String.class,
          example = "999999999")
    String phoneNumber

){}
