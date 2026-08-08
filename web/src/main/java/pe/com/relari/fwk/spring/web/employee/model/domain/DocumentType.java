package pe.com.relari.fwk.spring.web.employee.model.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <b>Enum:</b> DocumentType.<br>
 *
 * @author Relari.
 */

@Getter
@RequiredArgsConstructor
public enum DocumentType {

    DNI("Documento Nacional de Identidad"),
    PASAPORTE("Pasaporte Extranjero"),
    RUC("Registro Único de Contribuyentes");

    private final String description;

}
