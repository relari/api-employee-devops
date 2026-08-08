package pe.com.relari.fwk.spring.web.employee.service;

import java.util.List;
import pe.com.relari.fwk.spring.web.employee.model.domain.Employee;

/**
 * <b>Interface:</b> EmployeeService.<br>
 * 
 * @author Relari.
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
