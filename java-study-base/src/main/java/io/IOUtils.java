package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {
	/**
	 * 读取指定文件内容，安装16进制输出到控制台
	 *并且输出10byte换行
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHex(String fileName) throws IOException{
		//把文件作为字节流进行读的操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			if(b <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
			if(i++%10==0){
				System.out.println();
			}
		}
		in.close();
	}

	public static void printHexByByteArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		//打开下面的注释，然后注释上面的你会发现奇妙之处
		byte[] buf = new byte[5];
		//从in中批量读取字节，放到buf这个字节数组中，
		//最多放buf.length 个 ,返回的是读到字节的个数
		int bytes = in.read(buf); //一次性读完，说明字节数组足够大
		int j = 1;
		for(int i = 0;i<bytes;i++){
			if(buf[i]<0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i])+" ");
			if(j++%10==0){
				System.out.println();
			}
		}
		//当一次性不能读完的情况下（灵活）
		/**int bytes = 0;
		 int j = 1;
		 //read如果没有读完会返回剩下未读写的字节流，读完返回-1
		 while((bytes = in.read(buf,0,buf.length))!=-1){
		 for(int i = 0;i<bytes;i++){
		 System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
		 if(j++%10==0){
		 System.out.println();
		 }
		 }

		 }**/
		in.close();
	}

	/**
	 * 字节批量读取  效率最高速度最快 耗费性能
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile,File desFile) throws IOException{
		if(!srcFile.exists()){
			throw new FileNotFoundException("文件不存在");
		}
		if(!srcFile.isFile()){
			throw new FileNotFoundException(srcFile+"不是文件");
		}

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(desFile);
		byte[] buf = new byte[2*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();
		}
		in.close();
		out.close();
	}
	/**
	 * 缓冲读取 性能更优
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile,File desFile) throws IOException{
		if(!srcFile.exists()){
			throw new FileNotFoundException("文件不存在");
		}
		if(!srcFile.isFile()){
			throw new FileNotFoundException(srcFile+"不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(desFile)
		);
		int c;
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();
		}
		bos.close();
		bis.close();

	}
}

