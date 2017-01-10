package cn.studentSystem;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.web.db.StudentDB;
import com.ittx.web.db.bean.Student;

public class deleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决post请求乱码
		response.setContentType("text/html;charset=utf-8");//设置响应编码
		HashMap<String, String> parameterMap = new HashMap<>();
		deleteHeaderImg(parameterMap,request);
		response.sendRedirect(request.getContextPath()+"/showStudent.jsp");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	private void deleteHeaderImg(HashMap<String, String> parameterMap,HttpServletRequest request) {
//		String number = parameterMap.get("num");
		String number=request.getParameter("num");
		System.out.println(number);
		Student student = StudentDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		StudentDB.getInstance().deleteStudent(Integer.parseInt(number));
		String header_img = student.getHeader();
		String header_file = getServletContext().getRealPath("/") + header_img;
		System.out.println("header_file ：" + header_file);
		File file = new File(header_file);
		System.out.println(file);
		if (file.exists()) {
			file.delete();
		}
		
	}

}
