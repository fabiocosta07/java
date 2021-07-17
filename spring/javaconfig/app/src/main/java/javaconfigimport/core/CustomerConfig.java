package javaconfigimport.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean(name = "customerBo")
    public CustomerBo customerBo(){
        return new CustomerBo();
    }
}
