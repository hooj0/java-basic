package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机测试
 *
 * @author hoojo
 * @version 1.0
 * @date 13, 2011 8:55:08 PM
 */
public class RandomTest extends BasedTests {

	public static void main(String[] args) {
		Random rand = new Random();
		out("rand.nextBoolean(): " + rand.nextBoolean());
		byte[] bt = new byte[16];
		rand.nextBytes(bt);
		out(Arrays.toString(bt));
		//生成0.0~1.0 之间的伪随机double数
		out("rand.nextDouble(): " + rand.nextDouble());
		//生成0.0~1.0 之间的伪随机float数
		out("rand.nextFloat(): " + rand.nextFloat());
		//生成平均值是0.0，标准差是1.0的伪高斯数
		out("rand.nextGaussian(): " + rand.nextGaussian());
		//生成一个处于int整数取值范围的伪随机数
		out("rand.nextInt(): " + rand.nextInt());
		//生成一个0~26之间的int整数取值范围的伪随机数
		out("rand.nextInt(26): " + rand.nextInt(26));
		//生成一个处于long整数取值范围的伪随机数
		out("rand.nextLong(): " + rand.nextLong());
		
		out("--------------------------------------");
		
		rand = new Random(50);
		out("种子为50的Random对象");
		out("rand.nextBoolean(): " + rand.nextBoolean());
		out("rand.nextInt(): " + rand.nextInt());
		out("rand.nextDouble(): " + rand.nextDouble());
		out("rand.nextGaussian(): " + rand.nextGaussian());
		
		out("--------------------------------------");
		
		rand = new Random(50);
		out("种子为100的Random对象");
		out("rand.nextBoolean(): " + rand.nextBoolean());
		out("rand.nextInt(): " + rand.nextInt());
		out("rand.nextDouble(): " + rand.nextDouble());
		out("rand.nextGaussian(): " + rand.nextGaussian());
		
		out("--------------------------------------");
		
		rand = new Random(100);
		out("种子为50的Random对象");
		out("rand.nextBoolean(): " + rand.nextBoolean());
		out("rand.nextInt(): " + rand.nextInt());
		out("rand.nextDouble(): " + rand.nextDouble());
		out("rand.nextGaussian(): " + rand.nextGaussian());
	}
}
