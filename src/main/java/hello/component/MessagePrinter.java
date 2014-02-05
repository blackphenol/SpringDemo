package hello.component;

import hello.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    private MessageService service;

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }

    @Autowired
	public void setService(MessageService service) {
		this.service = service;
	}
    
    
}
