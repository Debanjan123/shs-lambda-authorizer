package com.searshc.hs.lambaauthorizer.vo;

import java.util.ArrayList;
import java.util.List;

import com.searshc.hs.lambaauthorizer.utils.HsToStringBuilder;

public class AuthBody {

	private List<String> addresses;
	private List<Comp> components;

	public List<String> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<>();
		}
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public List<Comp> getComponents() {
		if (components == null) {
			components = new ArrayList<>();
		}
		return components;
	}

	public void setComponents(List<Comp> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		HsToStringBuilder builder = new HsToStringBuilder(this);
		builder.append("addresses", addresses);
		builder.append("components", components);
		return builder.toString();
	}

}