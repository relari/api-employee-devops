package pe.com.relari.employee.model.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class: EmployeeResponse.
 * @author Relari
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    @Schema(
            description = "Id del Empleado",
            name = "id",
            implementation = Integer.class,
            example = "1")
    private Integer id;

    @Schema(
            description = "Nombre del Empleado",
            name = "firstName",
            implementation = String.class,
            example = "Renzo")
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            implementation = String.class,
            example = "Lavado")
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            implementation = String.class,
            example = "Rivas")
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "gender",
            implementation = String.class,
            example = "M")
    private String gender;

    @Schema(
            description = "Fecha de Nacimiento del Empleado",
            name = "dateOfBirth",
            implementation = String.class,
            example = "01/01/2020")
    private String dateOfBirth;

    private AddressResponse address;
    private CompanyResponse company;

    @Schema(
            description = "Estado del Empleado",
            name = "status",
            implementation = Boolean.class,
            example = "true")
    private Boolean status;

}