package pe.com.relari.fwk.spring.handler.error.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pe.com.relari.commons.model.error.ErrorResponse;
import pe.com.relari.fwk.spring.handler.error.util.ErrorUtility;

import java.time.Clock;
import java.time.LocalDateTime;

/**
 * <b>Class:</b> ErrorConfig.<br>
 *
 * @author Relari.
 */

@Component
@RequiredArgsConstructor
public class ErrorConfig {

  @Value("${spring.application.name}")
  private String applicationName;

  @Value("${spring.profiles.active}")
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

  public ResponseEntity<ErrorResponse> getErrorByCategoryCode(String categoryCode, Throwable throwable) {
    ErrorResponse errorResponse = errorProperties.getErrorByCategoryCode(categoryCode);
    errorResponse.setTimestamp(LocalDateTime.now(Clock.systemDefaultZone()).toString());
    if (shouldIncludeStackTrace()) {
      errorResponse.setThrowable(throwable);
    }
    return ErrorUtility.getErrorResponseEntity(errorResponse);
  }

  public ResponseEntity<ErrorResponse> getErrorByStatusCode(String statusCode, Throwable throwable) {
    ErrorResponse errorResponse = errorProperties.getErrorByStatusCode(statusCode);
    errorResponse.setTimestamp(LocalDateTime.now(Clock.systemDefaultZone()).toString());
    if (shouldIncludeStackTrace()) {
      errorResponse.setThrowable(throwable);
    }
    return ErrorUtility.getErrorResponseEntity(errorResponse);
  }

  public ResponseEntity<ErrorResponse> getErrorByStatusCode(String statusCode, Object details, Throwable throwable) {
    ErrorResponse errorResponse = errorProperties.getErrorByStatusCode(statusCode);
    errorResponse.setTimestamp(LocalDateTime.now(Clock.systemDefaultZone()).toString());
    if (shouldIncludeStackTrace()) {
      errorResponse.setThrowable(throwable);
    }
    if (details != null) {
      errorResponse.setDetails(details);
    }
    return ErrorUtility.getErrorResponseEntity(errorResponse);
  }
}
