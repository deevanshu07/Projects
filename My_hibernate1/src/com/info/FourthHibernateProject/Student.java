package com.info.FourthHibernateProject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*Make this class entry in hibernate config file*/
@Entity
@Table(name = "STUDENT") // Make sure the db is same
public class Student {



	

	@Id
	@GeneratedValue
	private int student_id;

	@Column(name = "student_name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private StudentDetail studentDetail;

	public Student() {

	}

	public Student(int student_id, String name) {
		super();
		this.student_id = student_id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getStudent_id() {
		return student_id;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name
				+ ", studentDetail=" + studentDetail + "]";
	}

}
