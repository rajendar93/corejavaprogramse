package com.ojas.hiring.dto;

public class FormDataDTO {

	public String name;
	
	public String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FormDataDTO [name=" + name + ", value=" + value + "]";
	}
	
	
	
}
