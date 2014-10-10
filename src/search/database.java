package search;
import java.util.ArrayList;
import java.util.List;
//ffffffffffffffff

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import opendb.DBConnection;
import po.book;
import po.author;

public class database {
	private static Connection con; 
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	//添加图书过程
	public static boolean addInfo(book book){
		
	    boolean flag=false;
	    try{
	    	con=DBConnection.getConnection();
			stmt=con.prepareStatement("insert into book "+"values(?,?,?,?,?,?)");
			stmt.setString(1,book.getIsbn());
			stmt.setString(2,book.getTitle());
			stmt.setString(3,book.getAuthorid());
			stmt.setString(4,book.getPublishdate());
			stmt.setString(5,book.getPrice());
			stmt.setString(6,book.getPublisher());
            if(stmt.executeUpdate()==1)flag=true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		DBConnection.Close(con, stmt);
		return flag;
    }
	//显示图书详情时使用的查询过程
	public static book QueryInfo(String title){
		book book = new book();
	    ResultSet rs=null;
	    try{
			con=DBConnection.getConnection();
			stmt=con.prepareStatement("select * from book where title= '"+title+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
			}
		}catch(SQLException e){
			book=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		DBConnection.Close(con, stmt);
		return book;
	}
	//作者名查询显示书名表过程
	public static List QueryBooks(String authorid){
		List list=new ArrayList();
	    ResultSet rs=null;
	    try{
			con=DBConnection.getConnection();
			stmt=con.prepareStatement("select * from book where authorid= '"+authorid+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book book = new book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		}catch(SQLException e){
			list=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		DBConnection.Close(con, stmt);
		return list;
	}
	
	//作者名查询时按名查询过程
	public static author QueryName(String name){
		author bookname = new author();
	    ResultSet rs=null;
	    try{
			con=DBConnection.getConnection();
			stmt=con.prepareStatement("select * from author where name= '"+name+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				bookname.setAuthorid(rs.getString("authorid"));
				bookname.setName(rs.getString("name"));
				bookname.setAge(rs.getString("age"));
				bookname.setCountry(rs.getString("country"));
			}
		}catch(SQLException e){
			bookname=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		DBConnection.Close(con, stmt);
		return bookname;
	}
	//删除图书过程
	public static boolean deleteInfo(String title){
		boolean flag=false;
		try{
	    	con=DBConnection.getConnection();
			stmt=con.prepareStatement("delete from book where title ='"+title+"'");
            if(stmt.executeUpdate()==1)flag=true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		DBConnection.Close(con, stmt);
		return flag;
	}
}
