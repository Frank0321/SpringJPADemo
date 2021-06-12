package tw.com.softleader.SpringJPADemo.version2;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;


@Slf4j
@DisplayName("EmpolyService 的測試方法")
public class EmpolyServiceTest {

    @Autowired
    private EmpolyService empolyService;

    @MockBean
    private EmpolyRepository empolyRepository;

    @Test
    public void creatEmpolyeeTest(){

        var empolyEntity = EmpolyEntity.builder().name("testName").build();

        when(empolyRepository.save(empolyEntity))
                .thenReturn(EmpolyEntity.builder()
                        .name("testName").build());
    }



}
