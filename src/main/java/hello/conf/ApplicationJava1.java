package hello.conf;

import hello.component.MessagePrinter;
import hello.service.HelloWorldService;
import hello.service.MessageService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
@Configuration
@ComponentScan
public class ApplicationJava1 {

	@Bean(name="messagePrinter")
	MessagePrinter mockMessagePrinter(){
		return new MessagePrinter();
	}
	@Bean(name={"helloWorldService1", "helloWorldService2"})
    MessageService mockMessageService() {
        return new HelloWorldService();
    }


  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(ApplicationJava1.class);
      MessagePrinter printer = (MessagePrinter)context.getBean("messagePrinter");//context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}