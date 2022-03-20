package dk.stumph.experiments.speedcomparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpeedcomparatorApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpeedcomparatorApplication.class, args);
	/*	new SpringApplicationBuilder(SpeedcomparatorApplication.class)
        .headless(false)
        .web(WebApplicationType.NONE)
        .run(args);*/

		Application.launch(JavaFxApplication.class, args);
	}

	
}
