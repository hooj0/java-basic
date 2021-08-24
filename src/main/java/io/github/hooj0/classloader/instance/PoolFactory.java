package io.github.hooj0.classloader.instance;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PoolFactory {
	private Map<String, Object> pools = new HashMap<String, Object>();
	private Properties config = new Properties();
	
	public void init(String file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			config.load(fis);
		} catch (Exception e) {
			System.out.println("读取" + file + "出现异常" + e.getMessage());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private Object objectFactory(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		return clazz.newInstance();
	}
	
	public void initPool() throws Exception {
		Iterator<Object> iter = config.keySet().iterator();
		while(iter.hasNext()) {
			Object o = iter.next();
			/**
			 * 取得的的属性名称、值键值对，如果属性名称不包含百分号(%)
			 * 就跟创建属性键值对
			 */
			if (!o.toString().contains("%")) {
				pools.put(o.toString(), objectFactory(config.getProperty(o.toString())));
			}
		}
	}
	
	public void initField() throws Exception {
		Iterator<Object> iter = config.keySet().iterator();
		while(iter.hasNext()) {
			Object o = iter.next();
			/**
			 * 如果属性名称中包含%号，即可认为属性是设置对象属性值
			 * _线前半部分为对象名称，后半为属性名
			 * 程序调用相应的setter方法进行属性设置
			 */
			if (o.toString().contains("%")) {
				//属性文件中的属性按照%分割
				String[] field = o.toString().split("%");
				//得到要设置对象的目标
				Object target = getObject(field[0]); //返回User对象
				//该属性对应的setter方法名称为：set+ 属性名首字母大写 + 后面部分
				String method = "set".concat(field[1].substring(0, 1).toUpperCase()).concat(field[1].substring(1));//setName/setAge等setter方法
				Class<?> targetClass = target.getClass();//User.class
				//获取该属性对应的setter方法,如果需要调用私有private的方法，可以设置m.setAccessible(true)
				Method m = targetClass.getMethod(method, String.class);//得到setter方法
				m.invoke(target, config.getProperty(o.toString()));//执行
			}
		}
	}
	
	public Object getObject(String name) {
		return pools.get(name);
	}
	
	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 4, 2010 4:16:07 PM
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PoolFactory factory = new PoolFactory();
		factory.init("F:\\Example Exercise\\JAVA\\JavaClassLoader\\src\\com\\hoo\\base\\instance\\user.txt");
		factory.initPool();
		factory.initField();
		factory.getObject("user");
		System.out.println(factory.getObject("user"));
	}
}
