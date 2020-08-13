package in.bushansirgur.springboot.crudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Slf4j
@SpringBootApplication
@EnableSwagger2
public class CrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapiApplication.class, args);
	}

}

