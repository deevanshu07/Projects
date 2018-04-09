package model;

public class Book {


private int id1;
public int getId1() {
	return id1;
}
public void setId1(int id1) {
	this.id1 = id1;
}
public String getName() {
	return name;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(int id1, String name, String author) {
	super();
	this.id1 = id1;
	this.name = name;
	this.author = author;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
private String name;
private String author;
}


