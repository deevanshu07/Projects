package com.info.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 interface DemoManager {
 public String getServiceName(String name);
 }

 class DemoManagerImpl implements DemoManager {

 @Override
 public String getServiceName(String name) {
 // TODO Auto-generated method stub
 return name;
 }

 }*/

/*@Configuration
 @Scope("prototype")
 class ApplicationConfiguration {
 @Bean(name = "demoService")
 public DemoManager helloWorld() {
 return new DemoManagerImpl();
 }
 }
 */

/*@IMPORT EXAMPLE*/

/*class BeanA {
 public void doSomething() {
 System.out.println("Inside Bean A");
 }
 }

 class BeanB {
 public void doSomething() {
 System.out.println("Inside Bean B");
 }
 }




 @Configuration
 class AppConfig{
 @Bean
 public BeanA getBeanA(){
 return new BeanA();
 }

 }


 @Configuration
 @Import(value={AppConfig.class})
 class NewAppConfig{
 @Bean(name="beanB")
 public BeanB getBean(){
 return new BeanB();
 }
 }
 */

class AdminUser implements User {

	@Override
	public void doSomething() {
		System.out.println("This is Admin user");

	}

}

@Configuration
class AppConfig {
	@Bean
	public User getAdminUser() {
		return new AdminUser();
	}

	@Bean
	public User getGuestUser() {
		return new Guestuser();
	}
}

class Guestuser implements User {

	@Override
	public void doSomething() {
		System.out.println("This is guest user");

	}

}

class AB {
	private String name;
	private int userId;

	public AB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AB(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());

		result = prime * result + userId;
		System.out.println(result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AB other = (AB) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public int getUserId() {
		return userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AB [userId=" + userId + ", name=" + name + "]";
	}

}

class A {
	int i = 10;

	void display() {
		System.out.println(i);
	}
}

class B extends A {
	int i = 20;

	void display() {
		System.out.println(this.i);
	}
}

public class Main {

	public static void main(String[] args) {

	}

}

interface User {
	public void doSomething();
}