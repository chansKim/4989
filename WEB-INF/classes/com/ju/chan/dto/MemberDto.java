package com.ju.chan.dto;

import java.io.Serializable;
import java.util.Date;

//CREATE table member (
//		m_email varchar(20),
//		m_password varchar(48) NOT NULL,
//		m_name varchar(20),
//		m_main_photo int,
//	    	m_main_mention varchar(100),
//		m_phone varchar(20),
//		ctime datetime NOT NULL,
//		mtime datetime NOT NULL,
//	    	resource_id varchar(50),
//	 	PRIMARY KEY(m_email)
//	);


public class MemberDto implements Serializable{
	String m_mail;
	String m_password;
	String m_name;
	int m_back_photo;
	int m_main_photo;
	String m_main_mention;
	String m_phone;
	Date ctime;
	Date mtime;

	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_back_photo() {
		return m_back_photo;
	}
	public void setM_back_photo(int m_back_photo) {
		this.m_back_photo = m_back_photo;
	}
	public int getM_main_photo() {
		return m_main_photo;
	}
	public void setM_main_photo(int m_main_photo) {
		this.m_main_photo = m_main_photo;
	}
	public String getM_main_mention() {
		return m_main_mention;
	}
	public void setM_main_mention(String m_main_mention) {
		this.m_main_mention = m_main_mention;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
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

	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public MemberDto() {
		super();
	}
	public MemberDto(String m_mail, String m_password, String m_name,
			int m_back_photo, int m_main_photo, String m_main_mention,
			String m_phone, Date ctime, Date mtime) {
		super();
		this.m_mail = m_mail;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_back_photo = m_back_photo;
		this.m_main_photo = m_main_photo;
		this.m_main_mention = m_main_mention;
		this.m_phone = m_phone;
		this.ctime = ctime;
		this.mtime = mtime;
	}
	@Override
	public String toString() {
		return "MemberDto [m_mail=" + m_mail + ", m_password=" + m_password
				+ ", m_name=" + m_name + ", m_back_photo=" + m_back_photo
				+ ", m_main_photo=" + m_main_photo + ", m_main_mention="
				+ m_main_mention + ", m_phone=" + m_phone + ", ctime=" + ctime
				+ ", mtime=" + mtime + "]";
	}

	
	
	
	
}
