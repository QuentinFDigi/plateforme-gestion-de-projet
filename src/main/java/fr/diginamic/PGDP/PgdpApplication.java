package fr.diginamic.PGDP;

import fr.diginamic.PGDP.configs.loader.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PgdpApplication {

	public static void main(String[] args) {
		EnvLoader.loadEnv();
		SpringApplication.run(PgdpApplication.class, args);
	}

}
