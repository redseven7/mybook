package search;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import po.book;
public class addbook extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "delete.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		book book = new book();
		book.setIsbn(request.getParameter("isbn").trim());
		book.setTitle(request.getParameter("title").trim());
		book.setAuthorid(request.getParameter("authorid").trim());
		book.setPublisher(request.getParameter("publisher").trim());
		book.setPublishdate(request.getParameter("publishdate").trim());
		book.setPrice(request.getParameter("price").trim());
		if(database.addInfo(book)){

			request.setAttribute("message", "书名为"+book.getTitle()+"图书信息添加成功！");
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
}