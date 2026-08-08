package pe.com.relari.fwk.spring.web.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.relari.commons.constant.Constants;
import pe.com.relari.commons.utility.DateUtility;
import pe.com.relari.fwk.spring.web.employee.model.api.EmployeeRequest;
import pe.com.relari.fwk.spring.web.employee.model.api.EmployeeResponse;
import pe.com.relari.fwk.spring.web.employee.model.domain.Employee;
import pe.com.relari.commons.model.api.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <b>Interface:</b> DomainToDtoMapper.<br>
 *
 * @author Relari.
 */

@Mapper(imports = { DateUtility.class, Constants.class, LocalDateTime.class })
public interface DomainToDtoMapper {

    DomainToDtoMapper INSTANCE = Mappers.getMapper(DomainToDtoMapper.class);

    @Mapping(target = "id", source = "idEmployee")
    @Mapping(target = "gender", expression = "java( employee.getGender().getDescription() )")
    @Mapping(target = "dateOfBirth", expression = "java( DateUtility.formatDate(employee.getDateOfBirth()) )")
    @Mapping(target = "company.jobTitle", expression = "java( company.getJobTitle().getDescription() )")
    EmployeeResponse mapEmployeeResponse(Employee employee);

    @Mapping(target = "idEmployee", ignore = true)
    @Mapping(target = "dateOfBirth", expression = "java( DateUtility.parseLocalDate(employeeRequest.getDateOfBirth()) )")
    @Mapping(target = "createdAt", expression = "java( LocalDateTime.now() )")
    @Mapping(target = "status", expression = "java( Constants.ACTIVE )")
    Employee mapEmployee(EmployeeRequest employeeRequest);

    default ApiResponse<List<EmployeeResponse>> mapResponse(List<Employee> employee) {
        return new ApiResponse<>(
                Constants.SUCCESS_CODE, Constants.SUCCESS_STATUS,
                employee.stream().map(this::mapEmployeeResponse).toList()
        );
    }

}