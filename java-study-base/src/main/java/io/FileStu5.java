package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * FileInputStream
 * @author Teng
 *
 */
public class FileStu5 {
	//Io流（输入流，输出流）
	//(1)字节流，字符流
	//InputStream 抽象了应用程序读取数据的方式
	//OutputStream 抽象了应用程序写出数据的方式
	//EOF = End 读到-1就读到结尾
	//(3)输入流的基本方法  int b = in.read();读取一个字节符号填充到int底8位。-1是EOF
	//in.read(byte[] buf) 读取数据填充到字节数组
	//in.read(byte[] buf，int start,int size) 读取数据到字节数组buf从buf的start位置开始存放size长度的数据
	//(4)输出流基本发发
	//out.write(int b)写出一个byte到流，b的底8位
	//out.write(byte[] buf) 将buf字节数组都写入到流
	//out.write(byte[] buf，int start,int size) 字节数组buf从buf的start位置开始写size长度的字节到流
	//(5) FileInputStream ---->具体实现了在文件上读取数据
	public static void main(String[] args) throws IOException {
		//IOUtils.printHex("E:\\JavaIo\\MybatisCodeGenerator.java");
		IOUtils.printHexByByteArray("E:\\JavaIo\\MybatisCodeGenerator.java");
	}


}
