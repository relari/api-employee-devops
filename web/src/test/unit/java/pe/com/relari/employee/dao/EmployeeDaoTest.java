package pe.com.relari.employee.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.relari.employee.dao.impl.EmployeeDaoImpl;
import pe.com.relari.employee.dao.repository.EmployeeRepository;
import pe.com.relari.error.exception.ApiException;
import pe.com.relari.employee.util.DataMocks;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeDaoImpl employeeDao;

    @Test
    void findAll() {

        var employeeEntity = DataMocks.buildEmployeeEntity();

        Mockito.when(employeeRepository.findAll())
                .thenReturn(Collections.singletonList(employeeEntity));

        var employees = employeeDao.findAll();

        assertEquals(employeeEntity.getFirstName(), employees.get(0).getFirstName());
        assertEquals(employeeEntity.getFatherLastName(), employees.get(0).getFatherLastName());
        assertEquals(employeeEntity.getMotherLastName(), employees.get(0).getMotherLastName());
        assertEquals(employeeEntity.getGender(), employees.get(0).getGender());

    }

    @Test
    void deleteAll() {

        var employee = DataMocks.buildEmployeeEntity();

        employeeRepository.deleteAll();

        employeeDao.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        employeeRepository.deleteById(Mockito.anyInt());

        employeeDao.deleteById(id);

        assertNotNull(id);
    }

    @Test
    void findById() {

        var employeeEntity = DataMocks.buildEmployeeEntity();

        Mockito.when(employeeRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(employeeEntity));

        var employee = employeeDao.findById(1);

        assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
        assertEquals(employeeEntity.getFatherLastName(), employee.getFatherLastName());
        assertEquals(employeeEntity.getMotherLastName(), employee.getMotherLastName());
        assertEquals(employeeEntity.getGender(), employee.getGender());

    }

    @Test
    void findByIdError() {

        Mockito.when(employeeRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(ApiException.class, () -> employeeDao.findById(2));

    }

    @Test
    void save() {

        var employeeEntity = DataMocks.buildEmployeeEntity();

        Mockito.when(employeeRepository.save(Mockito.any()))
                .thenReturn(employeeEntity);

        var employee = DataMocks.buildEmployee();
        employeeDao.save(employee);

        assertEquals(employeeEntity.getFirstName(), employee.getFirstName());
        assertEquals(employeeEntity.getFatherLastName(), employee.getFatherLastName());
        assertEquals(employeeEntity.getMotherLastName(), employee.getMotherLastName());
        assertEquals(employeeEntity.getGender(), employee.getGender());

    }
}