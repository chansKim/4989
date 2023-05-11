package com.ju.chan.dto;

import java.util.*;

public class MessageDto {
	
	int n_id;
	String m_mail;
	String face_mail;
	String n_content;
	int readType;
	Date ctime;
	Date mtime;
	
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
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
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
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public int getReadType() {
		return readType;
	}
	public void setReadType(int readType) {
		this.readType = readType;
	}
	@Override
	public String toString() {
		return "MessageDto [n_id=" + n_id + ", m_mail=" + m_mail
				+ ", face_mail=" + face_mail + ", n_content=" + n_content
				+ ", readType=" + readType + "]";
	}

	
}
