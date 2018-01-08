package shop.nearby;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ApplicationShop implements CommandLineRunner{
		
    public static void main(String[] args) {
		SpringApplication.run(ApplicationShop.class, args);
    }
   
	@Override
	public void run(String... arg0) throws Exception {	}

}
