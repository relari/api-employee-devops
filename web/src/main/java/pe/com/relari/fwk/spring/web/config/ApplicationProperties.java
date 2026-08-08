package pe.com.relari.fwk.spring.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * <b>Class:</b> ApplicationProperties.</br>
 *
 * @author Relari.
 */

@Data
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {


}
