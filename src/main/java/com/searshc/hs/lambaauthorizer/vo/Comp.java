package com.searshc.hs.lambaauthorizer.vo;

import java.util.ArrayList;
import java.util.List;

import com.searshc.hs.lambaauthorizer.utils.HsToStringBuilder;

public class Comp {

	private String name;
	private Integer sessionLife;
	private List<CompUri> uris;
	private List<CompUser> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSessionLife() {
		return sessionLife;
	}

	public void setSessionLife(Integer sessionLife) {
		this.sessionLife = sessionLife;
	}

	public List<CompUri> getUris() {
		if (uris == null) {
			uris = new ArrayList<>();
		}
		return uris;
	}

	public void setUris(List<CompUri> uris) {
		this.uris = uris;
	}

	public List<CompUser> getUsers() {
		if (users == null) {
			users = new ArrayList<>();
		}
		return users;
	}

	public void setUsers(List<CompUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		HsToStringBuilder builder = new HsToStringBuilder(this);
		builder.append("name", name);
		builder.append("sessionLife", sessionLife);
		builder.append("uris", uris);
		builder.append("users", users);
		return builder.toString();
	}

}