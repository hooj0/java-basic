package io.github.hooj0.reflection.proxy;

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
