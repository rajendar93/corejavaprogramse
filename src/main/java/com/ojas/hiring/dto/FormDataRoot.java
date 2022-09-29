package com.ojas.hiring.dto;

import java.util.List;

public class FormDataRoot {

	public List<FormDataDTO> data;

	public List<FormDataDTO> getFormDataDTO() {
		return data;
	}

	public void setFormDataDTO(List<FormDataDTO> formDataDTO) {
		this.data = formDataDTO;
	}

	@Override
	public String toString() {
		return "FormDataRoot [formDataDTO=" + data + "]";
	}
	
	
}
