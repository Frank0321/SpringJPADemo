package tw.com.softleader.SpringJpaVersion4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployEntity extends UserEntity{

    String employNo;

    String employEmail;
}
