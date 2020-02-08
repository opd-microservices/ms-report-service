package com.example.demo.domain;

public class DataElement {
	
	private String data;
	
	public DataElement() {
		super();
	}
	
	public DataElement(String data) {
		this();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getString() {
		return getData();
	}

}
