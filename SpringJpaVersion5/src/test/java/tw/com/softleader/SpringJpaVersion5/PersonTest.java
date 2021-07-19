package tw.com.softleader.SpringJpaVersion5;

import org.junit.jupiter.api.Test;
import tw.com.softleader.SpringJpaVersion5.person.Gender;
import tw.com.softleader.SpringJpaVersion5.person.Person;
import tw.com.softleader.SpringJpaVersion5.person.PersonDTO;
import tw.com.softleader.SpringJpaVersion5.person.PersonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    void testToDTO(){
        Person person = Person.builder()
                .firstName("Chang")
                .lastName("Frank")
                .age(30)
                .gender(Gender.man).build();

        PersonDTO personDTO = PersonMapper.INSTANCE.toDTO(person);

        assertThat(personDTO)
                .extracting(PersonDTO::getFirstName, PersonDTO::getLastName, PersonDTO::getAge, PersonDTO::getGender)
                .containsExactly(person.getFirstName(), person.getLastName(), person.getAge(), person.getGender());
    }

    @Test
    void testFromDTO(){
        PersonDTO personDTO = PersonDTO.builder()
                .setFirstName("Chang")
                .setLastName("Frank")
                .setAge(30)
                .setGender(Gender.man)
                .build();

        Person person = PersonMapper.INSTANCE.fromDTO(personDTO);

        assertThat(person)
                .extracting(person1 -> person1.getFirstName(),
                            person2 -> person2.getLastName(),
                            person3 -> person3.getAge(),
                            person1 -> person1.getGender())
                .containsExactly(personDTO.getFirstName(),
                                 personDTO.getLastName(),
                                 personDTO.getAge(),
                                 personDTO.getGender());
    }

    //VO 的測試方法，以專案上的範例，是用 jpa 找到的資料，直接塞入 VO 裡面，然後再轉換成一般物件
}
