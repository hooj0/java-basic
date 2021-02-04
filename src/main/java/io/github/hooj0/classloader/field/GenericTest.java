package io.github.hooj0.classloader.field;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericTest {
	@SuppressWarnings("unused")
	private Map<String, Integer> score;
	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 5, 2010 2:09:43 PM
	 * @param args
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws Exception {
		Class<GenericTest> clazz = GenericTest.class;
		Field f = clazz.getDeclaredField("score");
		//直接使用getType取出Field类型，只对普通类型的Field有效
		Class<?> c = f.getType();
		//下面看到的是java.util.Map
		System.out.println(c);
		//获取Field的实例f泛型类型
		Type type = f.getGenericType();
		//如果type的类型是ParameterizedType
		if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			//获取原始类型
			Type rType = pType.getRawType();
			System.out.println("原来类型：" + rType);
			//取得泛型类型的泛型参数
			Type[] argsment = pType.getActualTypeArguments();
			System.out.println("泛型类型是：");
			for (int i = 0; i < argsment.length; i++) {
				System.out.println("第" + i + "个泛型参数是" + argsment[i]);
			}
		} else {
			System.out.println("error");
		}
	}
}
