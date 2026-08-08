//package pe.com.relari.employee.dao.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import pe.com.relari.config.ApplicationProperties;
//import pe.com.relari.employee.dao.AuditDao;
//import pe.com.relari.employee.dao.webservice.AuditApi;
//import pe.com.relari.employee.dao.webservice.model.ApplicationRequest;
//import pe.com.relari.employee.dao.webservice.model.AuditRequest;
//import pe.com.relari.employee.dao.webservice.model.OperationRequest;
//import pe.com.relari.employee.dao.webservice.model.UserRequest;
//import pe.com.relari.employee.headers.HeaderService;
//import pe.com.relari.employee.model.example.AuditValues;
//import pe.com.relari.employee.util.Constants;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class AuditDaoImpl implements AuditDao {
//
//    @Value("${spring.application.name}")
//    private String applicationName;
//
//    private final ApplicationProperties applicationProperties;
//    private final AuditApi auditApi;
//    private final HeaderService headerService;
//
//    @Override
//    public void save(AuditValues auditValues) {
//        var auditRequest = AuditRequest.builder()
//                .application(new ApplicationRequest(applicationName, applicationProperties.getInfo().getVersion()))
//                .user(new UserRequest(
//                        headerService.getHeaderValue(Constants.HEADER_USER_ID),
//                        headerService.getHeaderValue(Constants.HEADER_X_FORWARDED_FOR)
//                ))
//                .operation(OperationRequest.builder()
//                        .trace(auditValues.getTrace())
//                        .type(auditValues.getType().getValue())
//                        .action(auditValues.getAction())
//                        .status(auditValues.getStatus().getValue())
//                        .statusCode(auditValues.getStatusCode())
//                        .message(auditValues.getMessage())
//                        .timestamp(LocalDateTime.now().toString())
//                        .requestId(headerService.getHeaderValue(Constants.HEADER_REQUEST_ID))
//                        .sessionId(headerService.getHeaderValue(Constants.HEADER_SESSION_ID))
//                        .build())
//                .build();
//        auditApi.saveAudit(auditRequest);
//    }
//}
