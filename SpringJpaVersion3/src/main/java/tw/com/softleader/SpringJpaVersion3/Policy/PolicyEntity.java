package tw.com.softleader.SpringJpaVersion3.Policy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String policyNo;

    private int endstNo;

    @Min(value = 0, message = "SEQ 最小值不能小於 0")
    private int seq;

    @NotBlank
    private String quotationNo;

    private LocalDate date;

}
