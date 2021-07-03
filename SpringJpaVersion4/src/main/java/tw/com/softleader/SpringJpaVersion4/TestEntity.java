package tw.com.softleader.SpringJpaVersion4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity extends UserEntity{

    String testWord;
}
