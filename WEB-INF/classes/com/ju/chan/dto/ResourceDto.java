package com.ju.chan.dto;
import java.io.Serializable;
import java.util.Date;

public class ResourceDto implements Serializable{

	private int r_id;
	private String m_mail;
	private String r_name;
	private String r_link;
	private String r_title;
	private int r_type;
	private String post_type;
	private int number_type; 
	private String r_content;
	private Date ctime;
	private Date mtime;
	
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public int getNumber_type() {
		return number_type;
	}
	public void setNumber_type(int number_type) {
		this.number_type = number_type;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_link() {
		return r_link;
	}
	public void setR_link(String r_link) {
		this.r_link = r_link;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public int getR_type() {
		return r_type;
	}
	public void setR_type(int r_type) {
		this.r_type = r_type;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	@Override
	public String toString() {
		return "ResourceDto [r_id=" + r_id + ", m_mail=" + m_mail
				+ ", r_name=" + r_name + ", r_link=" + r_link + ", r_title="
				+ r_title + ", r_type=" + r_type + ", r_content=" + r_content
				+ ", ctime=" + ctime + ", mtime=" + mtime + "]";
	}
	
	
	
	
	
}
