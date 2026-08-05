package pe.com.relari.controller;

import lombok.RequiredArgsConstructor;
import pe.com.relari.controller.mapper.DomainToDtoMapper;
import pe.com.relari.employee.model.api.AddressResponse;
import pe.com.relari.fwk.spring.support.model.ApiResponse;
import pe.com.relari.employee.service.EmployeeService;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.model.api.EmployeeResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class: EmployeeController.
 * @author Relari
 */

@Tag(name = "Employee", description = "Employee Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Employee API",
                version = "${application.info.version}",
                description = "${application.info.description}")
)
@RestController
@RequestMapping(path = "${application.api.path}")
@RequiredArgsConstructor
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    @GetMapping
    @Override
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll()
                .stream()
                .map(DomainToDtoMapper.INSTANCE::mapEmployeeResponse)
                .toList();
    }

    @GetMapping(path = "/all")
    @Override
    public ApiResponse<List<EmployeeResponse>> findAll2() {
        return DomainToDtoMapper.INSTANCE.mapResponse(employeeService.findAll());
    }

    @Override
    public EmployeeResponse findById(String id) {
        return DomainToDtoMapper.INSTANCE.mapEmployeeResponse(
                employeeService.findById(Integer.valueOf(id))
        );
    }

    @Override
    public AddressResponse getAddressById(String id) {
        var address = employeeService.findById(Integer.valueOf(id)).getAddress();
        return new AddressResponse(address.getEmail(), address.getPhoneNumber());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Override
    public void save(EmployeeRequest employeeRequest) {
        var employeeEntity = DomainToDtoMapper.INSTANCE.mapEmployee(employeeRequest);
        employeeService.save(employeeEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @Override
    public void deleteAll() {
        employeeService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteById(String id) {
        employeeService.deleteById(Integer.valueOf(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void inactiveById(String id) {
        employeeService.inactivateById(Integer.valueOf(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void activeById(String id) {
        employeeService.activateById(Integer.valueOf(id));
    }

}
