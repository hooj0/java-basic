package io.github.hooj0.thread.variable;

public class Account {
	/*定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量，每个线程都会保留该变量的一个副本*/
	ThreadLocal<String> name = new ThreadLocal<String>();
	//定义一个初始化name属性的构造器
	public Account(String name) {
		this.name.set(name);
		System.out.println("初始化名称name:" + this.name.get());
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return this.name.get();
	}
}
