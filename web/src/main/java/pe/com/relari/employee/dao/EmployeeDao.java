package pe.com.relari.employee.dao;

import pe.com.relari.employee.model.domain.Document;
import pe.com.relari.employee.model.domain.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Interface: EmployeeDao.
 * 
 * @author Relari
 */
public interface EmployeeDao {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteAll();

    void deleteById(Integer id);

    Employee findById(Integer id);

    Optional<Employee> findByDocument(Document document);

}
