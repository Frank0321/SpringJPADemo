package tw.com.softleader.SpringJpaVersion5.Area;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaVO {
    private String city;
    private Integer haveAir;
    private Double pm25;
    private String pm25Str;
    private Double pm10;
}
