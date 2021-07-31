package tw.com.softleader.SpringJpaVersion4.Extends;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tw.com.softleader.SpringJpaVersion4.Extends.UserEntity;

import javax.persistence.Entity;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployEntity extends UserEntity {

    String employNo;

    String employEmail;
}
