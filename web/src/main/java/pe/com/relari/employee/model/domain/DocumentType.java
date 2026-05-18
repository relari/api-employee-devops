package pe.com.relari.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {

    DNI("Documento Nacional de Identidad"),
    PASAPORTE("Pasaporte Extranjero"),
    RUC("Registro Único de Contribuyentes");

    private final String description;

}
