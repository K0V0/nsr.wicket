package sk.neser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder()
				.sources(Main.class)
				.run(args);
	}

}
