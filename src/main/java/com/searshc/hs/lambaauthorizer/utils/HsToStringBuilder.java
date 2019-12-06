package com.searshc.hs.lambaauthorizer.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HsToStringBuilder extends ToStringBuilder {
	
	public HsToStringBuilder(Object object) {
		this(object, HsToStringStyle.custom);
	}
	
	public HsToStringBuilder(Object object, HsToStringStyle style) {
		super(object, style);
	}

}