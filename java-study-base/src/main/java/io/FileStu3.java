package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


/**
 * RandomAccessFile 类的使用
 * @author Teng
 *
 */
public class FileStu3 {
	//RandomAccessFile  java提供的对文件内容的访问，可以读写文件
	//支持随机访问文件，可以访问文件的任意位置

	//(1)java文件模型 ：在硬盘上的问价你是 byte byte byte存储的，是数据的集合
	//(2)打开文件：有两种模式"rw(读写)",r(只读)
	//RandomAccessFile raf = new RandomAccessFile(file,"rw")
	//文件指针，打开文件时指针在开头 pointer = 0
	//(3)写方法
	//raf.write(int)--->只写一个字节（后8位）,同时指向下一个位置，准备再次写入
	//(5)读方法
	//int b = raf.read();---->读一个字节

	//（5） 文件读写完成后一定要关闭,不然会产生一些错误
	public static void main(String[] args) throws IOException {
		File file = new File("demo");
		File file2 = new File("demo\\demo.txt");
		if(!file.isDirectory()){
			file.mkdir();
		}
		if(!file.isDirectory()){
			file2.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file2,"rw");
		//指针的位置
		System.out.println(raf.getFilePointer());
		//写
		raf.write('B');
		System.out.println(raf.length());
		//写完读文件 必须把指针移到头部
		raf.seek(0);
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		String str = new String(buf);
		System.out.println(str);
		raf.close();
	}
}
