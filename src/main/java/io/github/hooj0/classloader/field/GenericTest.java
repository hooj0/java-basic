package io.github.hooj0.classloader.field;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 通用测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 5, 2010 2:09:43 PM
 */
public class GenericTest extends BasedTests {

    @SuppressWarnings("unused")
    private Map<String, Integer> score;

    public static void main(String[] args) throws Exception {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");

        //直接使用getType取出Field类型，只对普通类型的Field有效
        Class<?> c = f.getType();
        //下面看到的是java.util.Map
        out(c);

        //获取Field的实例f泛型类型
        Type type = f.getGenericType();
        //如果type的类型是ParameterizedType
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            //获取原始类型
            Type rType = pType.getRawType();
            out("原来类型：" + rType);

            //取得泛型类型的泛型参数
            Type[] argsment = pType.getActualTypeArguments();
            out("泛型类型是：");
            for (int i = 0; i < argsment.length; i++) {
                out("第" + i + "个泛型参数是" + argsment[i]);
            }
        } else {
            out("error");
        }
    }
}
