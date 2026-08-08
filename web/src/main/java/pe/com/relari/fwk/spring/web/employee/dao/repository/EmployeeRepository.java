package pe.com.relari.fwk.spring.web.employee.dao.repository;

import pe.com.relari.fwk.spring.web.employee.dao.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.relari.fwk.spring.web.employee.model.domain.DocumentType;

import java.util.Optional;

/**
 * <b>Interface:</b> EmployeeRepository.<br>
 *
 * @author Relari
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

  Optional<EmployeeEntity> findByDocumentTypeAndDocumentNumber(
      DocumentType documentType, String documentNumber
  );

}
