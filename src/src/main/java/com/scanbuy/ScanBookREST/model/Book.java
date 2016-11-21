package com.scanbuy.ScanBookREST.model;

/**
 * Kiran Pandharpatte
 */
public class Book {
	
	private long barcode;
	private String title;
	private String author;
	private int numberOfPages;
	private String read;
	
	public Book(){
		
	}
	
	public Book(long barcode, String title, String author, int numberOfPages, String read) {		
		this.barcode = barcode;
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.read = read;
	}
	
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}

}
