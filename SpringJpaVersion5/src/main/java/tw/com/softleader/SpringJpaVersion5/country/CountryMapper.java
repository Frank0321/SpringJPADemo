package tw.com.softleader.SpringJpaVersion5.country;

import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;


@Mapper(componentModel = "spring")
public interface CountryMapper {

//    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "countryDTO.countryId"),
            @Mapping(target = "name", source = "countryDTO.countryName"),
            @Mapping(target = "code", source = "countryDTO.countryCode"),
            @Mapping(target = "area", source = "countryDTO.countryArea")
    })
    Country fromDTO(CountryDTO countryDTO);

    @Mappings({
            @Mapping(target = "countryId", source = "source.id"),
            @Mapping(target = "countryName", source = "source.name"),
            @Mapping(target = "countryCode", source = "source.code"),
            @Mapping(target = "countryArea", source = "source.area")
    })
    CountryDTO toDTO (Country source);

    Collection<CountryDTO> toDTOCollection (Collection<Country> countries);
}
