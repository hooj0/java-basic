package io.github.hooj0.nio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransformTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 2, 2011 4:56:43 PM
	 * @param args
	 * @throws CharacterCodingException 
	 */
	public static void main(String[] args) throws CharacterCodingException {
		Charset charset = Charset.forName("GBK");
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();
		CharBuffer buffer = CharBuffer.allocate(8);
		buffer.put("a");
		buffer.put("b");
		buffer.put("c");
		buffer.flip();
		
		ByteBuffer b = encoder.encode(buffer);
		for (int i = 0; i < b.limit(); i++) {
			System.out.println(b.get(i) + " ");
		}
		System.out.println(decoder.decode(b));
	}
}
