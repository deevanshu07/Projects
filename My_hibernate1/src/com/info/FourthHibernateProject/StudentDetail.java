package com.info.FourthHibernateProject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*Make this class entry in hibernate config file*/
@Entity
@Table(name = "STUDENT_DETAIL") // Make sure the db is same
public class StudentDetail {

	@Id
	@GeneratedValue(generator = "newGenerator") // name of the primary key
												// generator
	@GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = {
			@Parameter(value = "student", name = "property") })
	private int student_id;

	@Column(name = "student_mobile_number")
	private String mobileNumber;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;

	public StudentDetail() {

	}

	public StudentDetail(int student_id, String mobileNumber) {
		super();
		this.student_id = student_id;
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public Student getStudent() {
		return student;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "StudentDetail [student_id=" + student_id + ", mobileNumber="
				+ mobileNumber + ", student=" + student + "]";
	}

}
