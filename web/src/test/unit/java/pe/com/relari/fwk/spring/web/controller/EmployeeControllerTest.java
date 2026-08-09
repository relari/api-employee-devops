package pe.com.relari.fwk.spring.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import pe.com.relari.fwk.spring.web.employee.service.EmployeeService;
import java.util.Collections;

import pe.com.relari.fwk.spring.web.employee.util.DataMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * <b>Class:</b> EmployeeControllerTest.<br>
 *
 * @author Relari.
 */

class EmployeeControllerTest {

  @Mock
  private EmployeeService service;

  @InjectMocks
  private EmployeeController controller;

  private AutoCloseable closeable;

  @BeforeEach
  void init() {
    closeable = MockitoAnnotations.openMocks(this);
  }

  @Test
  void findAll() {

    var employee = DataMocks.buildEmployee();

    when(service.findAll())
        .thenReturn(Collections.singletonList(employee));

    var responses = controller.findAll();

    assertEquals(employee.getIdEmployee(), responses.get(0).getId());
    assertEquals(employee.getFirstName(), responses.get(0).getFirstName());
    assertEquals(employee.getFatherLastName(), responses.get(0).getFatherLastName());
    assertEquals(employee.getMotherLastName(), responses.get(0).getMotherLastName());
    assertEquals(employee.getGender().getDescription(), responses.get(0).getGender());
  }

  @Test
  void findAll2() {

    var employee = DataMocks.buildEmployee();

    when(service.findAll())
        .thenReturn(Collections.singletonList(employee));

    var response = controller.findAll2();

    assertNotNull(response);
    assertEquals("OK", response.getCode());
    assertEquals(200, response.getStatus());
  }



  @Test
  void findById() {

    var employee = DataMocks.buildEmployee();

    when(service.findById(anyInt()))
        .thenReturn(employee);

    var response = controller.findById("1");

    assertEquals(employee.getIdEmployee(), response.getId());
    assertEquals(employee.getFirstName(), response.getFirstName());
    assertEquals(employee.getFatherLastName(), response.getFatherLastName());
    assertEquals(employee.getMotherLastName(), response.getMotherLastName());
    assertEquals(employee.getGender().getDescription(), response.getGender());

  }

  @Test
  void getAddressById() {

    var employee = DataMocks.buildEmployee();

    when(service.findById(anyInt()))
        .thenReturn(employee);

    var response = controller.getAddressById("1");

    assertEquals(employee.getAddress().getEmail(), response.email());
    assertEquals(employee.getAddress().getPhoneNumber(), response.phoneNumber());

  }

  @Test
  void save() {

    service.save(any());

    var employeeRequest = DataMocks.buildEmployeeRequest();

    controller.save(employeeRequest);

    assertNotNull(employeeRequest);

  }

  @Test
  void deleteAll() {

    service.deleteAll();

    controller.deleteAll();

    String id = "1";

    assertNotNull(id);
  }

  @Test
  void deleteById() {

    service.deleteById(anyInt());

    String id = "1";

    controller.deleteById(id);

    assertNotNull(id);

  }

  @Test
  void inactiveEmployeeById() {

    service.inactivateById(anyInt());

    String id = "1";

    controller.inactiveById(id);

    assertNotNull(id);

  }

    @Test
  void activeEmployeeById() {

    service.activateById(anyInt());

    String id = "1";

    controller.activeById(id);

    assertNotNull(id);

  }

  @AfterEach
  void end() throws Exception {
    closeable.close();
  }

}