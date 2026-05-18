package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Class: AddressResponse.
 *
 * @author Relari
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
