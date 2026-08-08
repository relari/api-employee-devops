package pe.com.relari.fwk.spring.reactive.handler.error.handler;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebInputException;
import pe.com.relari.fwk.spring.reactive.handler.error.config.ErrorConfig;
import pe.com.relari.commons.exception.ApiException;
import pe.com.relari.commons.model.error.ErrorResponse;
import pe.com.relari.commons.model.error.ValidationError;


/**
 * <b>Class:</b> GlobalExceptionHandler.<br>
 *
 * @author Relari.
 */

@Slf4j
@Getter
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

  @Value("${spring.application.name}")
  private String applicationName;

  private final ErrorConfig errorConfig;

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ErrorResponse> apiException(
          ApiException apiException) {
    return errorConfig.getErrorByCategoryCode(apiException.getMessage(), apiException.getCause());
  }

  /**
   * Maneja cualquier excepción no controlada (Exception).
   * Se lanza ante errores inesperados del sistema (NullPointerException, fallos
   * de BD no controlados, etc.).
   * Actúa como un "catch-all" para evitar que el cliente reciba un stacktrace completo.
   * En desarrollo, incluye el stack trace para debugging.
   *
   * @param exception La excepción inesperada
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 500 Internal Server Error
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(
          Exception exception, ServerWebExchange request) {

    log.error("Unexpected error occurred", exception);
    return errorConfig.getErrorByStatusCode("INTERNAL_SERVER_ERROR", exception.getCause());
  }

  /**
   * Maneja excepciones de validación de argumentos (@Valid).
   * Se lanza cuando el cuerpo de la solicitud (Body) falla las validaciones de
   * las anotaciones
   * (ej: @NotNull, @Email, @Size) en el DTO de entrada.
   *
   * @param exception La excepción con los resultados de la validación
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 400 y la lista detallada de campos inválidos
   */
  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<ErrorResponse> methodArgumentNotValidException(
          WebExchangeBindException exception, ServerWebExchange request) {

    log.error("[MethodArgumentNotValidException] occurred", exception);

    List<ValidationError> errorDetails = exception.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> new ValidationError(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()))
            .toList();

    return errorConfig.getErrorByStatusCode("BAD_REQUEST", errorDetails, exception.getCause());
  }

  /**
   * Maneja la ausencia de parámetros requeridos (@RequestParam).
   * Se lanza cuando un endpoint espera un parámetro obligatorio en la URL (Query
   * Param)
   * y este no es proporcionado por el cliente.
   *
   * @param exception La excepción que indica qué parámetro falta
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 400 indicando el parámetro faltante
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponse> missingServletRequestParameterException(
          MissingServletRequestParameterException exception, ServerWebExchange request) {

    log.error("[MissingServletRequestParameterException] occurred", exception);

    return errorConfig.getErrorByStatusCode("BAD_REQUEST", exception.getCause());
  }

  /**
   * Maneja errores de tipo de dato en argumentos (Type Mismatch).
   * Se lanza cuando se intenta convertir un valor de la URL (Path o Query
   * Variable)
   * a un tipo de Java incompatible (ej: enviar texto "abc" donde se espera un
   * Integer).
   *
   * @param exception La excepción de desajuste de tipos
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 400 indicando qué parámetro tiene el tipo
   *   incorrecto
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(
          MethodArgumentTypeMismatchException exception, ServerWebExchange request) {

    log.error("[MethodArgumentTypeMismatchException] occurred", exception);

    return errorConfig.getErrorByStatusCode("BAD_REQUEST", exception.getCause());
  }

  /**
   * Maneja errores de decodificación de datos (DecodingException).
   *
   * @param exception La excepción de desajuste de tipos
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 400 indicando qué parámetro tiene el tipo
   *   incorrecto
   */
  @ExceptionHandler(DecodingException.class)
  public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(
          DecodingException exception, ServerWebExchange request) {

    log.error("[MethodArgumentTypeMismatchException] occurred", exception);

    return errorConfig.getErrorByStatusCode("BAD_REQUEST", exception.getCause());
  }

  /**
   * Maneja errores de lectura del cuerpo de la solicitud (JSON mal formado).
   * Se lanza cuando Jackson no puede parsear el JSON de entrada (sintaxis
   * inválida,
   * comas faltantes, tipos de datos incompatibles en el JSON, etc.).
   *
   * @param exception La excepción de mensaje no legible
   * @param request   La solicitud HTTP actual
   * @return ResponseEntity con error 400 indicando JSON mal formado
   */
  @ExceptionHandler(ServerWebInputException.class)
  public ResponseEntity<ErrorResponse> httpMessageNotReadableException(
          ServerWebInputException exception, ServerWebExchange request) {

    log.error("[HttpMessageNotReadableException] occurred", exception);

    return errorConfig.getErrorByStatusCode("BAD_REQUEST", exception.getCause());
  }

}
