package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class:</b> Document.<br>
 *
 * @author Relari.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Document {

    private DocumentType type;
    private String number;

}
