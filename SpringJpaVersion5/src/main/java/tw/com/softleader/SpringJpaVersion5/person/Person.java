package tw.com.softleader.SpringJpaVersion5.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
}
