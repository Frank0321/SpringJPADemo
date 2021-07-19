package tw.com.softleader.SpringJpaVersion5;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tw.com.softleader.SpringJpaVersion5.Area.AreaPO;
import tw.com.softleader.SpringJpaVersion5.Area.AreaVO;
import tw.com.softleader.SpringJpaVersion5.Area.ConvertMapper;

@Slf4j
public class ConvertTest extends SpringJpaVersion5ApplicationTests{

    @Autowired
    ConvertMapper convertMapper;

    @Test
    void test1(){
        AreaVO areaVO = AreaVO.builder()
                .city("tainan")
                .haveAir(123)
                .pm25(1.23456)
                .build();

        AreaPO areaPO = convertMapper.toPO(areaVO);
        log.info("areaPO.getCityName : {}", areaPO.getCityName());
        log.info("areaPO.getPm25 : {}", areaPO.getPm25());
        /**
         * result :
         * 1. 沒有轉換 cityName
         * 2. interface 使用靜態方法
         * 3. Mapper 使用方法縮減有效位數
         */

    }
}
