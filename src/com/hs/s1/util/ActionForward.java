package com.hs.s1.util;

public class ActionForward {

	private String path;
	private boolean check; // true = forward, false = redirect

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
