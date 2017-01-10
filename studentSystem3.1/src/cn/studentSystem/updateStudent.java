package cn.studentSystem;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ittx.web.db.StudentDB;
import com.ittx.web.db.bean.Student;

import utils.FileUtil;

public class updateStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		HashMap<String, String> parameterMap = new HashMap<>();
		
		// -----保存参数到hashMap并上传新头像-----
				uploadHeader(request, parameterMap);

				// ----删除原头像-----
				deleteHeaderImg(parameterMap);

				// -----修改数据库字段----
				updateStudent(parameterMap);
				response.sendRedirect(request.getContextPath()+"/showStudent.jsp");
		
	}
	private void updateStudent(HashMap<String, String> parameterMap) {
		String userName = parameterMap.get("userName");
		String nums = parameterMap.get("userNumber");
		String age = parameterMap.get("userAge");
		String sex = parameterMap.get("userSex");
		String header_url = parameterMap.get("header_img");
		int num = Integer.parseInt(nums);
		int ages = Integer.parseInt(age);
		boolean sexs = sex.equals("true") ? true : false;

		Student stu = new Student(userName, num, ages, sexs, header_url);
		StudentDB.getInstance().updateStudent(stu);

	}
	private void deleteHeaderImg(HashMap<String, String> parameterMap) {
		String number = parameterMap.get("userNumber");
		String header=parameterMap.get("header_img");
		Student student = StudentDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		String header_img = student.getHeader();
		String header_file = getServletContext().getRealPath("/") + header_img;
		System.out.println("header_file ：" + header_file);
		File file = new File(header_file);
		if(header.equals("")){ //不删除原头像
			parameterMap.put("header_img", header_img);
			return;
		}
		if (file.exists()) {
			file.delete();
		}
	}
	private void uploadHeader(HttpServletRequest request, HashMap<String, String> parameterMap) {
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> fileItemLists = null;
		try {
			fileItemLists = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> iterator = fileItemLists.iterator();
		while (iterator.hasNext()) {
			FileItem fileItem = iterator.next();
			// 如果是表单数
			if (fileItem.isFormField()) {
				String filedName = fileItem.getFieldName();
				String fileValue;
				try {
					fileValue = fileItem.getString("UTF-8");
					parameterMap.put(filedName, fileValue);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else {// 文件操作
				if(fileItem.getName()==null || fileItem.getName().equals("")){ //表示未修改头像图片
					parameterMap.put(fileItem.getFieldName(), "");
					continue;
				}
				String rootDir = getServletContext().getRealPath("/");
				String fileDir = "upload/" + fileItem.getName();
				File file = new File(rootDir + fileDir);
				FileUtil.createFile(file);
				
				try {
					fileItem.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}

				parameterMap.put(fileItem.getFieldName(), fileDir);
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
