package com.ju.chan.dto;

public class CategoryDto {
//	c_id int auto_increment,
//	c_name varchar(100),
	
	int c_id;
	String c_name;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public CategoryDto(int c_id, String c_name) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
	}
	
	public CategoryDto(){
	}
	
	@Override
	public String toString() {
		return "CategoryDto [c_id=" + c_id + ", c_name=" + c_name + "]";
	}
	
}

