package io.github.hooj0.classloader.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 *
 * @author hoojo
 * @version 1.0
 * @createDate Sep 28, 2010 9:12:33 PM
 * @file CustomClassLoader.java
 * @package com.hoo.base.classLoader
 * @project JavaClassLoader
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class CustomClassLoader extends ClassLoader {

    /**
     * 读取文件字节
     *
     * @param fileName 文件名
     * @return byte[]
     * @throws IOException
     * @author hoojo
     * @createDate Sep 28, 2010 9:39:56 PM
     */
    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];

        FileInputStream fis = new FileInputStream(file);
        //一次性读取class文件的全部二进制数据
        int r = fis.read(raw);
        if (r != len) {
            throw new IOException("无法读取全部内容， " + r + "!=" + len);
        }
        fis.close();

        return raw;
    }

    /**
     * 编译指定java文件的方法
     *
     * @param fileName
     * @throws Exception
     * @author hoojo
     * @createDate Sep 28, 2010 9:48:54 PM
     */
    private boolean compile(String fileName) throws Exception {
        System.out.println("CompileClassLoader:正在编译" + fileName + "……");
        //调用系统javac命令
        try {
            //fileName = URLEncoder.encode(fileName, "ISO-8859-1");
            fileName = fileName.replace(" ", "%20");
            System.out.println(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Process p = Runtime.getRuntime().exec("javac " + fileName);
        try {
            //其他线程都等待这个线程完成
            p.waitFor();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

        //获取javac线程的退出值
        int val = p.exitValue();
        return val == 0;
    }


    /**
     * 重写ClassLoader的findClass方法
     *
     * @throws Exception
     * @author hoojo
     * @createDate Sep 28, 2010 10:11:17 PM
     * @see ClassLoader#findClass(String)
     */
    @Override
    @SuppressWarnings("unchecked")
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //替换包路径中的点(.)替换成斜线(.)
        String fileName = name.replace(".", "/");
        String javaFileName = System.getProperty("user.dir").replace("\\", "/").concat("/src/").concat(fileName).concat(".java");
        String classFileName = System.getProperty("user.dir").replace("\\", "/").concat("/bin/").concat(fileName).concat(".class");

        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        //当指定java源文件存在，且class文件不存在、或者java源文件的修改时间比class文件修改时间晚，重新编译
        if (javaFile.exists() && (!classFile.exists() || classFile.lastModified() < javaFile.lastModified())) {
            try {
                //如果编译失败，或者该Class文件不存在
                if (!this.compile(javaFileName) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
                }
            } catch (Exception e) {
                throw new ClassNotFoundException("发生异常" + e.getMessage());
            }
        }

        //如果class文件存在，系统负责将该文件转换成class对象
        if (classFile.exists()) {
            try {
                //将class文件的二进制数据读入到数组中
                byte[] raw = this.getBytes(classFileName);
                //调用ClassLoader的defineClass方法将二进制数据转换成Class对象
                clazz = this.defineClass(name, raw, 0, raw.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException(name);
            }
            //如果clazz为null，说明加载失败，则抛出异常
            if (clazz == null) {
                throw new ClassNotFoundException(name);
            }
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
		/*Properties pro = System.getProperties();
		Set<Entry<Object, Object>> s = pro.entrySet();
		Iterator<Entry<Object, Object>> iter = s.iterator();
		while(iter.hasNext()) {
			Entry<Object, Object> ety = iter.next();
			System.out.println(ety.getKey() + "##" + ety.getValue());
		}
		System.out.println("##########################");
		Set<Object> set = pro.keySet();
		for (Object o : set) {
			System.out.println(o + "=" + pro.getProperty(o.toString()) + "###" + pro.get(o));
		}
		System.out.println("##########################");
		Enumeration<Object> en = pro.keys();
		while(en.hasMoreElements()) {
			Object o = en.nextElement();
			System.out.println(o + "%%%" + pro.getProperty(o.toString()) + "###" + pro.get(o));
		}
		System.out.println("##########################");
		Enumeration<Object> ele = pro.elements();
		while(ele.hasMoreElements()) {
			Object o = ele.nextElement();
			System.out.println(o);
		}
		
		System.out.println("————————————————————————————————————");
		Collection<Object> v = pro.values();
		Iterator<Object> o = v.iterator();
		while(o.hasNext()) {
			Object value = o.next();
			System.out.println(value);
		}*/

        //如果运行改程序时没有参数，即没有目标类
        if (args.length > 1) {
            //需要运行的类
            System.out.println("请输入需要运行的类:");
            String programClass = args[2];
            System.out.println(programClass + "########");
            String[] progArgs = new String[args.length - 1];
            //将一个数组赋值到另一个数组中
            System.arraycopy(args, 1, progArgs, 0, progArgs.length);
            CustomClassLoader loader = new CustomClassLoader();
            Class<?> clazz = loader.loadClass(programClass);
            //需要运行类的主函数方法
            Method main = clazz.getMethod("main", (new String[0].getClass()));
            Object argsArray[] = { progArgs };
            main.invoke(null, argsArray);
        } else {
            System.out.println("缺少运行目标，按下面格式输入运行目标类");
            //java CustomClassLoader com.hoo.base.classLoader.Hello 参数 Hello World!
            System.out.println("java CustomClassLoader com.hoo.base.classLoader.Hello 参数");
        }
    }
    /**
     * ClassLoader 类的3个关键方法
     * 1、loadClass(String name, boolean resolve)根据二进制的名称来加载类，
     * 系统调用ClassLoader的该方法来获取指定类的对应的Class
     * 2、findClass(String name)根据二进制名称来查找类
     * 推荐重写findClass，如果重写loadClass方法需要以下步骤：
     * a、用findLoadedClass来检查是否已经加载该类，如果加载之间返回
     * b、在父类加载器上调用loadClass方法。如果父类加载器为null，则使用根类加载器来加载。
     * c、调用findClass来查找该类
     * 从上面可以看出：重写findClass方法可以避免覆盖默认类加载器的父类委托、缓冲机制
     * 两种策略。如果用loadClass实现逻辑更为复杂
     * defineClass(String name, byte[] b, int off, int len)
     * 该方法负责将字节码文件读入字节数组
     */
}
