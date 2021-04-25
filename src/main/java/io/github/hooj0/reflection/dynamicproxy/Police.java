package io.github.hooj0.reflection.dynamicproxy;

public class Police implements GatherInformation {
	private GatherInformation info;
	public void message(String msg) {
		info = new XiGui();
		info.message(msg);
	}
	
	public static void main(String[] args) {
		Police p = new Police();
		p.message("police 要情报！");
	}
}
