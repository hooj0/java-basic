package io.github.hooj0.reflection.proxy;

/**
 * 复仇者
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 6, 2010 5:44:15 PM
 */
public class Avenger {

	public static void main(String[] args) {
		//复仇者想要杀掉伊拉克，但他又不能亲手杀人。只好委托中间人帮他杀掉伊拉克
		KillPerson kill = new Client();
		kill.killPerson("伊拉克");
	}
}
