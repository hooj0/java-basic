package io.github.hooj0.io_nio.nio.base;

import io.github.hooj0.BasedTests;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 随机文件通道测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 09:24:53
 */
@SuppressWarnings("ALL")
public class RandomFileChannelTest extends BasedTests {

	/**
	 * @author hoojo
	 * @createDate Jan 2, 2011 4:02:17 PM
	 * @param args
	 */
	public static void main(String[] args) {
		FileChannel chnanel = null;
		try {
			File file = new File("ra.txt");
			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			//获取RandomAccessFile对应的Chnanel
			chnanel = raf.getChannel();
			//将Channel中所有的数据映射成ByteBuffer
			ByteBuffer buffer = chnanel.map(MapMode.READ_ONLY, 0, file.length());
			//把Channel的记录指针移动到最后的位置
			chnanel.position(file.length());

			chnanel.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				chnanel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
