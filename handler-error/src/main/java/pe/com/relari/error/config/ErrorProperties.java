package pe.com.relari.error.config;

import jakarta.validation.constraints.NotNull;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pe.com.relari.error.model.ErrorCategory;
import pe.com.relari.error.model.ErrorResponse;
import pe.com.relari.error.model.ErrorStatus;

import static pe.com.relari.commons.constant.Constants.EMPTY;

/**
 * <b>Class:</b> ApplicationProperties.<br>
 *
 * @author Relari.
 */

@Data
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application.errors")
public class ErrorProperties {


    private String code;
    private String defaultCode;
    @NotNull(message = "Status cannot be null")
    private Map<String, ErrorStatus> status;
    @NotNull(message = "Categories cannot be null")
    private Map<String, ErrorCategory> categories;

    public ErrorResponse getErrorByCategoryCode(String categoryCode) {
        ErrorCategory category = this.categories.get(categoryCode);
        ErrorStatus errorStatus = this.status.get(category.getStatusCode());
        return ErrorResponse.builder()
                .code(category.getCode())
                .status(errorStatus.getStatus())
                .description(getDefaultErrorDescription(
                        errorStatus.getDescription(), category.getDescription()
                ))
                .build();
    }

    public ErrorResponse getErrorByStatusCode(String statusCode) {
        ErrorStatus errorStatus = this.status.get(statusCode);
        return ErrorResponse.builder()
                .code(String.format("%s%s",code, errorStatus.getStatus()))
                .status(errorStatus.getStatus())
                .description(getDefaultErrorDescription(
                        errorStatus.getDescription(), EMPTY
                ))
                .build();
    }

    public String getDefaultErrorDescription(String description, String customDescription) {
        return (customDescription != null && !customDescription.isEmpty()) ? customDescription : description;
    }

}
