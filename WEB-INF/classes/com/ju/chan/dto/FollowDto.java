package com.ju.chan.dto;

import java.io.Serializable;
import java.util.Date;

//create table follow(
//		m_mail varchar(20) NOT NULL,
//		face_mail varchar(20) default NULL,
//		c_id int default null,
//		k_id int default null,
//		ctime datetime NOT NULL,
//		mtime datetime NOT NULL,
//		primary key(m_mail)
//	);

public class FollowDto implements Serializable{
	int f_id;
	String m_mail;
	String face_mail;
	int c_id;
	String k_name;
	Date ctime;
	Date mtime;
	
	public FollowDto() {
		super();
	}
	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}

	public String getFace_mail() {
		return face_mail;
	}

	public void setFace_mail(String face_mail) {
		this.face_mail = face_mail;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getK_name() {
		return k_name;
	}

	public void setK_name(String k_name) {
		this.k_name = k_name;
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
		return "FollowDto [f_id=" + f_id + ", m_mail=" + m_mail
				+ ", face_mail=" + face_mail + ", c_id=" + c_id + ", k_name="
				+ k_name + ", ctime=" + ctime + ", mtime=" + mtime + "]";
	}
	
	
}
