package io.github.hooj0.io_nio.nio.base;

import io.github.hooj0.BasedTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 通道测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 2, 2011 3:10:02 PM
 */
@SuppressWarnings("ALL")
public class ChannelTest extends BasedTests {

	public static void main(String[] args) {
		FileChannel in = null;
		FileChannel out = null;
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/file/temp.txt");

			//创建FileInputStream，以该文件输入流创建FileChannel
			in = new FileInputStream(file).getChannel();
			out(file.length());

			//将FileChannel里的全部数据映射成ByteBuffer
			MappedByteBuffer buffer = in.map(MapMode.READ_WRITE, 0, file.length());
			out = new FileOutputStream(path + "/file/aaaa.txt").getChannel();
			//直接将Buffer的数据输出
			out.write(buffer);
			//调用clear方法，复原limit、position的位置
			buffer.clear();

			//使用GBK的字符集来创建解码器
			Charset charset = Charset.forName("GBK");
			//创建解码器（CharsetDocoder）对象
			CharsetDecoder docoder = charset.newDecoder();
			//使用解码器ByteBuffer转换成CharBuffer
			CharBuffer charBuffer = docoder.decode(buffer);

			out(charBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
