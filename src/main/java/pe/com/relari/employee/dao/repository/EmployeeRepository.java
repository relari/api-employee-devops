package pe.com.relari.employee.dao.repository;

import pe.com.relari.employee.dao.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.relari.employee.model.domain.DocumentType;

import java.util.Optional;

/**
 * Interface: EmployeeRepository.
 *
 * @version 1.0.0
 * @author Relari
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

  Optional<EmployeeEntity> findByDocumentTypeAndDocumentNumber(
      DocumentType documentType, String documentNumber
  );

}
