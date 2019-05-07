package io;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class FileStu {
	//file 常见用法
	/**	public static void main(String[] args) {
	 File file = new File("E:\\JavaIo");
	 //是否存在
	 System.out.println(file.exists());
	 if(!file.exists()){
	 file.mkdir();//创建一级目录
	 file.mkdirs();//创建多级目录
	 }else{
	 //file.delete();//删除
	 }

	 //是否是一个目录，如果是true，或则不是目录不存在返回false
	 System.out.println(file.isDirectory());
	 //判断是否是一个文件
	 System.out.println(file.isFile());
	 //File file2 = new File("E:\\JavaIo\\日记1.txt");
	 File file2 = new File("E:\\JavaIo","日记2.txt");
	 if(!file2.exists()){
	 try {
	 file2.createNewFile();
	 } catch (IOException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }else{
	 //file 常见api
	 System.out.println(file);
	 System.out.println(file2.getAbsolutePath());
	 System.out.println(file2.getName());
	 System.out.println(file2.getParent());
	 }

	 }
	 * @throws UnsupportedEncodingException
	 **/

	//字符编码
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s1 = new String("文件file");
		byte[] byte1 = s1.getBytes("utf-8"); //获取字符的字符流 可以指定字符流编码
		for (byte b : byte1) {
			//Integer.toHexString(b&0xff)获取16进制的字符流
			System.out.println(Integer.toHexString(b&0xff)+" ");
		}
	}


}


