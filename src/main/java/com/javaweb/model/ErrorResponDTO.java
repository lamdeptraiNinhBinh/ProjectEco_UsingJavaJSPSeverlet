package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponDTO {
	private String err;

	private List<String> detail = new ArrayList<>();

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public List<String> getDetail() {
		return detail;
	}

	public void setDetail(List<String> detail) {
		this.detail = detail;
	}

}
