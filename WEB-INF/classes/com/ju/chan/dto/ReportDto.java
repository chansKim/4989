package com.ju.chan.dto;

import java.util.*;

public class ReportDto {
	int e_id;
	String m_mail;
	int r_id;
	String e_content;
	Date ctime;
	Date mtime;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
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
		return "ReportDto [e_id=" + e_id + ", m_mail=" + m_mail + ", r_id="
				+ r_id + ", e_content=" + e_content + ", ctime=" + ctime
				+ ", mtime=" + mtime + "]";
	}

	
}
