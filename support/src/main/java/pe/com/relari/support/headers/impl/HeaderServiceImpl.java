package pe.com.relari.support.headers.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pe.com.relari.support.headers.HeaderService;
import pe.com.relari.support.headers.HeaderValues;
//import pe.com.relari.employee.headers.HeaderService;
//import pe.com.relari.employee.headers.HeaderValues;

/**
 * Class: HeaderServiceImpl.
 *
 * @author Relari
 */

@Service
@RequestScope // <--- Clave: Crea una instancia por cada petición HTTP
public class HeaderServiceImpl implements HeaderService {

  private final Map<String, String> headerValuesMap = new HashMap<>();

  @Override
  public void setHeaderValues(List<HeaderValues> headerValues) {
    headerValues.forEach(hv -> headerValuesMap.put(hv.code(), hv.value()));
  }

  @Override
  public Map<String, String> getHeaderValues() {
    return Collections.unmodifiableMap(headerValuesMap);
  }

  @Override
  public String getHeaderValue(String code) {
    return headerValuesMap.get(code);
  }

}