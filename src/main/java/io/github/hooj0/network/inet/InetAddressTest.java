package io.github.hooj0.network.inet;

import io.github.hooj0.BasedTests;

import java.net.InetAddress;

/**
 * inet地址测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:11:52
 */
public class InetAddressTest extends BasedTests {

    public static void main(String[] args) throws Exception {

        //根据主机名称获取inetAddress的实例
        InetAddress ip = InetAddress.getByName("localhost");
        ip = InetAddress.getByName("127.0.0.1");
        ip = InetAddress.getByName(null);//默认localhost
        //判断是否可以访问
        out("localhost 是否可以访问:" + ip.isReachable(2000));
        //获取ip字符串
        out(ip.getHostAddress());

        //根据原始的ip地址获取inetAddress的实例
        InetAddress local = InetAddress.getByAddress(new byte[]{ 127, 0, 0, 1 });
        out("是否可以访问：" + local.isReachable(5000));
        //获取inetAddress的完全限定域名
        out(local.getCanonicalHostName());
        out("host:" + local.getHostName());

        InetAddress[] ips = InetAddress.getAllByName("localhost");
        for (int i = 0; i < ips.length; i++) {
            out(ips[i] + "###" + ips[i].isSiteLocalAddress());
        }
    }
}
