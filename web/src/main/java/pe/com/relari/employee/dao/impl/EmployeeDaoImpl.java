package pe.com.relari.employee.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.dao.mapper.DomainToEntityMapper;
import pe.com.relari.employee.dao.repository.EmployeeRepository;
import pe.com.relari.error.exception.ApiException;
import pe.com.relari.error.category.ErrorCatalog;
import pe.com.relari.employee.model.domain.Document;
import pe.com.relari.employee.model.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Class: EmployeeDaoImpl.
 * 
 * @author Relari
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        log.debug("Fetching all employees from the database.");
        return employeeRepository.findAll()
                .stream()
                .map(DomainToEntityMapper.INSTANCE::mapEmployee)
                .toList();
    }

    @Override
    public void save(Employee employee) {
        log.debug("Saving employee: {}", employee);
        Optional.of(employee)
                .map(DomainToEntityMapper.INSTANCE::mapEmployeeEntity)
                .map(employeeRepository::save)
                .ifPresent(savedEntity -> log.debug("Employee saved with ID: {}", savedEntity.getId()));

    }

    @Override
    public void deleteAll() {
        log.debug("Deleting all employees from the database.");
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        log.debug("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        log.debug("Finding employee with ID: {}", id);
        return employeeRepository.findById(id)
                .map(DomainToEntityMapper.INSTANCE::mapEmployee)
                .orElseThrow(() ->  new ApiException(ErrorCatalog.EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Optional<Employee> findByDocument(Document document) {
        log.debug("Finding employee with document: {} {}", document.getType(), document.getNumber());
        return employeeRepository.findByDocumentTypeAndDocumentNumber(document.getType(), document.getNumber())
                .map(DomainToEntityMapper.INSTANCE::mapEmployee);
    }

}
