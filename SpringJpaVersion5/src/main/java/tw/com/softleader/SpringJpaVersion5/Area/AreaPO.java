package tw.com.softleader.SpringJpaVersion5.Area;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaPO {
    private String cityName;
    private Integer haveAir;
    private Double pm25;
    private String pm10Str;
}
