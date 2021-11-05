package io.github.hooj0.network.udp.multicast.chart;

import java.io.File;
import java.util.List;

/**
 * 加载图标
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 14:58:25
 */
public class LoadIcon {

	/**
	 * 递归读取某文件夹下的所有文件名
	 * @author hoojo
	 * @createDate Sep 24, 2010 12:11:48 PM
	 * @param file 文件夹或文件
	 * @param list 存放文件名的List
	 */
	public void getFileNames(File file, List<String> list) {
		//file.exists()
		if (file.canRead()) {
			if (file.isDirectory()) {
				File[] fileList = file.listFiles();
				for (File f : fileList) {
					getFileNames(f, list);
				}
			} else {
				list.add(file.getName());
			}
		}
	}
}
