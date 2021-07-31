package tw.com.softleader.SpringJpaVersion4.Extends;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.com.softleader.SpringJpaVersion4.Extends.UserEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity extends UserEntity {

    String testWord;
}
