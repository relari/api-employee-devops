package pe.com.relari.error.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>Enum:</b> HttpErrorCode.<br>
 * Define los códigos HTTP estándar con sus descripciones genéricas.
 * Estos códigos son reutilizables en toda la arquitectura de microservicios.
 *
 * @author Relari
 */

@Getter
@Setter
public class ErrorStatus {

  private Integer status;
  private String description;

}

