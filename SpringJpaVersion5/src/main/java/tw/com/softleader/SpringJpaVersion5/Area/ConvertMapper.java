package tw.com.softleader.SpringJpaVersion5.Area;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.text.DecimalFormat;

@Mapper(componentModel = "spring")
public interface ConvertMapper {

    @Mapping(target = "cityName", ignore = true)
    @Mapping(target = "pm25", source = "pm25", qualifiedByName = "formatDoubleDef")
    AreaPO toPO(AreaVO areaVO);

    @Named("formatDoubleDef")
    default Double formatDouble(Double source){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (source == null){
            source = 0.0;
        }
        return Double.parseDouble(decimalFormat.format(source));
    }
}
