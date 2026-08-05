package pe.com.relari.fwk.spring.support.headers;

import java.util.List;
import java.util.Map;

/**
 * interface: HeaderService.
 *
 * @author Relari
 */

public interface HeaderService {

  void setHeaderValues(List<HeaderValues> headerValues);
  Map<String, String> getHeaderValues();
  String getHeaderValue(String code);

}
