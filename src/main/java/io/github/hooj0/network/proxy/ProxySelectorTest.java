package io.github.hooj0.network.proxy;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ProxySelectorTest
{
	// ���Ա���JVM������ȱʡ����
	public void setLocalProxy()
	{
		Properties prop = System.getProperties();
		//����HTTP����Ҫʹ�õĴ���������ĵ�ַ
		prop.setProperty("http.proxyHost", "192.168.0.96");
		//����HTTP����Ҫʹ�õĴ���������Ķ˿�
		prop.setProperty("http.proxyPort", "8080");
		//����HTTP���ʲ���Ҫͨ��������������ʵ�������
		//����ʹ��*ͨ����������ַ��|�ָ�
		prop.setProperty("http.nonProxyHosts", "localhost|10.20.*");
		//���ð�ȫHTTP����ʹ�õĴ����������ַ��˿�
		//��û��https.nonProxyHosts���ԣ�������http.nonProxyHosts �����õĹ������
		prop.setProperty("https.proxyHost", "10.10.0.96");
		prop.setProperty("https.proxyPort", "443");
		//����FTP���ʵĴ�����������������˿��Լ�����Ҫʹ�ô��������������
		prop.setProperty("ftp.proxyHost", "10.10.0.96");
		prop.setProperty("ftp.proxyPort", "2121");
		prop.setProperty("ftp.nonProxyHosts", "localhost|10.10.*");
		//����socks����������ĵ�ַ��˿�
		prop.setProperty("socks.ProxyHost", "10.10.0.96");
		prop.setProperty("socks.ProxyPort", "1080");
	}

	// ���proxy����
	public void removeLocalProxy()
	{
		Properties prop = System.getProperties();
		//���HTTP���ʵĴ������������
		prop.remove("http.proxyHost");
		prop.remove("http.proxyPort");
		prop.remove("http.nonProxyHosts");
		//���HTTPS���ʵĴ������������
		prop.remove("https.proxyHost");
		prop.remove("https.proxyPort");
		//���FTP���ʵĴ������������
		prop.remove("ftp.proxyHost");
		prop.remove("ftp.proxyPort");
		prop.remove("ftp.nonProxyHosts");
		//���SOCKS�Ĵ������������
		prop.remove("socksProxyHost");
		prop.remove("socksProxyPort");
	}
	//����HTTP����
	public void showHttpProxy()
		throws MalformedURLException , IOException
	{
		URL url = new URL("http://localhost:8080/");
		//ֱ�Ӵ����ӣ���ϵͳ����ø����õ�HTTP���������
		URLConnection conn = url.openConnection();
		Scanner scan = new Scanner(conn.getInputStream());
		//��ȡԶ������������
		while(scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
	}

	public static void main(String[] args)throws IOException
	{
		ProxySelectorTest test = new ProxySelectorTest();
		test.setLocalProxy();
		test.showHttpProxy();
		test.removeLocalProxy();
	}
}
