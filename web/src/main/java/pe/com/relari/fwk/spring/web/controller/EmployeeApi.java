package pe.com.relari.fwk.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.relari.commons.constant.Regex;
import pe.com.relari.commons.model.error.ErrorResponse;
import pe.com.relari.fwk.spring.web.employee.model.api.AddressResponse;
import pe.com.relari.fwk.spring.web.employee.model.api.EmployeeRequest;
import pe.com.relari.fwk.spring.web.employee.model.api.EmployeeResponse;

import java.util.List;

/**
 * <b>Interface:</b> EmployeeApi.<br>
 *
 * @author Relari
 */

public interface EmployeeApi {

  @Operation(
      summary = "Listado de Empleados.",
      method = "GET",
      responses = {
          @ApiResponse(
              responseCode = "200",
              content = @Content(
                  array = @ArraySchema(
                      schema = @Schema(implementation = EmployeeResponse.class)),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  List<EmployeeResponse> findAll();

  @Operation(
      summary = "Listado de Empleados.",
      method = "GET",
      responses = {
          @ApiResponse(
              responseCode = "200",
              content = @Content(
                  schema = @Schema(implementation = pe.com.relari.commons.model.api.ApiResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  pe.com.relari.commons.model.api.ApiResponse<List<EmployeeResponse>> findAll2();

  @Operation(
      summary = "Obtiene la informacion de un empleado por el ID.",
      method = "GET",
      responses = {
          @ApiResponse(
              responseCode = "200",
              content = @Content(
                  schema = @Schema(implementation = EmployeeResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          ),
          @ApiResponse(
              responseCode = "400",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  @GetMapping(path = "/{id}")
  EmployeeResponse findById(
//      @IdPathParameter
      @Pattern(regexp = Regex.REGEXP_ONLY_NUMBER)
      @PathVariable(name = "id") String id);

  @Operation(
      summary = "Obtiene la informacion del contacto del empleado por ID.",
      method = "GET",
      responses = {
          @ApiResponse(
              responseCode = "200",
              content = @Content(
                  schema = @Schema(implementation = AddressResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          ),
          @ApiResponse(
              responseCode = "400",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  @GetMapping(path = "/{id}/address")
  AddressResponse getAddressById(
//      @IdPathParameter
      @Pattern(regexp = Regex.REGEXP_ONLY_NUMBER)
      @PathVariable(name = "id") String id);

  @Operation(
      summary = "Registra un nuevo empleado.",
      method = "POST",
      responses = {
          @ApiResponse(
              responseCode = "201"
          ),
          @ApiResponse(
              responseCode = "409",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  void save(@RequestBody @Valid EmployeeRequest employeeRequest);

  @Operation(
      summary = "Elimina a todos los empleados.",
      method = "DELETE",
      responses = {
          @ApiResponse(
              responseCode = "204"
          )
      })
  void deleteAll();

  @Operation(
      summary = "Elimina al empleado por el ID.",
      method = "DELETE",
      responses = {
          @ApiResponse(
              responseCode = "204"
          ),
          @ApiResponse(
              responseCode = "400",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  @DeleteMapping(path = "/{id}")
  void deleteById(
//      @IdPathParameter
      @Pattern(regexp = Regex.REGEXP_ONLY_NUMBER)
      @PathVariable(name = "id") String id);

  @Operation(
      summary = "Inactiva al empleado por el ID",
      method = "PATCH",
      responses = {
          @ApiResponse(
              responseCode = "204"
          ),
          @ApiResponse(
              responseCode = "400",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          ),
          @ApiResponse(
              responseCode = "409",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  @PatchMapping(path = "/{id}/inactive")
  void inactiveById(
//      @IdPathParameter
      @Pattern(regexp = Regex.REGEXP_ONLY_NUMBER)
      @PathVariable(name = "id") String id);

  @Operation(
      summary = "Activa al empleado por el ID",
      method = "PATCH",
      responses = {
          @ApiResponse(
              responseCode = "204"
          ),
          @ApiResponse(
              responseCode = "400",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          ),
          @ApiResponse(
              responseCode = "409",
              content = @Content(
                  schema = @Schema(implementation = ErrorResponse.class),
                  mediaType = MediaType.APPLICATION_JSON_VALUE
              )
          )
      })
  @PatchMapping(path = "/{id}/active")
  void activeById(
//      @IdPathParameter
      @Pattern(regexp = Regex.REGEXP_ONLY_NUMBER)
      @PathVariable(name = "id") String id);

}
