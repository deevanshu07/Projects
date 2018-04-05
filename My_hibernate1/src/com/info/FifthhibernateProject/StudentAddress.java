package com.info.FifthhibernateProject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*Make this class entry in hibernate config file*/
@Entity
@Table(name = "StudentAddress") // Make sure the db is same
public class StudentAddress {

	@Id
	@GeneratedValue
	@Column(name = "Addrss_id")
	private int id;

	@Column(name = "Address_Detail")
	private String detail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentAddress")
	private Set<Student> students = new HashSet<Student>();

	public StudentAddress() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
