package io;

import java.io.File;
import java.io.IOException;

/**
 * 列出file的一些常用操作 如过滤，遍历等操作
 * @author K
 *
 */
public class FileUtils {
	/**
	 * 列出指定目录下包括其子目录的所有文件
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
		//list() 返回目录下的文件，不包含子目录的文件
//		String[] fileNames = dir.list();
//		for (String name : fileNames) {
//			System.out.println(name);
//		}
		//如果要遍历子目录下的内容需要构造成File对象做递归操作，File提供了直接返回子目录的File对象
		File[] files = dir.listFiles();
		if(files!=null&&files.length > 0){
			for(File file : files){
				if(file.isDirectory()){
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}

	}

}