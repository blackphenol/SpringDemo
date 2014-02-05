package hello.service;

/**
 *
 * @author Walter
 * @editor 
 * @since 2014/1/6
 * 
 */
public class MessageLocation {
	private static MessageService service = new InjectionService(123, "Instance Static ");
	private MessageLocation() {
	}
	
	public MessageService createInstance(){
		return new InjectionService(123, "Instance");
	}
	
	public static MessageService createStaticInstance(){
		return service;
	}

}
