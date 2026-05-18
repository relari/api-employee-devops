package pe.com.relari.audit.dao;

import pe.com.relari.audit.model.domain.AuditValues;

public interface AuditDao {

    void save(AuditValues auditValues);

}
