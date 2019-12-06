package com.searshc.hs.lambaauthorizer.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is a generic exception that simply extends the {@link RuntimeException} class.
 * There is no special functionality in this class.
 */
public class HSException extends RuntimeException {

	private static final long serialVersionUID = 1447544944402134318L;
	
	private List<String> messages = new ArrayList<>();

	/**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
	public HSException() {
		super();
	}

	/**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
	public HSException(String message) {
		super(message);
	}

	/**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
	public HSException(Throwable cause) {
		super(cause);
	}

	 /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     */
	public HSException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public HSException(String message, Throwable cause, String... messages) {
		super(message, cause);
		for (String s : messages) {
			this.messages.add(s);
		}
	}
	
	public HSException(String message, Throwable cause, Collection<String> messages) {
		super(message, cause);
		this.messages.addAll(messages);
	}
	
	public HSException(String message, String... messages) {
		super(message);
		for (String s : messages) {
			this.messages.add(s);
		}
	}
	
	public HSException(String message, Collection<String> messages) {
		super(message);
		this.messages.addAll(messages);
	}

	/**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 1.7 (JDK)
     */
	public HSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	public void setMessages(Collection<String> messages) {
		this.messages.addAll(messages);
	}
	
	public List<String> getMessages() {
		return this.messages;
	}
	
	public Set<String> getMessagesAsSet() {
		return new HashSet<String>(messages);
	}
	
	public Set<String> getMessagesAsSortedSet() {
		return new TreeSet<String>(messages);
	}

}