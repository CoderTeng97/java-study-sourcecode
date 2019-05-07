package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class IOPractic1 {


	public static void main(String[] args) throws IOException {
		//newFile();
		randomAccessFilePra();
	}


	//使用RandomAccessFile 读写文件  未解决乱码问题
	public static void randomAccessFilePra() throws IOException{
		RandomAccessFile rFile = new RandomAccessFile("demo\\mybatis.java", "rw");
		byte[] buffer = new byte[2*1024];
		int p;
		rFile.read(buffer);
		String str = new String(buffer,"utf-8");
		System.out.println(str);
		RandomAccessFile rFile2 = new RandomAccessFile("demo\\text.txt", "rw");
		rFile2.write(buffer, 0, buffer.length);;
	}


	//新建文件并查看文件
	public static void newFile(){
		File file = new File("demo\\test.txt");
		if(file.exists()){
			System.out.println("文件已存在");
		}else{
			file.mkdir();
		}
		File file2 = new File("demo");
		if(!file2.isDirectory()){
			System.out.println("不是文件目录");
		}else{
			String[] strs = file2.list();
			for(String s : strs){
				System.out.println(s);
			}
		}

	}
}