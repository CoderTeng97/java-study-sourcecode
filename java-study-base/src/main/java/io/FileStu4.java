package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * FileOutputStream
 * @author Teng
 *
 */
public class FileStu4 {
	//FileOutputStream 实现了向文件中写出byte数据的方法
	//DataOutputStream/DataInputStream
	//对“流” 功能的扩展，可以更加方便的读取int，long，字符等类型数据

	public static void main(String[] args) throws IOException {
		//如果该问件不存在，则直接创建，如果存在，删除后创建
		//写入
		FileOutputStream out = new FileOutputStream("demo//out.dat");
		out.write('A');
		out.write('B');
		IOUtils.printHex("demo\\out.dat");
		out.close();

		//复制
		File file1 = new File("E:\\JavaIo\\MybatisCodeGenerator.java");
		File file2 = new File("demo\\mybatis.java");
		//IOUtils.copyFile(file1,file2);
		//使用BufferedInput/OutputStream 文件拷贝
		IOUtils.copyFileByBuffer(file1,file2);
	}


}
