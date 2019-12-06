package com.searshc.hs.lambaauthorizer.utils;

import java.util.List;

/**
 * This class provides a number of utility class to assist in
 * String manipulation.
 * 
 * @author Massa
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	private StringUtils() {}
	
	private static final String CAMEL_CASE_REGEX = "(\\p{Ll})(\\p{Lu})";
	private static final String CAMEL_CASE_REPLACEMENT = "$1 $2";
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * prepending with spaces until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is 
	 * less than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @return If src is null, then new String of pad character.<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src prepended with a character of Space
	 */
	public static String leftPad(final String src, final int size) {
		return leftPad(src, size, Constants.Alphas.SPACE);
	}
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * prepending the specified padChar character until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is less 
	 * than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @param padChar - The character value of the passed in String will be used
	 * @return If src is null, then new String of pad character<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src prepended with character of padChar
	 */
	public static String leftPad(final String src, final int size, final String padChar) {
		return leftPad(src, size, padChar.charAt(0));
	}
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * prepending the specified padChar character until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is less 
	 * than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @param padChar - The character to prepend to the source.
	 * @return If src is null, then new String of pad character<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src prepended with character of padChar
	 */
	public static String leftPad(final String src, final int size, final char padChar) {
		String s = src;
		if (s == null) {
			s = Constants.Alphas.EMPTY;
		}
		
		if (s.length() < size){ 
			int pads = size-s.length();
			char[] padded = new char[s.length() + pads];
			
			//pad with the passed in character
			for (int i=0; i < pads; i++) {
				padded[i] = padChar;
			}
			
			//fill in remainder of array with the source string.
			for (int i=0, j=pads; i < s.length(); i++, j++) {
				padded[j] = s.charAt(i);
			}
			
			return new String(padded);
		}
		else {
			return s;
		}
	}
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * appending with spaces until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is less 
	 * than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @return If src is null, then new String of pad character<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src appended with a character of Space
	 */
	public static String rightPad(final String src, final int size) {
		return rightPad(src, size, Constants.Alphas.SPACE);
	}
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * appending the specified padChar character until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is less 
	 * than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @param padChar - The character value of the passed in String will be used
	 * @return If src is null, then new String of pad character.<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src appended with character of padChar
	 */
	public static String rightPad(final String src, final int size, final String padChar) {
		return rightPad(src, size, padChar.charAt(0));
	}
	
	/**
	 * This method creates a new String object by taking the original String value and
	 * appending the specified padChar character until the new string reaches a length
	 * equal to the passed in size parameter. If the source string is null, a new String
	 * will be returned consisting of only the pad character. If the size parameter is less 
	 * than the length of the source String, the source String is returned.
	 * 
	 * @param src - The source string to pad
	 * @param size - The length the new string will be
	 * @param padChar - The character to prepend to the source.
	 * @return If src is null, then new String of pad character<br/>
	 * If size is less than src.length(), then src.<br/>
	 * A new String of length size with value of src appended with character of padChar
	 */
	public static String rightPad(final String src, final int size, final char padChar) {
		String s = src;
		if (s == null) {
			s = Constants.Alphas.EMPTY;
		}
		
		if (s.length() < size){ 
			int pads = size-s.length();
			char[] padded = new char[s.length() + pads];
			
			//fill in start of array with source string
			for (int i=0; i < s.length(); i++) {
				padded[i] = s.charAt(i);
			}
			
			//pad with the passed in character
			for (int i=padded.length - pads; i < padded.length; i++) {
				padded[i] = padChar;
			}
			
			return new String(padded);
		}
		else {
			return s;
		}
	}
	
	/**
	 * This method determines whether or not a String object is empty. If the 
	 * passed in string is null or the underlying character array of the String
	 * has a length of 0, then true will be returned.
	 * 
	 * @param src - The string to evaluate.
	 * @return True if null or if the length of the string is 0.
	 */
	public static boolean isEmpty(final String src) {
		if (src == null) {
			return true;
		}
		else {
			return src.isEmpty();
		}
	}
	
	/**
	 * This method determines whether or not a String object is not empty. If the
	 * passed in string is not null and the underlying character array of the String
	 * has a length greater than 0, then true will be returned.
	 * 
	 * @param src - The string to evaulate
	 * @return True if not null and length is greater than 0.
	 */
	public static boolean isNotEmpty(final String src) {
		return !isEmpty(src);
	}
	
	/**
	 * This method determines whether or not a String object contains only
	 * whitespace characters (or empty). In the case of the passed in string being null or the
	 * underlying character array of the String has a length of 0, then true will also
	 * be returned. 
	 * 
	 * @param src - The string to evaluate.
	 * @return True if the string contains only blank characters, is null, or is empty.
	 */
	public static boolean isBlank(final String src) {
		if (isEmpty(src)) {
			return true;
		}
		else {
			return trimAllWhiteSpace(src).isEmpty();
		}
	}
	
	public static boolean isNotBlank(final String src) {
		return !isBlank(src);
	}
	
	/**
	 * This method will return a String object with all leading and trailing 
	 * whitespace characters removed. If the passed in String is null or empty,
	 * and empty String is returned.
	 * <br/>
	 * <br/>
	 * Whitespace characters are defined in the {@link Character} class with the 
	 * addition of the 'no break space' character (in html {@code &nbsp;}).
	 * 
	 * @param src - The string to trim
	 * @return The passed in String with all leading and trailing whitespace characters removed.
	 * @see {@link Character#isWhiteSpace(char ch)}
	 */
	public static String trimAllWhiteSpace(final String src) {
		if (isEmpty(src)) { 
			return Constants.Alphas.EMPTY;
		}
		
		int len = src.length();
		int st = 0;
		char[] val = src.toCharArray();
		
		st = getFirstNonBlankIndex(val, st, len);
		len = getLastNonBlankIndex(val, st, len);
				
		return ((st > 0) || (len < src.length())) ? src.substring(st, len) : src;
	}
	
	/**
	 * This method will remove all control characters from a String by replacing them with an
	 * empty String.
	 * 
	 * @param src - The String to remove control characters from
	 * @return The passed in String with no control characters
	 */
	public static String removeControlChars(final String src) {
		return removeControlChars(src, false);
	}
	
	/**
	 * This method will remove all control characters from a String by replacing them with an
	 * empty String. If the value of trim is true, whitespace will also be trimmed from the 
	 * beginning and end of the String
	 * 
	 * @param src - The String to remove control characters from
	 * @param trim - If true, will also remove leading and trailing whitespace
	 * @return The passed in String with no control characters
	 */
	public static String removeControlChars(final String src, final boolean trim) {
		if (isEmpty(src)) {
			return Constants.Alphas.EMPTY;
		}
		
		return trim ? trimAllWhiteSpace(Constants.Patterns.CONTROL_CHARS_PATTERN.matcher(src).replaceAll(Constants.Alphas.EMPTY)) : Constants.Patterns.CONTROL_CHARS_PATTERN.matcher(src).replaceAll(Constants.Alphas.EMPTY);
	}
	
	/**
	 * This method takes a String value that is in camel case format and breaks the 
	 * camel case into separate words.
	 * <br/>
	 * <br/>
	 * For example:<br/>
	 * {@code StringUtils.undoCamelCase("thisIsCamelCase"); //result will be "this Is Camel Case"}
	 * @param src - The string to break down
	 * @return The value of the string separated into separate words.
	 */
	public static String undoCamelCase(final String src) {
		if (isEmpty(src)){ 
			return Constants.Alphas.EMPTY;
		}
		else {
			return src.replaceAll(CAMEL_CASE_REGEX, CAMEL_CASE_REPLACEMENT);
		}
	}
	
	/**
	 * This method will capitalize the first character of the passed in String.
	 * If the passed in parameter is null or empty, an empty String will be returned.
	 * 
	 * @param src - The String to capitalize
	 * @return The capitalized string.
	 */
	public static String capitalize(final String src) {
		if (isEmpty(src)) {
			return Constants.Alphas.EMPTY;
		}
		else {
			StringBuilder sb = new StringBuilder(src);
			sb.deleteCharAt(0);
			sb.insert(0, Character.toUpperCase(src.charAt(0)));
			return sb.toString();
		}
	}
	
	/**
	 * This method checks if the src parameter is equal to at least one of the values parameters. 
	 * The checkCase parameter determines whether or not the check for equality should be case sensitive.
	 * 
	 * @param key - The value to check for.
	 * @param checkCase - If false, ignore case during check
	 * @param values - The list of strings to check against
	 * @return True if the key parameter is found in the values parameter
	 */
	public static boolean containsKey(final String key, final boolean checkCase, final String... values) {
		if (key == null) {
			return values == null;
		}
		else {
			for (String value : values) {
				if (isEqual(key, value, checkCase)) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * This method checks if the src parameter is equal to at least one of the values parameters. 
	 * The checkCase parameter determines whether or not the check for equality should be case sensitive.
	 * 
	 * @param key - The value to check for.
	 * @param checkCase - If false, ignore case during check
	 * @param values - The list of strings to check against
	 * @return True if the key parameter is not found in the values parameter
	 */
	public static boolean doesNotContainKey(final String key, final boolean checkCase, final String... values) {
		return !containsKey(key, checkCase, values);
	}
	
	/**
	 * This method determines if s1 is equal to s2. If checkCase if false, case is not 
	 * regarded during check for equality.
	 * 
	 * @param s1 - The value to compare against s2
	 * @param s2 - The value to compare against s1
	 * @param checkCase -If false, ignore case during check
	 * @return True if s1 equals s2
	 */
	public static boolean isEqual(String s1, String s2, boolean checkCase) {
		return checkCase ? org.apache.commons.lang3.StringUtils.equals(s1, s2) : org.apache.commons.lang3.StringUtils.equalsIgnoreCase(s1, s2);
	}
	
	/**
	 * This method determines if s1 is equal to s2. If checkCase if false, case is not 
	 * regarded during check for equality.
	 * 
	 * @param s1 - The value to compare against s2
	 * @param s2 - The value to compare against s1
	 * @param checkCase -If false, ignore case during check
	 * @return True if s1 does not equal s2
	 */
	public static boolean isNotEqual(final String s1, final String s2, final boolean checkCase) {
		return !isEqual(s1, s2, checkCase);
	}
	
	/**
	 * This method checks if the src parameter is equal to at least one of the values parameters. 
	 * The checkCase parameter determines whether or not the check for equality should be case sensitive.
	 * 
	 * @param key - The value to check for.
	 * @param checkCase - If false, ignore case during check
	 * @param values - The list of strings to check against
	 * @return True if the key parameter is found in the values parameter
	 */
	public static boolean containsKey(String key, boolean checkCase, List<String> values) {
		String[] s = {};
		return checkCase ? values.contains(key) : containsKey(key, checkCase, values.toArray(s));
	}
	
	/**
	 * This method checks if the src parameter is equal to at least one of the values parameters. 
	 * The checkCase parameter determines whether or not the check for equality should be case sensitive.
	 * 
	 * @param key - The value to check for.
	 * @param checkCase - If false, ignore case during check
	 * @param values - The list of strings to check against
	 * @return True if the key parameter is not found in the values parameter
	 */
	public static boolean doesNotContainKey(String key, boolean checkCase, List<String> values) {
		return !containsKey(key, checkCase, values);
	}
	
	/**
	 * This method replaces the first numCharsToMask characters of the src string with the
	 * passed in mask character. If the src string is null or numCharsToMask is greater than
	 * the length of the src string, a new string of length numCharsToMask will be created
	 * and returned.
	 * 
	 * @param src - The String to mask
	 * @param mask - The character to mask with.
	 * @param numCharsToMask - The number of characters to mask, starting at the beginning of src
	 * @return A new masked string
	 */
	public static String maskFirst(final String src, final String mask, final int numCharsToMask) {
		String s = src;
		if (s == null) {
			s = Constants.Alphas.EMPTY;
		}
		
		int sSize = s.length() < numCharsToMask ? numCharsToMask : s.length();
		
		char[] masked = new char[sSize];
		
		for (int i = 0; i < numCharsToMask; i++) {
			masked[i] = mask.charAt(0);
		}
		
		for (int i = numCharsToMask; i < sSize; i++) {
			masked[i] = s.charAt(i);
		}
		
		return new String(masked);
	}
	
	/**
	 * This method replaces the last numCharsToMask characters of the src string with the
	 * passed in mask character. If the src string is null or numCharsToMask is greater than
	 * the length of the src string, a new string of length numCharsToMask will be created
	 * and returned.
	 * 
	 * @param src - The String to mask
	 * @param mask - The character to mask with.
	 * @param numCharsToMask - The number of characters to mask, starting at the end of src
	 * @return A new masked string
	 */
	public static String maskLast(final String src, final String mask, final int numCharsToMask) {
		String s = src;
		if (s == null) {
			s = Constants.Alphas.EMPTY;
		}
		
		int sSize = s.length() < numCharsToMask ? numCharsToMask : s.length();
		
		char[] masked = new char[sSize];
		
		for (int i = 0; i < sSize - numCharsToMask; i++) {
			masked[i] = s.charAt(i);
		}
		
		for (int i = sSize - numCharsToMask; i < sSize; i++) {
			masked[i] = mask.charAt(0);
		}
		
		return new String(masked);
	}
	
	public static String lowerCase(final String src) {
		return src == null ? Constants.Alphas.EMPTY : src.toLowerCase();
	}
	
	public static String upperCase(final String src) {
		return src == null ? Constants.Alphas.EMPTY : src.toUpperCase();
	}
	
	public static String reverse(final String src) {
		if (isBlank(src)) {
			return Constants.Alphas.EMPTY;
		}
		
		int length = src.length();
		char[] chars = src.toCharArray();
		
		for (int i = 0; i < src.length() / 2; i++) {
			char c = chars[i];
			chars[i] = chars[length-1-i];
			chars[length-1-i] = c;
		}
		
		return new String(chars);
	}
	
	public static String mid(final String src, final int start, final int length) {
		return (src == null) ? Constants.Alphas.EMPTY : org.apache.commons.lang3.StringUtils.mid(src, start, length);
	}
	
	private static int getFirstNonBlankIndex(char[] val, int start, int length) {
		int st = start;
		while ((st < length) && (Character.isWhitespace(val[st]) || val[st] == Constants.Alphas.NBSP)) {
			st++;
		}
		return st;
	}
	
	private static int getLastNonBlankIndex(char[] val, int start, int length) {
		int len = length;
		while ((start < len) && (Character.isWhitespace(val[len-1]) || val[len-1] == Constants.Alphas.NBSP)) {
			len--;
		}
		return len;
	}

}
