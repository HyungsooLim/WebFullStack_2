package com.hs.s1.bankbook;

public class BankbookDTO {

	private int bookNumber;
	private String bookName;
	private double bookRate;
	private String bookSale;

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookRate() {
		return bookRate;
	}

	public void setBookRate(double bookRate) {
		this.bookRate = bookRate;
	}

	public String getBookSale() {
		return bookSale;
	}

	public void setBookSale(String bookSale) {
		this.bookSale = bookSale;
	}

}
