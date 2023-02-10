package M1S7.LoggingTeste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingTesteApplication {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(LoggingTesteApplication.class);

		//Antes de carregar o Spring-Boot
		logger.info("*****O Spring Boot está iniciando!*****");
		SpringApplication.run(LoggingTesteApplication.class, args);
		//Após de carregar o Spring-Boot
		logger.info("*****A Aplicação já está carregada!*****");
	}

}
