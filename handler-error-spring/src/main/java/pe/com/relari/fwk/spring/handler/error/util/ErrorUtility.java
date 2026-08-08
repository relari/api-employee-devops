package pe.com.relari.fwk.spring.handler.error.util;

import org.springframework.http.ResponseEntity;
import pe.com.relari.commons.model.error.ErrorResponse;

public class ErrorUtility {

  private ErrorUtility() {}

  public static ResponseEntity<ErrorResponse> getErrorResponseEntity(ErrorResponse errorResponse) {
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }

}