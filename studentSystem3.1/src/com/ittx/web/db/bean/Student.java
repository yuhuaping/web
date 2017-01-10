package com.ittx.web.db.bean;

public class Student {
	private String name;
	private int number;
	private int age;
	private boolean sex;
	private String header;
	
	
	public Student(String name, int number, int age, boolean sex, String header) {
		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
}
