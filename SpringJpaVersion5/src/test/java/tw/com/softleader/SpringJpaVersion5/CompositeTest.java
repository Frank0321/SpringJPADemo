package tw.com.softleader.SpringJpaVersion5;

import org.junit.jupiter.api.Test;
import tw.com.softleader.SpringJpaVersion5.Composite.CompositeDTO;
import tw.com.softleader.SpringJpaVersion5.Composite.CompositeMapper;
import tw.com.softleader.SpringJpaVersion5.country.Country;
import tw.com.softleader.SpringJpaVersion5.person.Gender;
import tw.com.softleader.SpringJpaVersion5.person.Person;

import static org.assertj.core.api.Assertions.assertThat;

public class CompositeTest {

    @Test
    void toDTOTest(){
        Person person = Person.builder()
                        .lastName("Rhys")
                        .firstName("li")
                        .age(35)
                        .gender(Gender.man).build();

        Country country = Country.builder()
                            .id(3)
                            .code("code")
                            .name("Frank")
                            .area("taiwan").build();

        CompositeDTO compositeDTO = CompositeMapper.INSTANCE.toDTO(country, person);

        assertThat(compositeDTO)
                .extracting(CompositeDTO::getId, CompositeDTO::getCode, CompositeDTO::getFirstName, CompositeDTO::getLastName)
                .containsExactly(country.getId(), country.getCode(), person.getFirstName(), person.getLastName());
    }
}
