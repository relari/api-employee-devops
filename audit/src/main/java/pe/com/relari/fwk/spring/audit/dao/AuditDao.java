package pe.com.relari.fwk.spring.audit.dao;

import pe.com.relari.fwk.spring.audit.model.domain.AuditValues;

public interface AuditDao {

    void save(AuditValues auditValues);

}
