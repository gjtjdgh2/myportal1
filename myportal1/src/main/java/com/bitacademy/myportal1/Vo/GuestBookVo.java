package com.bitacademy.myportal1.Vo;

import java.util.Date;

public class GuestBookVo {
	//필드
	private Long no;// pk
	private String name;
	private String password;
	private String content;	
	private Date regDate;
	
	//생성자
	public GuestBookVo() {
		
	}
	public GuestBookVo(Long no,String password) {
		this.no =no;
		this.password=password;
	}
	public GuestBookVo(String name, String password, String content) {
		super();
		this.name = name;
		this.password = password;
		this.content = content;
	}
	public GuestBookVo(Long no, String name, String password, String content, Date regDate) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regDate = regDate;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
}
