package io.github.hooj0.io_nio.nio.base;

import io.github.hooj0.BasedTests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 09:22:27
 */
@SuppressWarnings("ALL")
public class FileLockTest extends BasedTests {

	/**
	 * @author hoojo
	 * @createDate Jan 2, 2011 5:09:56 PM
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileChannel channel = null;
		try {
			channel = new FileOutputStream("lock.txt").getChannel();
			// 非阻塞方式对指定文件加锁
			FileLock lock = channel.tryLock();

			Thread.sleep(5000);
			lock.release(); // 释放锁
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (channel != null) {
				channel.close();
			}
		}
	}
}
