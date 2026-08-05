package pe.com.relari.fwk.spring.support.model;

import static pe.com.relari.commons.constant.Constants.SUCCESS_CODE;
import static pe.com.relari.commons.constant.Constants.SUCCESS_STATUS;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;

/**
 * Class: EmployeeDetailResponse.
 * @author Relari
 */

public record ApiResponse<T> (
		@Schema(
				description = "Codigo HTTP.",
				name = "code",
				implementation = String.class,
				example = "OK")
		String code,
		@Schema(
				description = "Estatus HTTP.",
				name = "status",
				implementation = Integer.class,
				example = "200")
		Integer status,
		@Schema(
				description = "Data de respuesta.",
				name = "data")
		T data
) {

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(
				SUCCESS_CODE, SUCCESS_STATUS, data
		);
	}

	public ResponseEntity<ApiResponse<T>> toResponse() {
		var entity = success(this.data());
		return ResponseEntity.status(entity.status()).body(entity);
	}
}
