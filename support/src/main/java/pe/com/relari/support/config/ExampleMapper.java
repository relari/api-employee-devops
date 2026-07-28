package pe.com.relari.support.config;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * <b>Interface:</b> StudentMapper.<br/>
 *
 * @author Relari
 * @version 1.0.0
 */

@Mapper
public interface ExampleMapper {

  @IterableMapping(qualifiedByName = "toData")
  List<DataResponse> mapDataResponses(List<DataRequest> dataRequests);

  @Named("toData")
  @Mapping(target = "status", constant = "true")
  @Mapping(target = "value", expression = "java( request.getFirst() + ' ' + request.getSecond() )")
  DataResponse toData(DataRequest request);

  @Mapping(target = "status", constant = "true")
  @Mapping(target = "value", source = "first", defaultValue = "First")
  DataResponse dataValidateDefaultValue(DataRequest request);

  @Mapping(target = "status", constant = "true")
  @Mapping(target = "value", source = "first", defaultExpression = "java(\"First\")")
  DataResponse dataValidateDefaultExpression(DataRequest request);

}
