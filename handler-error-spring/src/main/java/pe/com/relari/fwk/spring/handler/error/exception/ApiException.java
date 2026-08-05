package pe.com.relari.fwk.spring.handler.error.exception;

/**
 * <b>Class:</b> ApiException.<br>
 * Excepción personalizada para manejar errores controlados de la aplicación.
 *
 * Proporciona múltiples constructores para flexibilidad:
 * - Con ErrorCatalog (errores específicos de negocio)
 * - Con HttpErrorCode (errores HTTP genéricos)
 * - Con mensajes personalizados
 * - Con causes/Throwables para debugging
 *
 * @author Relari
 */

public class ApiException extends RuntimeException {

    public ApiException(String code) {
        super(code);
    }

    public ApiException(String code, Throwable cause) {
        super(code, cause);
    }

}
