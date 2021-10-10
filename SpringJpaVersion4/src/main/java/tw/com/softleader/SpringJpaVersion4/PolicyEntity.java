package tw.com.softleader.SpringJpaVersion4;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyEntity extends AbstractEntity<String> implements Serializable {

    String policy;

}
