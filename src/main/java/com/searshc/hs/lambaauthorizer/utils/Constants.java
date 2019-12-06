package com.searshc.hs.lambaauthorizer.utils;

import java.util.regex.Pattern;

public final class Constants {
	
	private Constants() {}
	
	/**
	 * Constant values representing single characters as Strings
	 */
	public static final class Alphas {
		private Alphas() {}
		public static final String OPEN_BACKET = "[";
		public static final String CLOSED_BACKET = "]";
		public static final String PERIOD = ".";
		public static final String COMMA = ",";
		public static final String SLASH = "/";
		public static final String BACKSLASH = "\\";
		public static final String APOSTROPHE = "'";
		public static final String QUOTE = "\"";
		public static final String PERCENT = "%";
		public static final String COLON = ":";
		public static final String SEMICOLON = ";";
		public static final String DASH = "-";
		public static final String UNDERSCORE = "_";
		public static final String PLUS = "+";
		public static final String PIPE = "|";
		public static final String QUESTION = "?";
		public static final String ASTERISK = "*";
		public static final String DOLLAR = "$";
		public static final String OCTOTHORPE = "#";
		public static final String POUND = OCTOTHORPE;
		public static final String AT = "@";
		public static final String EXCLAMATION = "!";
		public static final String EQUAL = "=";
		public static final String EMPTY = "";
		public static final String SPACE = " ";
		public static final char NBSP = 0xA0;
		public static final String A = "A";
		public static final String B = "B";
		public static final String C = "C";
		public static final String D = "D";
		public static final String E = "E";
		public static final String F = "F";
		public static final String G = "G";
		public static final String H = "H";
		public static final String I = "I";
		public static final String J = "J";
		public static final String K = "K";
		public static final String L = "L";
		public static final String M = "M";
		public static final String N = "N";
		public static final String O = "O";
		public static final String P = "P";
		public static final String Q = "Q";
		public static final String R = "R";
		public static final String S = "S";
		public static final String T = "T";
		public static final String U = "U";
		public static final String V = "V";
		public static final String W = "W";
		public static final String X = "X";
		public static final String Y = "Y";
		public static final String Z = "Z";
		public static final String ZERO = "0";
		public static final String ONE = "1";
		public static final String TWO = "2";
		public static final String THREE = "3";
		public static final String FOUR = "4";
		public static final String FIVE = "5";
		public static final String SIX = "6";
		public static final String SEVEN = "7";
		public static final String EIGHT = "8";
		public static final String NINE = "9";
		public static final String TEN = "10";
	}
	
	/**
	 * Constant values relating specifically to the web service.
	 */
	public static final class Service {
		private Service() {}
		/**
		 * _wadl
		 */
		public static final String WADL = "_wadl";
		/**
		 * clientid
		 */
		public static final String CLIENT_ID = "clientid";
		/**
		 * servicename
		 */
		public static final String SERVICE_NAME = "servicename";
		/**
		 * serviceversion
		 */
		public static final String SERVICE_VERSION = "serviceversion";
		/**
		 * userid
		 */
		public static final String USER_ID = "userid";
		/**
		 * user-agent
		 */
		public static final String USER_AGENT = "user-agent";
		/**
		 * Authorization
		 */
		public static final String AUTHORIZATION = "Authorization";
		/**
		 * Bearer
		 */
		public static final String AUTH_BEARER = "Bearer";
		/**
		 * /services/*
		 */
		public static final String SERVICES_MAPPING = "/services/*";
	}
	
	/**
	 * Constant values relating to the MDC of the Logger
	 */
	public static final class MDC {
		private MDC() {}
		/**
		 * trackingId
		 */
		public static final String TRACKING_ID = "trackingId";
		/**
		 * clientId
		 */
		public static final String CLIENT_ID = "clientId";
		/**
		 * method
		 */
		public static final String METHOD_ID = "method";
		/**
		 * userId
		 */
		public static final String USER_ID = "userId";
	}
	
	/**
	 * Constant values relating to the security interceptor of the web service
	 */
	public static final class Security {
		private Security() {}
		/**
		 * 06
		 */
		public static final String ERROR_CODE = "06";
		/**
		 * Not Authorized to Access Service
		 */
		public static final String SEC_ERROR_MSG = "Not Authorized to Access Service";
		/**
		 * Client:{} is NOT authorized to make request: {} {}
		 */
		public static final String SEC_NO_AUTH_MSG = "Client:{} is NOT authorized to make request: {} {}";
	}
	
	/**
	 * Constant numeric values represented by either a Number object or primitive or
	 * a String representation of a number.
	 */
	public static final class Formats {
		private Formats() {}
		/**
		 * HHmm
		 */
		public static final String TIME_HHMM_2359 = "HHmm";
		/**
		 * HHmm
		 */
		public static final String TIME_HHMM_1159A = "hhmma";
		/**
		 * yyyy-MM-dd
		 */
		public static final String DATE_YYYYMMDD_DASH = "yyyy-MM-dd";
		/**
		 * yyyyMMdd
		 */
		public static final String DATE_YYYYMMDD = "yyyyMMdd";
		/**
		 * yyyy-MM-dd'T'HH:mm:ss'Z'
		 */
		public static final String GREGORIAN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	}
	
	/**
	 * Constant values relating to the application audit Logging
	 */
	public static final class Audit {
		private Audit() {}
		/**
		 * %s REQUEST[%s]
		 */
		public static final String AUDIT_REQUEST_LOG_START = "%s REQUEST[%s]";
		/**
		 * %s RUNTIME[%s] RESPCD[%s] RESPMSG[%s] RESPONSE[%s]
		 */
		public static final String AUDIT_REQUEST_LOG_END = "%s RUNTIME[%s] RESPCD[%s] RESPMSG[%s] RESPONSE[%s]";
		public static final String AUDIT_REQUEST_LOG_END_NO_RESPONSE = "%s RUNTIME[%s]";
		/**
		 * %s RUNTIME[%s] RESPONSE[%s]
		 */
		public static final String AUDIT_REQUEST_LOG_END_SHORT = "%s RUNTIME[%s] RESPONSE[%s]";
		/**
		 * service started
		 */
		public static final String SERVICE_START = "service started";
		/**
		 * service ended
		 */
		public static final String SERVICE_END = "service ended";
		/**
		 * db request started
		 */
		public static final String DB_START = "db request started";
		/**
		 * db request ended
		 */
		public static final String DB_END = "db request ended";
		public static final String CALL_START = "%s() call started";
		public static final String CALL_END = "%s() call ended";
		public static final String PRINT_INPUT = "[INPUT] - %s";
		public static final String PRINT_OUTPUT = "[OUTPUT] - %s";
	}
	
	/**
	 * Constant numeric values represented by either a Number object or primitive or
	 * a String representation of a number.
	 */
	public static final class Numbers {
		private Numbers() {}
		/**
		 * 1,000,000
		 */
		public static final int MILLION = 1_000_000;
		/**
		 * 1,000,000,000
		 */
		public static final int BILLION = 1_000_000_000;
		/**
		 * 0
		 */
		public static final int ZERO = 0;
	}
	
	/**
	 * Constant values relating to Http status codes
	 *
	 */
	public static final class HttpStatus {
		private HttpStatus() {}
		/**
		 * 200
		 */
		public static final int OK = 200;
		/**
		 * 401
		 */
		public static final int UNATHORIZED = 401;
		/**
		 * 404
		 */
		public static final int NOT_FOUND = 404;
		/**
		 * 400
		 */
		public static final int BAD_REQUEST = 400;
		/**
		 * 500
		 */
		public static final int INTERNAL_ERROR = 500;
	}
	
	/**
	 * Constant values relating to JMS functionality.
	 */
	public static final class JMS {
		private JMS() {}
		/**
		 * Message Text:[{}] FAILED to SEND over MQ  with error:{}
		 */
		public static final String SEND_FAILED_MSG = "Message Text:[{}] FAILED to SEND over MQ  with error:{}";
		/**
		 * Text:[{}] has been SUCCESSFULLY sent over MQ
		 */
		public static final String SEND_SUCCESS_MSG = "Text:[{}] has been SUCCESSFULLY sent over MQ";
		/**
		 * Message RECEIVE failed for correlationId:{} with error:{}
		 */
		public static final String RECEIVE_FAILED_MSG = "Message RECEIVE failed for correlationId:{} with error:{}";
		/**
		 * Text:[{}] has been SUCCESSFULLY received from MQ
		 */
		public static final String RECEIVE_SUCCESS_MSG = "Text:[{}] has been SUCCESSFULLY received from MQ";
		/**
		 * JMSCorrelationID
		 */
		public static final String JMS_CORREELATION_ID = "JMSCorrelationID";
	}
	
	public static final class Validation {
		private Validation() {}
		/**
		 * " is required"
		 */
		public static final String IS_REQUIRED = " is required";
		/**
		 * " is not numeric"
		 */
		public static final String IS_NOT_NUMERIC = " is not numeric";
		/**
		 * "  Phone number must be 10 characters numeric"
		 */
		public static final String PHONE_NUMBER_TEN_DIGITS = " Phone number must be 10 characters numeric";
		/**
		 * " Phone number area code is not valid"
		 */
		public static final String PHONE_NUMBER_INVALID_AREA_CODE = " Phone number area code is not valid";
		/**
		 * "  Phone number is not valid"
		 */
		public static final String PHONE_NUMBER_INVALID_NUMBER = " Phone number is not valid";
		/**
		 * " Email is not valid"
		 */
		public static final String EMAIL_ID_INVALID = " Email Id is not valid";
		/**
		 * " Email Id can't have invalid values"
		 */
		public static final String EMAIL_INVALID_STRING = " Email Id can't have invalid values like NONE,NO,NON,DUMMY,NOEMAIL";
		/**
		 * " Email Invalid String"
		 */
		public static final String[] EMAIL_INVALID_START_STRINGS = {"NO@","NON@","NONE@","DUMMY@","NOEMAIL@","no@","non@","none@","dummy@","noemail@"};
		/**
		 * " Email Invalid String"
		 */
		public static final String[] EMAIL_INVALID_DOMAIN_STRINGS = {"@NO.","@NON.","@NONE.","@DUMMY.","@NOEMAIL.","@no.","@non.","@none.","@dummy.","@noemail."};
		/**
		 * "%s cannot be greater than %s characters"
		 */
		public static final String LENGTH_ERROR = "%s cannot be greater than %s characters";
		/**
		 * %s must be between %s and %s characters
		 */
		public static final String LENGTH_RANGE_ERROR = "%s must be between %s and %s characters";
		/**
		 * %s is not in the correct format
		 */
		public static final String FORMAT_ERROR = "%s is not in the correct format";
		/**
		 * The value of %s is not valid
		 */
		public static final String INVALID_VALUE = "The value of %s is not valid";
	}
	
	public static final class Patterns {
		private Patterns()  {}
		/**
		 * "EMAIL_PATTERN_STRING"
		 */
		public static final String EMAIL_PATTERN_STRING="^[a-zA-Z0-9]+[a-zA-Z0-9\\.\\_\\-\\*\\&\\$\\#\\!\\%\\/\\+]+@[a-zA-Z0-9-]+[.][a-zA-Z0-9]+([.a-zA-Z]{2,4})$";
		/**
		 * "EMAIL_PATTERN"
		 */
		public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_PATTERN_STRING);
		/**
		 * "PHONE_NUMBER_STRING WITH 10 DIGITS"
		 */
		public static String NUMBERS_ALONE="^[\\d]{10}$";
		/**
		 * "PHONE_NUMBER_STRING FOR REPEATING AREA CODES"
		 */
		public static String REPEATING_AREA_CODE="^000[\\d]{7}|111[\\d]{7}|222[\\d]{7}|333[\\d]{7}|444[\\d]{7}|555[\\d]{7}|666[\\d]{7}|777[\\d]{7}|888[\\d]{7}|999[\\d]{7}|800[\\d]{7}|866[\\d]{7}|877[\\d]{7}$";
		/**
		 * "PHONE_NUMBER_STRING FOR INVALID_PHONE_NOS"
		 */
		public static String INVALID_PHONE_NOS="^\\d{3}0000000|\\d{3}9999999|\\d{3}5551212$";
		/**
		 * "PHONE_PATTERN_NUMBERS_ALONE"
		 */
		public static final Pattern PHONE_PATTERN_NUMBERS_ALONE = Pattern.compile(NUMBERS_ALONE);
		/**
		 * "PHONE_PATTERN_REPEATING_AREA_CODE"
		 */
		public static final Pattern PHONE_PATTERN_REPEATING_AREA_CODE = Pattern.compile(REPEATING_AREA_CODE);
		/**
		 * "PHONE_PATTERN_INVALID_PHONE_NOS"
		 */
		public static final Pattern PHONE_PATTERN_INVALID_PHONE_NOS = Pattern.compile(INVALID_PHONE_NOS);
		/**
		 * Control Characters
		 */
		public static final Pattern CONTROL_CHARS_PATTERN = Pattern.compile("\\p{Cntrl}");
	}
}