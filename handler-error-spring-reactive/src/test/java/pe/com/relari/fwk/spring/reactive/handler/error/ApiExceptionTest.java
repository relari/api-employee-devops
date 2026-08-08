//package pe.com.relari.error;
//
//import org.junit.jupiter.api.Test;
//import pe.com.relari.error.model.ErrorCategory;
//import pe.com.relari.error.exception.ApiException;
//import pe.com.relari.error.model.ErrorCatalog;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ApiExceptionTest {
//
//    @Test
//    void testCreateApiExceptionWithCategory() {
//        ErrorCatalog catalog = new ErrorCatalog(
//            "002",
//            "Empleado no encontrado.",
//            404
//        );
//
//        ApiException exception = new ApiException(
//            "El empleado con ID 1 no existe",
//            null,
//            ErrorCategory.EMPLOYEE_NOT_FOUND,
//            catalog,
//            "EM-002",
//            null,
//            Map.of(
//                "app_name", "employee-service",
//                "app_version", "1.0.0",
//                "environment", "dev",
//                "instance", "/api/employees/1"
//            )
//        );
//
//        assertNotNull(exception);
//        assertEquals("El empleado con ID 1 no existe", exception.getMessage());
//        assertEquals(ErrorCategory.EMPLOYEE_NOT_FOUND, exception.getCategoryName());
//        assertEquals("EM-002", exception.getCode());
//        assertEquals(404, exception.getStatus());
//    }
//
//    @Test
//    void testApiExceptionToErrorResponse() {
//        ErrorCatalog catalog = new ErrorCatalog(
//            "001",
//            "Error al guardar al empleado.",
//            500
//        );
//
//        ApiException exception = new ApiException(
//            "Error de integridad de datos",
//            null,
//            ErrorCategory.EMPLOYEE_SAVE_FAILED,
//            catalog,
//            "EM-001",
//            null,
//            null
//        );
//
//        var response = exception.toErrorResponse();
//
//        assertNotNull(response);
//        assertEquals("Error al guardar al empleado.", response.getDescription());
//        assertEquals("EM-001", response.getCode());
//        assertEquals(500, response.getStatus());
//        assertEquals(ErrorCategory.EMPLOYEE_SAVE_FAILED, response.getCatalog());
//    }
//
//}