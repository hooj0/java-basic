package io.github.hooj0.network.url;

import io.github.hooj0.BasedTests;

import java.net.URL;

/**
 * url test
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 15:08:06
 */
public class URLTest extends BasedTests {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/API/ext2/docs/index.html?query=背影&author=朱自清");
        out("访问资源名称：" + url.getFile());
        out("主机名称：" + url.getHost());
        out("获取访问的路径：" + url.getPath());
        out("获取访问的端口：" + url.getPort());
        out("获取访问的默认端口：" + url.getDefaultPort());
        out("获取协议名称：" + url.getProtocol());
        out("获取查询字符串部分：" + url.getQuery());//?号后面的参数部分
        out("授权：" + url.getAuthority());
        out("内容：" + url.getContent());
        out("获取访问资源引用：" + url.getRef());
        out("获取userInfo：" + url.getUserInfo());
        out(url.toURI().getQuery());
    }
}
