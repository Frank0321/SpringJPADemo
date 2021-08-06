package tw.com.softleader.SpringJpaVersion3;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpringJpaVersion3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaVersion3Application.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
		return builder -> builder
				//修改回傳的時間格式
				.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
				//修改傳入的時間格式
				.deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

	}

}
