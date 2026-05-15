package pe.com.relari.employee.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.relari.employee.dao.EmployeeDao;
import pe.com.relari.employee.exception.ApiException;
import pe.com.relari.employee.exception.ErrorCategory;
import pe.com.relari.employee.model.domain.Employee;
import pe.com.relari.employee.service.EmployeeService;
import pe.com.relari.employee.util.Constants;

/**
 * Class: EmployeeServiceImpl.
 * 
 * @author Relari
 */

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public List<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public void save(Employee employee) {
    var response = employeeDao.findByDocument(employee.getDocument());
    if (response.isPresent()) {
      throw ApiException.of(ErrorCategory.DOCUMENT_REGISTERED);
    }
    employeeDao.save(employee);
  }

  @Override
  public void deleteAll() {
    employeeDao.deleteAll();
  }

  @Override
  public void deleteById(Integer id) {

    var employee = employeeDao.findById(id);
    if (employee != null) {
      employeeDao.deleteById(id);
    }

  }

  @Override
  public Employee findById(Integer id) {
    return employeeDao.findById(id);
  }

  @Override
  public void inactivateById(Integer id) {
    var employee = employeeDao.findById(id);

    if (Constants.ACTIVE.equals(employee.getStatus())) {
      employee.setStatus(Constants.INACTIVE);
      employeeDao.save(employee);
    } else {
      throw ApiException.of(ErrorCategory.EMPLOYEE_INACTIVATED);
    }
  }

  @Override
  public void activateById(Integer id) {
    var employee = employeeDao.findById(id);
    if (Constants.INACTIVE.equals(employee.getStatus())) {
      employee.setStatus(Constants.ACTIVE);
      employeeDao.save(employee);
    } else {
      throw ApiException.of(ErrorCategory.EMPLOYEE_ACTIVATED);
    }
  }

}
