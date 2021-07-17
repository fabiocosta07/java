package javaconfigimport.core;

import javaconfigimport.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String [] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerBo cbo = (CustomerBo) ac.getBean("customerBo");
        cbo.printMsg("bla");

        SchedulerBo sbo = (SchedulerBo) ac.getBean("schedulerBo");
        sbo.printMsg("bla");
    }
}
