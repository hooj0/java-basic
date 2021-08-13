package io.github.hooj0.system;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	/**
	 *
	 * @author hoojo
	 * @createDate Feb 13, 2011 8:55:08 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("rand.nextBoolean(): " + rand.nextBoolean());
		byte[] bt = new byte[16];
		rand.nextBytes(bt);
		System.out.println(Arrays.toString(bt));
		//生成0.0~1.0 之间的伪随机double数
		System.out.println("rand.nextDouble(): " + rand.nextDouble());
		//生成0.0~1.0 之间的伪随机float数
		System.out.println("rand.nextFloat(): " + rand.nextFloat());
		//生成平均值是0.0，标准差是1.0的伪高斯数
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		//生成一个处于int整数取值范围的伪随机数
		System.out.println("rand.nextInt(): " + rand.nextInt());
		//生成一个0~26之间的int整数取值范围的伪随机数
		System.out.println("rand.nextInt(26): " + rand.nextInt(26));
		//生成一个处于long整数取值范围的伪随机数
		System.out.println("rand.nextLong(): " + rand.nextLong());
		
		System.out.println("--------------------------------------");
		
		rand = new Random(50);
		System.out.println("种子为50的Random对象");
		System.out.println("rand.nextBoolean(): " + rand.nextBoolean());
		System.out.println("rand.nextInt(): " + rand.nextInt());
		System.out.println("rand.nextDouble(): " + rand.nextDouble());
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		
		System.out.println("--------------------------------------");
		
		rand = new Random(50);
		System.out.println("种子为100的Random对象");
		System.out.println("rand.nextBoolean(): " + rand.nextBoolean());
		System.out.println("rand.nextInt(): " + rand.nextInt());
		System.out.println("rand.nextDouble(): " + rand.nextDouble());
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
		
		System.out.println("--------------------------------------");
		
		rand = new Random(100);
		System.out.println("种子为50的Random对象");
		System.out.println("rand.nextBoolean(): " + rand.nextBoolean());
		System.out.println("rand.nextInt(): " + rand.nextInt());
		System.out.println("rand.nextDouble(): " + rand.nextDouble());
		System.out.println("rand.nextGaussian(): " + rand.nextGaussian());
	}
}
