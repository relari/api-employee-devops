package pe.com.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.employee.util.Constants;

/**
 * Class: AddressRequest.
 *
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          implementation = String.class,
          example = "email@mail.com",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotBlank
  @Email
  private String email;

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "phoneNumber",
          implementation = String.class,
          example = "999999999",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotBlank
  @Pattern(regexp = Constants.REGEXP_PHONE_NUMBER)
  private String phoneNumber;

}
