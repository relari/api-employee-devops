package pe.com.relari.fwk.spring.support.util;

import org.springframework.http.ResponseEntity;
import pe.com.relari.commons.model.api.ApiResponse;
import pe.com.relari.commons.model.error.ErrorResponse;

/**
 * <b>Class:</b> ResponseUtils.<br>
 *
 * @author Relari.
 */

public class ResponseUtils extends ApiResponse<Object> {

  private ResponseUtils() {}

  public static <T> ResponseEntity<ApiResponse<T>> toOkResponse(T data) {
    if (data == null) {
      return ResponseEntity.noContent().build();
    }
    var apiResponse = success(data);
    return ResponseEntity.status(apiResponse.getStatus())
            .body(apiResponse);
  }

  public static ResponseEntity<ErrorResponse> toErrorResponse(ErrorResponse errorResponse) {
    return ResponseEntity.status(errorResponse.getStatus())
            .body(errorResponse);
  }

}