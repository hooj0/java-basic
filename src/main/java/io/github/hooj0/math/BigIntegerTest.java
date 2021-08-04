package io.github.hooj0.math;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * java big integer sample
 * @author hoojo
 * @date 2022/1/21 0021 15:42
 *
 * BigInteger abs()  返回大整数的绝对值
 * BigInteger add(BigInteger val) 返回两个大整数的和
 * BigInteger and(BigInteger val)  返回两个大整数的按位与的结果
 * BigInteger andNot(BigInteger val) 返回两个大整数与非的结果
 * BigInteger divide(BigInteger val)  返回两个大整数的商
 * double doubleValue()   返回大整数的double类型的值
 * float floatValue()   返回大整数的float类型的值
 * BigInteger gcd(BigInteger val)  返回大整数的最大公约数
 * int intValue() 返回大整数的整型值
 * long longValue() 返回大整数的long型值
 * BigInteger max(BigInteger val) 返回两个大整数的最大者
 * BigInteger min(BigInteger val) 返回两个大整数的最小者
 * BigInteger mod(BigInteger val) 用当前大整数对val求模
 * BigInteger multiply(BigInteger val) 返回两个大整数的积
 * BigInteger negate() 返回当前大整数的相反数
 * BigInteger not() 返回当前大整数的非
 * BigInteger or(BigInteger val) 返回两个大整数的按位或
 * BigInteger pow(int exponent) 返回当前大整数的exponent次方
 * BigInteger remainder(BigInteger val) 返回当前大整数除以val的余数
 * BigInteger leftShift(int n) 将当前大整数左移n位后返回
 * BigInteger rightShift(int n) 将当前大整数右移n位后返回
 * BigInteger subtract(BigInteger val)返回两个大整数相减的结果
 * byte[] toByteArray(BigInteger val)将大整数转换成二进制反码保存在byte数组中
 * String toString() 将当前大整数转换成十进制的字符串形式
 * BigInteger xor(BigInteger val) 返回两个大整数的异或
 */
@SuppressWarnings("ALL")
public class BigIntegerTest {

    @Test
    public void test1() throws Exception {

        //读入BigInteger
        BigInteger a = new BigInteger("22");
        out(a); // 22

        //构造方法  
        //将十进制字符串转化为BigInteger  
        BigInteger b = new BigInteger("3");
        out(b); // 3

        //byte范围-128到+127 8为2进制数 c为767（1011111111）  
        byte[] bt = new byte[]{ 2, -1 };
        BigInteger c = new BigInteger(bt);
        out(c); // 767

        //将radix进制的字符串转化为BigInteger  
        BigInteger d = new BigInteger("1011111111", 2);
        out(d); // 767

        //随机生成 0到2的numBits次方 -1的随机数  
        BigInteger e = new BigInteger(10, new Random());
        out(e); // 363

        //signum为符号位: 1为正, 0为0, -1为负  
        BigInteger f = new BigInteger(-1, bt);
        out(f); // -767

        //随机生成一个 长度为bitLength的, 可能性大于(1-1/(2的certainty次方))是素数 的数  
        BigInteger g = new BigInteger(10, 1, new Random());
        out(g); // 613

        //常量  
        //0  
        a = BigInteger.ZERO;
        //1  
        a = BigInteger.ONE;
        //10  
        a = BigInteger.TEN;


        //静态方法  
        //随机生成一个 长度为bitLength的可能是素数的数  
        out(BigInteger.probablePrime(10, new Random())); // 587

        //值等于val的值  
        out(BigInteger.valueOf(10)); // 10 

        // a = 10, b = 3
        //加法a+b  
        out(a.add(b)); // 13 

        //减法a-b  
        out(a.subtract(b)); // 7

        //乘法a*b  
        out(a.multiply(b)); // 30

        //除法a/b  
        out(a.divide(b)); // 3

        a = BigInteger.valueOf(-5);
        //取模a%b b需大于0; 5mod3= 2; -5mod3=1;  
        out(a.mod(b));  // 1

        //求余 5rem3=2 -5rem3=-2 5rem-3=2 -5rem-3=-2  
        out(a.remainder(b)); // -2  

        //[0]为a/b [1]为a%b; 数组0值为商，数组1值为取余 
        out(a.divideAndRemainder(b)); //   

        //a==b?  
        out(a.equals(b)); //false

        //符号位：a的正负， 正为1， 0为0， 负为-1  
        out(a.signum()); // -1  

        //绝对值|a|  
        out(a.abs()); // 5

        //比较a>b返回1 a==b返回0 a<b返回-1  
        out(a.compareTo(b)); // -1

        //相反数-a  
        out(a.negate()); // 5

        //取最大数，max(a,b)  
        out(a.max(b)); // 3

        //取最小值，min(a, b)  
        out(a.min(b)); // -5

        a = BigInteger.valueOf(2);
        //次方a的3次方  
        out(a.pow(3)); // 8
        out(a.pow(4)); // 16
        out(a.pow(5)); // 32
        out(a.pow(6)); // 64

        a = BigInteger.valueOf(4);
        out(a); // 4
        out(b); // 3
        //a的-1次方 %b; 2.pow(-1) % 3
        out(a.modInverse(b));  // 1

        out(c); // 767
        //a的b次方 %c; 4.pow(3) % c  
        out(a.modPow(b, c));  // 64

        //~a  
        out(a.not()); //-5 

        //a^b  4^3
        out(a.xor(b)); // 7
        out(3 ^ 4); // 7
        out(5 ^ 6); // 3

        //a|b  4|3
        out(a.or(b)); // 7

        //a&b  4&3
        out(a.and(b)); // 0  

        //a左移n位 (a << n)  
        out(a.shiftLeft(10)); //  4096

        //a右移n位 (a >> n)  
        out(a.shiftRight(10)); // 0 

        // a & ~b
        out(a.andNot(b)); // 4

        //二进制形式中把第n位二进制设为0 (a & ~(1<<n))  
        out(a.clearBit(10));  // 4

        //二进制形式中把第n位二进制设为1 (a | (1<<n))  
        out(a.setBit(10));  // 1028

        //二进制形式中第n位二进制是否为1 (a & (1<<n)) != 0)  
        out(a.testBit(10)); // false 

        //二进制形式中把第n位二进制翻转 (a ^ (1<<n))  
        out(a.flipBit(10));  // 1028

        //二进制形式中最低位1后面0的个数 (a == 0? -1 : log2(a & -a))  
        out(a.getLowestSetBit()); //2 

        //二进制形式中与符号不同的位的数量 7为3 -7为2；负数最高位和正数最高位  
        out(a.bitCount());  // 1

        //二进制形式中不包括符号位的长度  
        out(a.bitLength());  // 3

        //a和b的最大公约数  
        out(a.gcd(b));  // 1

        //a可能为素数返回true a一定为合数返回false 素数可能性大于(1-1/(2的certainty次方))  
        out(a.isProbablePrime(10)); // false 

        //大于a的可能为素数的第一个整数。  
        out(a.nextProbablePrime());  // 5

        //a的哈希码  
        out(a.hashCode());   // 4

        //a的二进制补码形式  
        out(a.toByteArray()); // 4 

        //a的十进制字符串形式  
        out(a.toString()); // 4

        //a的radix进制字符串形式  
        out(a.toString(2)); // 100  
        out(a.toString(16)); // 4  


        //JAVA 1.8  
        a.byteValueExact();
        a.intValueExact();
        a.longValueExact();
        a.shortValueExact();
    }

    @Test
    public void testAuth() {
        int a = 1; // 001 状态a
        int b = 2; // 010 状态b
        int c = 4; // 100 状态c

        int ab = a | b; // 001 | 010 = 011 初始状态  

        System.out.println(ab); // 3
        System.out.println(Integer.toBinaryString(ab)); // 11
        System.out.println(Integer.toString(ab, 2)); // 11
        System.out.println(Integer.toUnsignedString(ab, 2)); // 11

        System.out.println(ab | c); // 011 | 100 = 111 添加c的状态  
        System.out.println(ab & (~b)); // 011 & (~010) = 011 & 101 = 001 去除b的状态  

        System.out.println((ab & b) == b); // 011 & 010 = 010 判断是否有b的权限：(ab & b)==b  
        System.out.println((ab & c) == c); // 011 & 100 = 000  
    }

    @Test
    public void testAuth2() {

        /**
         * 四种权限 ，当前定义为int，以下二进制表示只取后四位作说明
         */

        // 添加
        int c = 1;// ...0001=2^0
        // 查询
        int r = 2;// ...0010=2^1
        // 修改
        int u = 4;// ...0100=2^3
        // 删除
        int d = 8;// ...1000=2^4

        /**
         *
         * 大家可以观察四种权限的二进制表示的规律 ，都是2的N次方，
         * 就表示本身，添加权限有最后一位为其它为0,查询倒数第二位为1其它都为0，
         * 修改倒数第三个为1其它都为0，删除倒数第四个为1其它都为0
         *
         */

        /**
         * 这样表示有哪种权限时可以用 |(按位或) 操作
         */

        // 用户A有添加和修改权限/查询
        int usera = c | r | u;

        // 用户B有添加和删除权限
        int userb = c | d;

        /**
         * 判断用户是否有某种权限用用户权限和要判断的权限进行 &(按位与) 操作，
         * 结果为要判断的权限值时表示用户有此权限，否则没有此权限
         */
        System.out.println();
        if ((usera & u) == u) {
            System.out.println("用户a有更新u权限");
        } else {
            System.out.println("用户a没有有更新u权限");
        }

        /**
         * 给用户添加权限用用户权限和要添加的权限|(按位或) 操作再覆盖之前权限值
         */
        System.out.println();
        if ((userb & u) == u) {
            System.out.println("用户b有更新u权限");
        } else {
            System.out.println("用户b没有更新u权限");
        }

        System.out.println("==>给用户b添加更新权限");
        userb = userb | u;

        if ((userb & u) == u) {
            System.out.println("用户b有更新u权限");
        } else {
            System.out.println("用户b没有更新u权限");
        }

        /**
         * 取消用户某种权限,用用户权限和要取消的权限按位取反后进行按位 操作，再覆盖之前权限值
         */
        System.out.println();
        if ((usera & r) == r) {
            System.out.println("用户a有查询r权限");
        } else {
            System.out.println("用户a没有查询r权限");
        }

        System.out.println("==>取消用户a的查询r权限");
        usera = usera & (~r);

        if ((usera & r) == r) {
            System.out.println("用户a有查询r权限");
        } else {
            System.out.println("用户a没有查询r权限");
        }
    }

    public void out(byte[] buff) {
        for (byte b : buff) {
            System.out.print(b + ",");
        }
        System.out.println();
    }

    public void out(Object o) {
        System.out.println(o);
    }
}
