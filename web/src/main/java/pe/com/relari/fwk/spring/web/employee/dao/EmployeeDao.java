package pe.com.relari.fwk.spring.web.employee.dao;

import pe.com.relari.fwk.spring.web.employee.model.domain.Document;
import pe.com.relari.fwk.spring.web.employee.model.domain.Employee;

import java.util.List;
import java.util.Optional;

/**
 * <b>Interface:</b> EmployeeDao.<br>
 * 
 * @author Relari.
 */
public interface EmployeeDao {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteAll();

    void deleteById(Integer id);

    Employee findById(Integer id);

    Optional<Employee> findByDocument(Document document);

}
