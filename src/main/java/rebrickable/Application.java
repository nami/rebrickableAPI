package rebrickable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// same as @ComponentScan & @Configuration
@EnableCaching
@SpringBootApplication
public class Application {
//        extends SpringBootServletInitializer{

    // runs the application persistantly on a embedded Tomcat web server and compiles as jar/wor file
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    // called by Spring and will get a RestTemplate back to be used anytime
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

//    @Override
//    protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
//        return application.sources(Application.class);
//    }
}
