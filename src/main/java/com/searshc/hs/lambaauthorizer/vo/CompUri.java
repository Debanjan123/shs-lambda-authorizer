package com.searshc.hs.lambaauthorizer.vo;

import com.searshc.hs.lambaauthorizer.utils.HsToStringBuilder;

public class CompUri {

	private String uri;
	private String role;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		HsToStringBuilder builder = new HsToStringBuilder(this);
		builder.append("uri", uri);
		builder.append("role", role);
		return builder.toString();
	}

}
