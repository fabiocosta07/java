package hello;

import org.joda.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
  public static void main(String[] args) {
    ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
    MyModel model = (MyModel) classPathXmlApplicationContext.getBean("myModel");
    model.printHello();
  }
}