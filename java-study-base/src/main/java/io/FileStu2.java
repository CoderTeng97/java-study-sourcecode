package io;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 遍历文件
 */
public class FileStu2 {
	public static void main(String[] args) throws IOException {
		FileUtils.listDirectory(new File("E:\\Program Files (x86)"));
	}
}
