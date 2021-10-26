package tw.com.softleader.SpringJpaVersion5;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

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

//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
//
//		ClassPathResource initSchema = new ClassPathResource("sql/schema.sql");
//		ClassPathResource initDatabase = new ClassPathResource("sql/database.sql");
//		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(initSchema, initDatabase);
//		DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
//		return dataSource;
//	}


	@Bean
	ApplicationRunner init(MemberRepository repository){
		return (ApplicationArguments args) -> dataSetup(repository);
	}

	private void dataSetup(MemberRepository repository) {
		repository.save(MemberEntity.builder().name("Application").empNo("Application_emp").build());
	}

}
