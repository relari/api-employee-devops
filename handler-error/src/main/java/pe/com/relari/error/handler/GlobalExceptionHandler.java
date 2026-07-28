package pe.com.relari.error.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.com.relari.error.config.ErrorProperties;
import pe.com.relari.error.exception.ApiException;
import pe.com.relari.error.model.ErrorResponse;
import pe.com.relari.error.model.ValidationError;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <b>Class:</b> GlobalExceptionHandler.<br>
 *
 * @author Relari
 */

@Slf4j
@Getter
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  @Value("${spring.application.name}")
  private String applicationName;

  @Value("${spring.profiles.active:prod}")
  private String activeProfile;

  private final ErrorProperties errorProperties;

  /**
   * Verifica si está en ambiente de desarrollo para incluir stack traces.
   *
   * @return true si debe incluir stack trace (dev, test), false si es producción
   */
  private boolean shouldIncludeStackTrace() {
    return activeProfile.contains("dev") || activeProfile.contains("test") || activeProfile.contains("local");
  }

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ErrorResponse> apiException(
          ApiException apiException) {

    ErrorResponse errorResponse = errorProperties.getError(apiException.getMessage());
    errorResponse.setTimestamp(LocalDateTime.now(Clock.systemDefaultZone()).toString());

    if (shouldIncludeStackTrace()) {
      errorResponse.setThrowable(apiException.getCause());
    }

    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }


  /**
   * Maneja las excepciones personalizadas de negocio (ApiException).
   * Se lanza cuando ocurre un error controlado en la lógica de negocio,
   * mapeado en el catálogo de errores.
   * El stack trace se incluye solo en ambiente de desarrollo.
   *
   * @param apiException La excepción de negocio capturada
   * @param request  La solicitud HTTP actual
   * @return ResponseEntity con los detalles del error en formato JSON
   */
//  @ExceptionHandler(ApiException.class)
//  public ResponseEntity<ErrorResponse> apiException(
//      ApiException apiException, HttpServletRequest request) {
//
//    // Intentamos obtener la categoría desde YAML si se lanzó con ErrorCatalog
//    var catalog = apiException.getCatalog();
//    if (catalog != null) {
//      var errorCategory = errorProperties.getCategory(catalog);
//      log.error("[ApiException] {} - Cause: {}", catalog, apiException.getMessage(), apiException);
//      // Si la categoría viene desde la configuración, construimos ErrorResponse desde ella
//      if (errorCategory != null) {
//        var error = new ErrorResponse(errorCategory, apiException.getCause(), shouldIncludeStackTrace());
//        return ResponseEntity.status(error.getStatus()).body(error);
//      }
//      // Si la categoría no está en YAML, devolvemos 500 con mensaje genérico
//      log.warn("Category '{}' no encontrada en application.yml - retornando 500", catalog);
//      var fallback = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), apiException.getMessage());
//      if (shouldIncludeStackTrace()) {
//        fallback.setThrowable(ErrorResponse.getStackTraceStatic(apiException));
//      }
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(fallback);
//    }
//
//    // Si la excepción se creó con un HttpErrorCode genérico en lugar de ErrorCatalog
//    if (apiException.getHttpErrorCode() != null) {
//      var httpError = apiException.getHttpErrorCode();
//      log.error("[ApiException] HTTP {} - {}", httpError.getCode(), apiException.getMessage(), apiException);
//      var err = new ErrorResponse(httpError.getCode(), apiException.getMessage() == null ? httpError.getDescription() : apiException.getMessage());
//      if (shouldIncludeStackTrace()) {
//        err.setThrowable(ErrorResponse.getStackTraceStatic(apiException));
//      }
//      return ResponseEntity.status(httpError.getCode()).body(err);
//    }
//
//    // Fallback: excepción ApiException sin catálogo ni HttpErrorCode
//    log.error("[ApiException] sin catalog ni httpErrorCode - Cause: {}", apiException.getMessage(), apiException);
//    var error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), apiException.getMessage());
//    if (shouldIncludeStackTrace()) {
//      error.setThrowable(ErrorResponse.getStackTraceStatic(apiException));
//    }
//    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
//  }
//
//  /**
//   * Maneja cualquier excepción no controlada (Exception).
//   * Se lanza ante errores inesperados del sistema (NullPointerException, fallos
//   * de BD no controlados, etc.).
//   * Actúa como un "catch-all" para evitar que el cliente reciba un stacktrace completo.
//   * En desarrollo, incluye el stack trace para debugging.
//   *
//   * @param exception La excepción inesperada
//   * @param request   La solicitud HTTP actual
//   * @return ResponseEntity con error 500 Internal Server Error
//   */
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<ErrorResponse> handleException(
//      Exception exception, HttpServletRequest request) {
//
//    log.error("Unexpected error occurred", exception);
//
//    var status = HttpStatus.INTERNAL_SERVER_ERROR;
//    var error = new ErrorResponse(status.value(), exception.getMessage());
//
//    // Incluir stack trace solo en desarrollo
//    if (shouldIncludeStackTrace()) {
//      error.setThrowable(ErrorResponse.getStackTraceStatic(exception));
//    }
//
//    return ResponseEntity.status(status).body(error);
//  }
//
//  /**
//   * Maneja excepciones de validación de argumentos (@Valid).
//   * Se lanza cuando el cuerpo de la solicitud (Body) falla las validaciones de
//   * las anotaciones
//   * (ej: @NotNull, @Email, @Size) en el DTO de entrada.
//   *
//   * @param exception La excepción con los resultados de la validación
//   * @param request   La solicitud HTTP actual
//   * @return ResponseEntity con error 400 y la lista detallada de campos inválidos
//   */
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public ResponseEntity<ErrorResponse> methodArgumentNotValidException(
//      MethodArgumentNotValidException exception, HttpServletRequest request) {
//
//    log.error("[MethodArgumentNotValidException] occurred", exception);
//
//    var status = HttpStatus.BAD_REQUEST;
//
//    List<ValidationError> errorDetails = exception.getBindingResult().getFieldErrors().stream()
//        .map(fieldError -> new ValidationError(
//            fieldError.getField(),
//            fieldError.getDefaultMessage()))
//        .toList();
//
//    var error = new ErrorResponse(status.value(), exception.getMessage());
//    error.setDetails(errorDetails);
//
//    return ResponseEntity.status(status).body(error);
//  }
//
//  /**
//   * Maneja la ausencia de parámetros requeridos (@RequestParam).
//   * Se lanza cuando un endpoint espera un parámetro obligatorio en la URL (Query
//   * Param)
//   * y este no es proporcionado por el cliente.
//   *
//   * @param exception La excepción que indica qué parámetro falta
//   * @param request   La solicitud HTTP actual
//   * @return ResponseEntity con error 400 indicando el parámetro faltante
//   */
//  @ExceptionHandler(MissingServletRequestParameterException.class)
//  public ResponseEntity<ErrorResponse> missingServletRequestParameterException(
//      MissingServletRequestParameterException exception, HttpServletRequest request) {
//
//    log.error("[MissingServletRequestParameterException] occurred", exception);
//
//    var status = HttpStatus.BAD_REQUEST;
//
//    var error = new ErrorResponse(status.value(), exception.getMessage());
//
//    return ResponseEntity.status(status).body(error);
//  }
//
//  /**
//   * Maneja errores de tipo de dato en argumentos (Type Mismatch).
//   * Se lanza cuando se intenta convertir un valor de la URL (Path o Query
//   * Variable)
//   * a un tipo de Java incompatible (ej: enviar texto "abc" donde se espera un
//   * Integer).
//   *
//   * @param exception La excepción de desajuste de tipos
//   * @param request   La solicitud HTTP actual
//   * @return ResponseEntity con error 400 indicando qué parámetro tiene el tipo
//   *   incorrecto
//   */
//  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//  public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(
//      MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
//
//    log.error("[MethodArgumentTypeMismatchException] occurred", exception);
//
//    var status = HttpStatus.BAD_REQUEST;
//
//    var error = new ErrorResponse(status.value(), exception.getMessage());
//
//    return ResponseEntity.status(status).body(error);
//  }
//
//  /**
//   * Maneja errores de lectura del cuerpo de la solicitud (JSON mal formado).
//   * Se lanza cuando Jackson no puede parsear el JSON de entrada (sintaxis
//   * inválida,
//   * comas faltantes, tipos de datos incompatibles en el JSON, etc.).
//   *
//   * @param exception La excepción de mensaje no legible
//   * @param request   La solicitud HTTP actual
//   * @return ResponseEntity con error 400 indicando JSON mal formado
//   */
//  @ExceptionHandler(HttpMessageNotReadableException.class)
//  public ResponseEntity<ErrorResponse> httpMessageNotReadableException(
//      HttpMessageNotReadableException exception, HttpServletRequest request) {
//
//    log.error("[HttpMessageNotReadableException] occurred", exception);
//
//    var status = HttpStatus.BAD_REQUEST;
//
//    var error = new ErrorResponse(status.value(), exception.getMessage());
//
//    return ResponseEntity.status(status).body(error);
//  }

}
