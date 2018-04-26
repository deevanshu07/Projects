import java.util.Date;

//Provides information regarding Tickets
public class Ticket 
{


	private int id;
	private String VisitorName;
	private String VisitorOrigin;
	private int Age;
	private String mobile;
	Date bookingDate= new Date();

	
	public Ticket( int id, String visitorName,String visitorOrigin, int age, String mobile,Date bookingDate) 
	{
		super();
		this.bookingDate = bookingDate;
		this.id = id;
		VisitorName = visitorName;
		VisitorOrigin = visitorOrigin;
		Age = age;
		this.mobile = mobile;
	}

	public Date getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getVisitorName() {
		return VisitorName;
	}



	public void setVisitorName(String visitorName) {
		VisitorName = visitorName;
	}



	public String getVisitorOrigin() {
		return VisitorOrigin;
	}



	public void setVisitorOrigin(String visitorOrigin) {
		VisitorOrigin = visitorOrigin;
	}



	public int getAge() {
		return Age;
	}



	public void setAge(int age) {
		Age = age;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	@Override
	public String toString() {
		return "Ticket [id=" + id + ", VisitorName=" + VisitorName
				+ ", VisitorOrigin=" + VisitorOrigin + ", Age=" + Age
				+ ", mobile=" + mobile + ", bookingDate=" + bookingDate + "]";
	}



}
