package com.searshc.hs.lambaauthorizer.vo;

import java.util.ArrayList;
import java.util.List;

import com.searshc.hs.lambaauthorizer.utils.HsToStringBuilder;

public class CompUser {

	private String userName;
	private List<String> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRoles() {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		HsToStringBuilder builder = new HsToStringBuilder(this);
		builder.append("userName", userName);
		builder.append("roles", roles);
		return builder.toString();
	}

}