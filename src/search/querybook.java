package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.book;
import po.author;

public class querybook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
	/*public QueryBook() {
		super();
	}
		
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "queryshow.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		List list=new ArrayList();
		author bookname = new author();
		String name = request.getParameter("name").trim();
		bookname=database.QueryName(name);
		String authorid = bookname.getAuthorid();
		list = database.QueryBooks(authorid);
		request.setAttribute("list", list);
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
