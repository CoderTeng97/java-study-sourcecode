package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * FileInputStream
 * @author Teng
 * 字符流
 */

public class FileStu6 {
	//字符流
	//1.编码问题
	//2.认识文本和文本文件
	//java的文本（char）是16位无符号整数，是字符的unicode编码（双字节编码）
	//文件时byte byte..的数据序列
	//文本文件时文本（char）序列按照某种编码安安（utf-8，utf-16be，gbk）
	//序列化为byte的存储结果
	//3.字符流 分为(Reader,Writer)
	//字符的处理，一次处理一个字符 ，字符的底层仍然是基本字节序列

	//字符流的基本实现
	//InputStreamReader 完成byte流解析为char流，按照编码解析
	//OutputStreamWriter 提供char流到byte流，按照编码处理

	public static void main(String[] args) throws IOException{
		FileInputStream in = new FileInputStream("E:\\JavaIo\\日记1.txt");
		InputStreamReader isr = new InputStreamReader(in);//默认项目的编码gbk,可以指定编码，防止乱码出现
		int b;
		//一个一个的读取
//		while((b= isr.read())!=-1){
//			System.out.print((char)b);
//		}
		//批量读取
		char[] buff = new char[2*1024];
		while((b= isr.read(buff,0,buff.length))!=-1){
			String s = new String(buff,0,b);
			System.out.print(s);
		}
	}

}
