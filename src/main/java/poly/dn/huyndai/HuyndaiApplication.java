package poly.dn.huyndai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import poly.dn.huyndai.Config.StorageProperties;
import poly.dn.huyndai.Service.StorageService;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class HuyndaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuyndaiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService service){
		return (args->{
              service.init();
		});
	}

}
