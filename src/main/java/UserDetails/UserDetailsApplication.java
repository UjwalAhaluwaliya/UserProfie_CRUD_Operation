package UserDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserDetailsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(UserDetailsApplication.class, args);
	}

}
