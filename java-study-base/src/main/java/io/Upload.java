package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Upload extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("upload初始化成功");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("post方法执行开始");
		req.setCharacterEncoding("utf-8");
		//
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		DiskFileItemFactory fatory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fatory);
		try {
			List<FileItem> list = upload.parseRequest(req);
			for(FileItem item :list){
				int len = 0;
				byte[] buffer = new byte[2*1024];
				String UFileName = item.getName();
				File file = new File("E:\\JavaIo\\"+UFileName);
				if(file.exists()){
					file.delete();
				}
				out = new BufferedOutputStream(new FileOutputStream(file));
				in = new BufferedInputStream(item.getInputStream());
				while((len = in.read(buffer,0,buffer.length))!=-1){
					out.write(buffer,0,buffer.length);
					out.flush();
				}
				in.close();
				out.close();
				item.delete();
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("upload销毁");
	}
}

