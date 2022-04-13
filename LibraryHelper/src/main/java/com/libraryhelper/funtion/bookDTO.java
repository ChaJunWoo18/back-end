package com.libraryhelper.funtion;

public class bookDTO {
	private int id = 0;
	private String book_name = null;
	private String writer = null;
	private boolean isMisalign = false;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isMisalign() {
		return isMisalign;
	}
	public void setMisalign(boolean isMisalign) {
		this.isMisalign = isMisalign;
	}
	
	
}