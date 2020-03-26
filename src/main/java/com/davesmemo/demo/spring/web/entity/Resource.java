package com.davesmemo.demo.spring.web.entity;

public class Resource {

	private Long id;

	private String msg;

	public Resource() {
		this.id = (long)(Math.random() * 10000);
		this.msg = "I'm resource " + this.id;
	}
	
	public Resource(Long id) {
		this.id = id;
		this.msg = "I'm resource " + this.id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
