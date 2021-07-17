package javaconfigimport.config;

import javaconfigimport.core.CustomerConfig;
import javaconfigimport.core.SchedulerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerConfig.class, SchedulerConfig.class})
public class AppConfig {
}
