package com.scanbuy.ScanBookREST.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scanbuy.ScanBookREST.model.Book;

/**
 * Kiran Pandharpatte
 */

public class BookService {
	
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	
	public BookService(){
		
	}
	
	/**
	 * Kiran Pandharpatte
	 */
	
	public static void connect(){
		try {				
			String driver = "com.mysql.jdbc.Driver";
		    String connection = "jdbc:mysql://sql2.njit.edu:3306/kcp35";
		    String user = "kcp35";
		    String password = "temerity5";
		    Class.forName(driver);
		    conn = DriverManager.getConnection(connection, user, password);
			System.out.println("Connected");	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//------- GET ALL BOOKS (GET)----------//
	public List<Book> getAllBooks(){
		
		Book book;
		List<Book> bookslist = new ArrayList<Book>();
		
		try {					
			connect();			
			String query = "SELECT * FROM Book";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				book = new Book();
				long bcode = rs.getLong(1);
				book.setBarcode(bcode);
				String title = rs.getString(2);
				book.setTitle(title);
				String author = rs.getString(3);
				book.setAuthor(author);
				int pages = rs.getInt(4);
				book.setNumberOfPages(pages);
				String read = rs.getString(5);
				book.setRead(read);
				bookslist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookslist;		
	}
	
	//------- GET 1 BOOK BY BARCODE (GET)----------//
	public Book getBook(long barcode){
		
		Book book = new Book();
		try {				
			connect();	
			String query = "SELECT * FROM Book WHERE BARCODE=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, barcode);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				long bcode = rs.getLong(1);
				book.setBarcode(bcode);
				String title = rs.getString(2);
				book.setTitle(title);
				String author = rs.getString(3);
				book.setAuthor(author);
				int pages = rs.getInt(4);
				book.setNumberOfPages(pages);
				String read = rs.getString(5);
				book.setRead(read);
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return book;		
	}
	
	//------- ADD 1 BOOK (POST)----------//
	public Book addBook(Book book){
		
		try {						
			connect();	
			long bcode = book.getBarcode();	
			String title = book.getTitle();
			String author = book.getAuthor();
			int pages = book.getNumberOfPages();
			String read = book.getRead();
			
			String query = "INSERT INTO Book VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, bcode);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setInt(4, pages);
			pstmt.setString(5, read);
			int temp = pstmt.executeUpdate();
			if(temp != -1){
				System.out.println("Book Inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return book;
	}
	
	
	//------- UPDATE 1 BOOK BY BARCODE (PUT)----------//
	public Book updateBook(Book book){
		
		try {						
			connect();	
			long bcode = book.getBarcode();	
			String title = book.getTitle();
			String author = book.getAuthor();
			int pages = book.getNumberOfPages();
			String read = book.getRead();
			
			String query = "UPDATE Book" + " SET TITLE=?, AUTHOR=?, NUMBEROFPAGES=?, READBOOK=? " + " WHERE BARCODE=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setInt(3, pages);
			pstmt.setString(4, read);
			pstmt.setLong(5, bcode);
			
			int rs = pstmt.executeUpdate();
			if(rs != -1){
				System.out.println("Book Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return book;
	}
	
	//------- DELETE 1 BOOK BY BARCODE (DELETE)----------//
	public void removeBook(long barcode){
		
		try {				
			connect();	
			String query = "DELETE FROM Book WHERE BARCODE=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, barcode);
			int rs = pstmt.executeUpdate();
			if(rs != -1){
				System.out.println("Book Deleted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

}
