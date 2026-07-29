package pe.com.relari.error.util;

import org.springframework.http.ResponseEntity;
import pe.com.relari.error.exception.ApiException;
import pe.com.relari.error.model.ErrorResponse;

import java.time.Clock;
import java.time.LocalDateTime;

public class ErrorUtility {

    private ErrorUtility() {}


    public static ResponseEntity<ErrorResponse> getErrorResponseEntity(ErrorResponse errorResponse) {
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }

}