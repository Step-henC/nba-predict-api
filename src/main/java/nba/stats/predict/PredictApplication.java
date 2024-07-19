package nba.stats.predict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PredictApplication {
	// mvn spring-boot:run
	public static void main(String[] args) {
		// localhost:8080/swagger-ui.html
		SpringApplication.run(PredictApplication.class, args);
	}

}
