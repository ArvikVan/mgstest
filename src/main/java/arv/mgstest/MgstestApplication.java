package arv.mgstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MgstestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgstestApplication.class, args);
	}

}
