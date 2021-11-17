package tw.com.softleader.SpringJpaVersion5.employee;

import static org.mapstruct.CollectionMappingStrategy.TARGET_IMMUTABLE;
import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeDto fromEntity(EmployeeEntity entity);

}
