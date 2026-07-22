package pe.com.relari.employee.util;

import pe.com.relari.commons.constant.Constants;
import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.employee.model.api.AddressRequest;
import pe.com.relari.employee.model.api.CompanyRequest;
import pe.com.relari.employee.model.api.DocumentRequest;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.domain.Address;
import pe.com.relari.employee.model.domain.Company;
import pe.com.relari.employee.model.domain.Document;
import pe.com.relari.employee.model.domain.DocumentType;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.model.domain.Gender;
import pe.com.relari.employee.model.domain.JobTitle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataMocks {

    private DataMocks() {}

    public static Employee buildEmployee() {
        return Employee.builder()
                .idEmployee(1)
                .document(Document.of(DocumentType.DNI, "123456789"))
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender(Gender.M)
                .dateOfBirth(LocalDate.now())
                .company(Company.of(JobTitle.DEVELOPER, 2500.00))
                .address(Address.of("email@mail.com", "999000999"))
                .createdAt(LocalDateTime.now())
                .status(Constants.ACTIVE)
                .build();
    }

    public static EmployeeRequest buildEmployeeRequest() {
        return EmployeeRequest.builder()
                .document(new DocumentRequest("DNI", "123456789"))
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender("M")
                .dateOfBirth("03/05/1995")
                .company(new CompanyRequest("DEVELOPER", 2500.00))
                .address(new AddressRequest("email@mail.com", "999000999"))
                .build();
    }

    public static EmployeeEntity buildEmployeeEntity() {
        return EmployeeEntity.builder()
                .id(1)
                .documentType(DocumentType.DNI)
                .documentNumber("123456789")
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .gender(Gender.M)
                .jobTitle(JobTitle.DEVELOPER)
                .salary(2500.00)
                .email("email@mail.com")
                .phoneNumber("999000999")
                .createdAt(LocalDateTime.now())
                .status(Constants.ACTIVE)
                .build();
    }
}
