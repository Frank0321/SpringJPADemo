package tw.com.softleader.SpringJpaVersion4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    Long id;

    String name;
}
