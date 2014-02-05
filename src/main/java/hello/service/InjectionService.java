package hello.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class InjectionService implements MessageService{
	private Properties props;
	private Map map;
	private List list;
	private Set set;
	private int id;
	private String msg;
	
	public InjectionService() {
	
	}
	
	public InjectionService(int id, String msg){
		this.id=id;
		this.msg=msg;
	}

	public String getMessage() {
		return "Hello "+id+", "+msg+"!";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
