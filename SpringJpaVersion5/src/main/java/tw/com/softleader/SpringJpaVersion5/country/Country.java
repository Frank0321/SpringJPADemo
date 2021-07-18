package tw.com.softleader.SpringJpaVersion5.country;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {
    private int id;
    private String name;
    private String code;
    private String area;
}
