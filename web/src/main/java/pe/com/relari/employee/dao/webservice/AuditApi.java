//package pe.com.relari.employee.dao.webservice;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import pe.com.relari.employee.dao.webservice.model.AuditRequest;
//
//@FeignClient(
//        name = "audit-api",
//        url = "${application.http-client.audit.base-url}"
//)
//public interface AuditApi {
//
//    @PostMapping("srv/neg/v1/audit-configuration")
//    void saveAudit(@RequestBody AuditRequest request);
//
//}
