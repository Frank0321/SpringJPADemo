package tw.com.softleader.SpringJpaVersion5.Composite;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import tw.com.softleader.SpringJpaVersion5.country.Country;
import tw.com.softleader.SpringJpaVersion5.person.Person;

@Mapper
public interface CompositeMapper {
    CompositeMapper INSTANCE = Mappers.getMapper(CompositeMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "country.id"),
            @Mapping(target = "code", source = "country.code"),
            @Mapping(target = "firstName", source = "person.firstName"),
            @Mapping(target = "lastName", source = "person.lastName"),
    })
    CompositeDTO toDTO (Country country, Person person);
}
