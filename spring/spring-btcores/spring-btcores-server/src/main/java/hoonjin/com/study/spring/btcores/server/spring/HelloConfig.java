package hoonjin.com.study.spring.btcores.server.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HelloConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
