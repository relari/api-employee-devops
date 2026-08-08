package pe.com.relari.fwk.spring.web.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.relari.commons.exception.ApiException;
import pe.com.relari.fwk.spring.web.employee.dao.EmployeeDao;
import pe.com.relari.fwk.spring.web.employee.service.impl.EmployeeServiceImpl;
import pe.com.relari.commons.constant.Constants;
import pe.com.relari.fwk.spring.web.employee.util.DataMocks;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

/**
 * <b>Class:</b> EmployeeServiceImplTest.<br>
 *
 * @author Relari.
 */

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

  @Mock
  private EmployeeDao employeeDao;

  @InjectMocks
  private EmployeeServiceImpl employeeService;

  @Test
  void findAll() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findAll())
        .thenReturn(Collections.singletonList(employee));

    var employees = employeeService.findAll();

    assertEquals(employee.getFirstName(), employees.get(0).getFirstName());
    assertEquals(employee.getFatherLastName(), employees.get(0).getFatherLastName());
    assertEquals(employee.getMotherLastName(), employees.get(0).getMotherLastName());
    assertEquals(employee.getGender(), employees.get(0).getGender());

  }

  @Test
  void deleteAll() {

    var employee = DataMocks.buildEmployee();

    employeeDao.deleteAll();

    employeeService.deleteAll();

    assertNotNull(employee);

  }

  @Test
  void deleteById_success() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    employeeDao.deleteById(Mockito.anyInt());

    employeeService.deleteById(employee.getIdEmployee());

    assertNotNull(employee);
  }

  @Test
  void deleteById_failed() {


    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(null);

    Integer id = 1;

    employeeService.deleteById(id);

    assertNotNull(id);
  }

  @Test
  void findById() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    var response = employeeService.findById(1);

    assertEquals(employee.getFirstName(), response.getFirstName());
    assertEquals(employee.getFatherLastName(), response.getFatherLastName());
    assertEquals(employee.getMotherLastName(), response.getMotherLastName());
    assertEquals(employee.getGender(), response.getGender());

  }

  @Test
  void save_success() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findByDocument(Mockito.any()))
        .thenReturn(Optional.empty());

    employeeDao.save(Mockito.any());

    employeeService.save(employee);

    assertNotNull(employee);
  }

  @Test
  void save_failed() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findByDocument(Mockito.any()))
        .thenReturn(Optional.of(employee));

    ApiException apiException = Assertions.assertThrows(
        ApiException.class, () -> employeeService.save(employee)
    );

    assertNotNull(apiException.getMessage());
  }

  @Test
  void inactive_success() {

    var employee = DataMocks.buildEmployee();

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    employeeDao.save(Mockito.any());

    employeeService.inactivateById(employee.getIdEmployee());

    assertNotNull(employee);
  }

  @Test
  void inactive_error() {

    var employee = DataMocks.buildEmployee();
    employee.setStatus(Constants.INACTIVE);

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    Integer id = employee.getIdEmployee();

    ApiException apiException = Assertions.assertThrows(ApiException.class, () -> employeeService.inactivateById(id));

    assertNotNull(apiException.getMessage());
  }

  @Test
  void active_success() {

    var employee = DataMocks.buildEmployee();
    employee.setStatus(Constants.INACTIVE);

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    employeeDao.save(Mockito.any());

    employeeService.activateById(employee.getIdEmployee());

    assertNotNull(employee);
  }

  @Test
  void active_error() {

    var employee = DataMocks.buildEmployee();
    employee.setStatus(Constants.ACTIVE);

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(employee);

    Integer id = employee.getIdEmployee();

    ApiException apiException = Assertions.assertThrows(ApiException.class, () -> employeeService.activateById(id));

    assertNotNull(apiException.getMessage());
  }

}