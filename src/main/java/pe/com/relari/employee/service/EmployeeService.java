package pe.com.relari.employee.service;

import java.util.List;
import pe.com.relari.employee.model.domain.Employee;

/**
 * Interface: EmployeeService.
 * 
 * @author Relari
 */
public interface EmployeeService {

  List<Employee> findAll();

  void save(Employee employee);

  void deleteAll();

  void deleteById(Integer id);

  Employee findById(Integer id);

  void inactivateById(Integer id);

  void activateById(Integer id);
}
