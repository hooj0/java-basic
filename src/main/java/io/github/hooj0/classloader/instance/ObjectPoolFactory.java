package io.github.hooj0.classloader.instance;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ObjectPoolFactory {
	//对象池，key是对象名称，value是实际对象
	private Map<String, Object> objectPool = new HashMap<String, Object>();
	
	@SuppressWarnings("unused")
	private Object createObject(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		return clazz.newInstance();
	}
	
	public void initPool(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			Properties pro = new Properties();
			pro.load(fis);
			Set<Object> set = pro.keySet();
			Iterator<Object> iter = set.iterator();
			while(iter.hasNext()) {
				Object key = iter.next();
				System.out.println(key);
				objectPool.put(key.toString(), createObject(pro.getProperty(key.toString())));
			}
		} catch (Exception e) {
			System.out.println("读取数据发生异常" + e.getMessage());
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
	
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	
	/**
	 *
	 * @author hoojo
	 * @createDate Oct 4, 2010 1:29:12 PM
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectPoolFactory factory = new ObjectPoolFactory();
		//factory.initPool("F:\\Example Exercise\\JAVA\\JavaClassLoader\\src\\com\\hoo\\base\\instance\\create.txt");
		System.out.println(factory.getObject("test"));
	}

}
