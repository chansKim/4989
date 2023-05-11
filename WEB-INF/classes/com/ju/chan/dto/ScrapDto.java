package com.ju.chan.dto;

import java.util.*;

public class ScrapDto {
	
	int l_id;
	int r_id;
	String m_mail;
	Date ctime;
	Date mtime;
	
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
		return "ScrapDto [l_id=" + l_id + ", r_id=" + r_id + ", m_mail="
				+ m_mail + ", ctime=" + ctime + ", mtime=" + mtime + "]";
	}
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	
}
