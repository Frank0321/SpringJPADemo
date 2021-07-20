package tw.com.softleader.SpringJpaVersion3;

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

    private int seq;

    private String quotationNo;

}
