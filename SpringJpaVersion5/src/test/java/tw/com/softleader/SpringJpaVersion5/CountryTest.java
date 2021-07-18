package tw.com.softleader.SpringJpaVersion5;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tw.com.softleader.SpringJpaVersion5.country.Country;
import tw.com.softleader.SpringJpaVersion5.country.CountryDTO;
import tw.com.softleader.SpringJpaVersion5.country.CountryMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryTest {

    private static Stream<Arguments> provideArguments(){
        return Stream.of(
                Arguments.of(Country.builder()
                        .id(2)
                        .name("kevin")
                        .code("code")
                        .area("Taiwan")
                        .build())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void toDTOTest(Country country){
        CountryDTO countryDTO = CountryMapper.INSTANCE.toDTO(country);

        assertThat(countryDTO)
                .extracting(CountryDTO::getCountryId, CountryDTO::getCountryName, CountryDTO::getCountryCode, CountryDTO::getCountryArea)
                .containsExactly(country.getId(), country.getName(), country.getCode(), country.getArea());
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void toDTOs (Country country){
        List<CountryDTO> countryDTOList = (List<CountryDTO>) CountryMapper.INSTANCE.toDTOCollection(Collections.singletonList(country));

        assertThat(countryDTOList)
                .hasSize(1)
                .extracting(CountryDTO::getCountryId, CountryDTO::getCountryName, CountryDTO::getCountryCode, CountryDTO::getCountryArea)
                .containsExactly(Tuple.tuple(
                        country.getId(),
                        country.getName(),
                        country.getCode(),
                        country.getArea()
                ));

    }

}
