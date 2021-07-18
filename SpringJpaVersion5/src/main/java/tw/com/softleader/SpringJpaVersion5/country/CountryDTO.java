package tw.com.softleader.SpringJpaVersion5.country;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDTO {
    private int countryId;
    private String countryName;
    private String countryCode;
    private String countryArea;
}
