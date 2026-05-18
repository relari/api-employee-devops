package pe.com.relari.employee.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.employee.model.domain.Employee;

@Mapper
public interface DomainToEntityMapper {

    DomainToEntityMapper INSTANCE = Mappers.getMapper(DomainToEntityMapper.class);

    @Mapping(source = "idEmployee", target = "id")
    @Mapping(source = "document.type", target = "documentType")
    @Mapping(source = "document.number", target = "documentNumber")
    @Mapping(source = "address.email", target = "email")
    @Mapping(source = "address.phoneNumber", target = "phoneNumber")
    @Mapping(source = "company.jobTitle", target = "jobTitle")
    @Mapping(source = "company.salary", target = "salary")
    EmployeeEntity mapEmployeeEntity(Employee employee);

    @Mapping(source = "id", target = "idEmployee")
    @Mapping(source = "documentType", target = "document.type")
    @Mapping(source = "documentNumber", target = "document.number")
    @Mapping(source = "email", target = "address.email")
    @Mapping(source = "phoneNumber", target = "address.phoneNumber")
    @Mapping(source = "jobTitle", target = "company.jobTitle")
    @Mapping(source = "salary", target = "company.salary")
    Employee mapEmployee(EmployeeEntity employeeEntity);

}
