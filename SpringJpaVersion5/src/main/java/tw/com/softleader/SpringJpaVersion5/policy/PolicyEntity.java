package tw.com.softleader.SpringJpaVersion5.policy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String policyNo;

    private int endstNo;

    private String applicantLocalName;

    private String applicantIdNo;

    private Long InsuredId;

}
