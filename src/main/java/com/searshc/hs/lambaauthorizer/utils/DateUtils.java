package com.searshc.hs.lambaauthorizer.utils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	public static String toString(Date date, String format) {
		String s = null;

		try {
			s = DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault()).format(date.toInstant());
		} catch (Exception e) {
			LOGGER.trace("Error occurred converting date to string with format [{}]. Error: {}.", format, e);
		}

		return s;
	}
}
