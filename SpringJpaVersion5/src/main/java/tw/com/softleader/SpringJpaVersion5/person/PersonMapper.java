package tw.com.softleader.SpringJpaVersion5.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person fromDTO (PersonDTO personDTO);

    PersonDTO toDTO (Person person);


}
