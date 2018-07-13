package rebrickable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// same as @ComponentScan & @Configuration
@SpringBootApplication
public class Application {

    // runs the application persistantly on a embedded Tomcat web server and compiles as jar/wor file
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    // called by Spring and will get a RestTemplate back to be used anytime
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
