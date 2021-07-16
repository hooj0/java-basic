package io.github.hooj0.reflection.proxy;

/**
 * 客户端
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 11:56:51
 */
public class Client extends KillPerson{
	private Killer killer;
	
	@Override
	public void killPerson(String name) {
		if (killer == null) {
			killer = new Killer();
		}
		connect();
		earnest();
		killer.killPerson(name);
		payment();
	}
	
	private void connect() {
		System.out.println("联系杀手");
	}
	
	private void payment() {
		System.out.println("付款");
	}
	
	private void earnest() {
		System.out.println("付定金");
	}
}
