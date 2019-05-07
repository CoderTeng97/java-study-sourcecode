package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;

/**
 * FileInputStream
 * @author Teng
 * BufferedReader/BufferedWriter
 *   readLine/PrintWriter 可以一行一行的读取
 */

public class FileStu8 {
	//

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("E:\\JavaIo\\日记1.txt"))
		);

		PrintWriter pw = new PrintWriter("demo\\riji.txt");
		String line;
		while((line = br.readLine())!=null ){
			System.out.println(line);
			pw.append(line);
			pw.flush();
		}
		//一次读一行的好处，接受字符串
	}


}

