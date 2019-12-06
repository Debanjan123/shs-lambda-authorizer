package com.searshc.hs.lambaauthorizer.utils;

import org.apache.commons.lang3.builder.ToStringStyle;

public final class HsToStringStyle extends ToStringStyle {

	private static final long serialVersionUID = -5649917858883783708L;
	
	/**
	 * Open reference to this class.
	 */
	public static HsToStringStyle custom = new HsToStringStyle();
	
	private HsToStringStyle() {
		super();
		this.setUseShortClassName(true);
		this.setUseIdentityHashCode(false);
		this.setFieldSeparator(Constants.Alphas.PIPE);
	}
	
	private Object readResolve() {
		return ToStringStyle.SHORT_PREFIX_STYLE;
	}
	
	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
		if (value == null) {
			return;
		}
		if (value instanceof java.util.Date) {
			super.append(buffer, fieldName, DateUtils.toString((java.util.Date)value, Constants.Formats.DATE_YYYYMMDD_DASH), fullDetail);
		}
		else {
			super.append(buffer, fieldName, value, fullDetail);
		}
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		if (array instanceof java.util.Date[]) {
			String[] s = new String[array.length];
			for (int i=0; i < array.length; i++) {
				s[i] = DateUtils.toString((java.util.Date)array[i], Constants.Formats.DATE_YYYYMMDD_DASH);
			}
			super.append(buffer, fieldName, s, fullDetail);
		}
		else {
			super.append(buffer, fieldName, array, fullDetail);
		}
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, long[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, int[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, short[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, byte[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, char[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, double[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, float[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

	/**
	 * @param buffer
	 *           StringBuffer
	 * @param fieldName
	 * @param value
	 * @param fullDetail
	 */
	@Override
	public void append(StringBuffer buffer, String fieldName, boolean[] array, Boolean fullDetail) {
		if (array == null) {
			return;
		}
		super.append(buffer, fieldName, array, fullDetail);
	}

}