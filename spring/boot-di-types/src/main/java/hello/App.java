package hello;

import hello.helper.OutputHelper;
import hello.helper.OutputHelperWithContructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
    OutputHelper outputHelper = (OutputHelper) classPathXmlApplicationContext.getBean("myOutputHelper");
    OutputHelperWithContructor outputHelperWithContructor = (OutputHelperWithContructor)  classPathXmlApplicationContext.getBean("myOutputHelperWithConstructor");
  }
}