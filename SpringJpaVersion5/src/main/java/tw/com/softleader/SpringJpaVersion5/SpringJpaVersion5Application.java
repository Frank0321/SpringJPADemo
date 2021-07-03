package tw.com.softleader.SpringJpaVersion5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaVersion5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaVersion5Application.class, args);

		/**
		 * TODO : 使用 Mapper 練習
		 * request -> Object -> Entity
		 * Entity -> Object -> response
		 */
	}

}
