package co.edu.ue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.su.ue.entity"})
@EnableJpaRepositories(basePackages = {"co.edu.ue.jpa"})
@ComponentScan(basePackages = {"co.edu.ue.controller", "co.edu.ue.service","co.edu.ue.dao","co.edu.ue"})
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
