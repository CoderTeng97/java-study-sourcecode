package io;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileInputStream
 * @author Teng
 * FileReader FileWriter
 */

public class FileStu7 {


	public static void main(String[] args) throws IOException{
		//不支持编码格式化
		//可以追加文本内容
		FileReader fr = new FileReader("E:\\JavaIo\\日记1.txt");
		FileWriter fw = new FileWriter("demo\\日记1.txt");
		//FileWriter fw = new FileWriter("demo\\日记1.txt",true);
		char[] buffer = new char[2056];
		int c;
		while((c = fr.read(buffer,0,buffer.length))!=-1){
			fw.write(buffer, 0, c);
			fw.flush();
		}

		fw.close();
		fr.close();
	}

}

