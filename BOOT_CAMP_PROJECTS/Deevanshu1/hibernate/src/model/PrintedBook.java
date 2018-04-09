package model;

public class PrintedBook extends Book{

@Override
	public String toString() {
		return "PrintedBook [noOfPages=" + noOfPages + ", ISBN=" + ISBN + "]";
	}
int noOfPages;
String ISBN;


public PrintedBook(int id1, String name, String author, int noOfPages,
		String iSBN) {
	super(id1, name, author);
	this.noOfPages = noOfPages;
	ISBN = iSBN;
}
public int getNoOfPages() {
	return noOfPages;
}
public void setNoOfPages(int noOfPages) {
	this.noOfPages = noOfPages;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public PrintedBook(int id1, String name, String author) {
	super(id1, name, author);
	// TODO Auto-generated constructor stub
}
}
