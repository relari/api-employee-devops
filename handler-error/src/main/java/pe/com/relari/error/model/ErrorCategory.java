package pe.com.relari.error.model;

import lombok.Getter;
import lombok.Setter;

/**
 * <b>Class:</b> ErrorCategory.<br>
 *
 * @author Relari
 */

@Getter
@Setter
public class ErrorCategory {

  private String code;
  private String description;
  private String statusCode;

}

