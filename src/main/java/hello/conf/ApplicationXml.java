package hello.conf;

import java.util.List;

import hello.component.MessagePrinter;
import hello.service.InjectionService;
import hello.service.MessageService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXml {

  public static void main(String[] args) {
	  //applicationContext.xml, applicationContext-anno.xml:hello
      ApplicationContext context = 
          new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
      
      MessageService service = null;
      
      //Instantiating beans
      service = (MessageService) context.getBean("instance1");
      System.out.println(service.getMessage());
      
      service = (MessageService) context.getBean("instance2");
      System.out.println(service.getMessage());
      
      //type 2 
      service = (MessageService) context.getBean("msgType2");
      System.out.println(service.getMessage());
      
      //type 3 
      service = (MessageService) context.getBean("msgType3-1");
      System.out.println(service.getMessage());
      
      service = (MessageService) context.getBean("msgType3-2");
      System.out.println(service.getMessage());
      
      service = (MessageService) context.getBean("msgType3-3");
      System.out.println(service.getMessage());
      
      //full
      InjectionService fullEx = (InjectionService) context.getBean("fullInjectionService");
      System.out.println(fullEx.getMessage());
      List list = fullEx.getList();
      for(Object o : list){
    	  System.out.println(o);
      }
  }
}