package com.info.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean saveEmployeeByPreparedStament1(final Employee e){
		String query="insert into employee values(?,?,?)"; 
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				
				ps.setInt(1,e.getId());
				ps.setString(2,e.getName());
				ps.setFloat(3, e.getSalary());
				return ps.execute();
			}
			
		} );
		
	}
	
	
	
	public List<Employee> getAllEmployees1(){
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNumber)
					throws SQLException {
				Employee e= new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				return e;
			}
			
		});
	}
	
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee",
				new ResultSetExtractor<List<Employee>>() {
					@Override
					public List<Employee> extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						List<Employee> list = new ArrayList<Employee>();
						while (rs.next()) {
							Employee e = new Employee();
							e.setId(rs.getInt(1));
							e.setName(rs.getString(2));
							e.setSalary(rs.getInt(3));
							list.add(e);
						}
						return list;
					}
				});
	}

	public int saveEmployee1(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','"
				+ e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {
		return jdbcTemplate.update("update employee set salary=? where id=?", e.getSalary(),e.getId());
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

}
