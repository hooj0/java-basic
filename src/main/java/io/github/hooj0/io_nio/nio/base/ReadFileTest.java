package io.github.hooj0.io_nio.nio.base;

import io.github.hooj0.BasedTests;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 读文件测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 09:25:34
 */
@SuppressWarnings("ALL")
public class ReadFileTest extends BasedTests {

	/**
	 * @author hoojo
	 * @createDate Jan 2, 2011 4:24:31 PM
	 * @param args
	 */
	public static void main(String[] args) {
		FileChannel channel = null;
		try {
			FileInputStream fis = new FileInputStream("file/info.txt");
			channel = fis.getChannel();

			//定义一个ByteBuffer对象，用于重复取水
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			//将FileChannel中数据放入ByteBuffer中
			while (channel.read(buffer) > 0) {
				buffer.flip();//锁定到空白区域

				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer cb = decoder.decode(buffer);
				out(cb);

				buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
