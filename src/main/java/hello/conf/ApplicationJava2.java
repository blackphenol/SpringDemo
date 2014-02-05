package hello.conf;

import hello.service.HelloHywebService;
import hello.service.HelloWorldService;
import hello.service.MessageService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 *
 */
public class ApplicationJava2 {

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(HelloWorldService.class, HelloHywebService.class);
      MessageService message = context.getBean(HelloWorldService.class);
      System.out.println(message.getMessage());
  }
}