package tw.com.softleader.SpringJpaVersion5.Composite;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompositeDTO {
    private int id;
    private String code;
    private String firstName;
    private String lastName;
}
