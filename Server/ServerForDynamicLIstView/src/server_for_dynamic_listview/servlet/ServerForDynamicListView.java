package server_for_dynamic_listview.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import server_for_dynamic_listview.servlet.entity.Student;

/**
 * Servlet implementation class ServerForDynamicListView
 */
@WebServlet("/getStudent.do")
public class ServerForDynamicListView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServerForDynamicListView() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--GET--");

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "Alice", 21));
		studentList.add(new Student(2, "Bob", 22));
		studentList.add(new Student(3, "Charlie", 23));
		studentList.add(new Student(4, "Daniel", 21));
		studentList.add(new Student(5, "Ema", 22));
		studentList.add(new Student(6, "Franc", 23));
		studentList.add(new Student(7, "Gavin", 21));
		studentList.add(new Student(8, "Halen", 22));
		studentList.add(new Student(9, "Ian", 23));
		

		/**
		 * *********************************************************************
		 * JSON parsing using json-lib
		 */
		JSONArray jsonArrayOut = JSONArray.fromObject(studentList);
		System.out.println(jsonArrayOut.toString());
		/**
		 * *********************************************************************
		 */
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		PrintWriter out = null;

		try {
			// Now, out can response to the client and write to the client's
			// WebPage
			out = response.getWriter();
			out.print(jsonArrayOut.toString());
			
		} finally {
			if (out != null) {
				out.close();
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
