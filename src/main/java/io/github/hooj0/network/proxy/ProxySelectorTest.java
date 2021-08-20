package io.github.hooj0.network.proxy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ProxySelectorTest {

    public void setLocalProxy() {
        Properties prop = System.getProperties();
        prop.setProperty("http.proxyHost", "192.168.0.96");
        prop.setProperty("http.proxyPort", "8080");
        prop.setProperty("http.nonProxyHosts", "localhost|10.20.*");
        prop.setProperty("https.proxyHost", "10.10.0.96");
        prop.setProperty("https.proxyPort", "443");
        prop.setProperty("ftp.proxyHost", "10.10.0.96");
        prop.setProperty("ftp.proxyPort", "2121");
        prop.setProperty("ftp.nonProxyHosts", "localhost|10.10.*");
        prop.setProperty("socks.ProxyHost", "10.10.0.96");
        prop.setProperty("socks.ProxyPort", "1080");
    }

    public void removeLocalProxy() {
        Properties prop = System.getProperties();
        prop.remove("http.proxyHost");
        prop.remove("http.proxyPort");
        prop.remove("http.nonProxyHosts");
        prop.remove("https.proxyHost");
        prop.remove("https.proxyPort");
        prop.remove("ftp.proxyHost");
        prop.remove("ftp.proxyPort");
        prop.remove("ftp.nonProxyHosts");
        prop.remove("socksProxyHost");
        prop.remove("socksProxyPort");
    }

    public void showHttpProxy()
            throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/");
        URLConnection conn = url.openConnection();
        Scanner scan = new Scanner(conn.getInputStream());

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }

    public static void main(String[] args) throws IOException {
        ProxySelectorTest test = new ProxySelectorTest();
        test.setLocalProxy();
        test.showHttpProxy();
        test.removeLocalProxy();
    }
}
