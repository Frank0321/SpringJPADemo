package tw.com.softleader.SpringJpaVersion2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class SpringJpaVersion2ApplicationTests {

	@Test
	void contextLoads() {
		log.trace("log trace print");
		log.debug("log debug print");
		log.info("log info print");
		log.warn("log warn print");
		log.error("log error print");
	}

}
