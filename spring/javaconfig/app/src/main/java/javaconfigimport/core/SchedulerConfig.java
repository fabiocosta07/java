package javaconfigimport.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {
    @Bean(name = "schedulerBo")
    public SchedulerBo schedulerBo(){
        return new SchedulerBo();
    }
}
