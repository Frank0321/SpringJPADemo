package tw.com.softleader.SpringJpaVersion5.policy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insured {

    @Id
    private Long id;

    private String insuredIndo;

    private String insuredLocalName;
}
