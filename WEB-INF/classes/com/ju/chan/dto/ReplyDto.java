package com.ju.chan.dto;

import java.util.Date;

public class ReplyDto {
	
	private int id;			//댓글아이디
	private int r_id;	//포스트아이디
	private String m_mail;	//멤버아이디
	private Date ctime;		//생성시간
	private String mtime;		//수정시간
	private String content;	//댓글내용
	private int secretType;	//비밀댓글여부
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSecretType() {
		return secretType;
	}
	public void setSecretType(int secretType) {
		this.secretType = secretType;
	}
	
	
	
}
