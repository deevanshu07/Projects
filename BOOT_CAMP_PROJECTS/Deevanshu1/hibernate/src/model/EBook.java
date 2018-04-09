package model;

public class EBook extends Book
{

@Override
	public String toString() {
		return "EBook [size=" + size1 + ", type=" + type1 + "]";
	}
private String size1;
public String getSize1() {
	return size1;
}

public void setSize1(String size1) {
	this.size1 = size1;
}

public String getType1() {
	return type1;
}

public void setType1(String type1) {
	this.type1 = type1;
}
private String type1;


public EBook(int id1, String name, String author, String size1, String type1) {
	super(id1, name, author);
	this.size1 = size1;
	this.type1 = type1;
}

public EBook(int id1, String name, String author) {
	super(id1, name, author);
	// TODO Auto-generated constructor stub
}

}
