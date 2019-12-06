package com.searshc.hs.lambaauthorizer.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is used to signify an invalid input object. This exception can be thrown
 * when validating an object and a validation rule fails.
 */
public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1489876862016851464L;
	
	private Collection<String> errorMessages = new ArrayList<String>();

	/**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
	public InvalidInputException() {
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
	public InvalidInputException(String message) {
		super(message);
	}
	
	public InvalidInputException(String message, String error) {
		super(message);
		addError(error);
	}
	
	/**
     * Constructs a new exception with the specified detail message and list of 
     * error messages.  The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     * 
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
	 * @param errorMessages the list of error messages
	 */
	public InvalidInputException(String message, Collection<String> errorMessages) {
		super(message);
		this.errorMessages = errorMessages;
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
	public InvalidInputException(Throwable cause) {
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
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
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
	public InvalidInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	/**
	 * Add an error message to the list of errors.
	 * 
	 * @param error - Error message to add
	 */
	public void addError(String error) {
		this.errorMessages.add(error);
	}

	/**
	 * @return The list of error messages.
	 */
	public Collection<String> getErrorMessages() {
		return errorMessages;
	}
	
	/**
	 * Return the list of error messages as a {@link Set}
	 * @return The error messages as a {@link Set}
	 */
	public Set<String> getErrorMessagesAsSet() {
		return new HashSet<String>(errorMessages);
	}
	
	/**
	 * Return the list of error messages as a {@link TreeSet}
	 * @return The error messages as a {@link TreeSet}
	 */
	public Set<String> getErrorMessagesAsSortedSet() {
		return new TreeSet<String>(errorMessages);
	}

	/**
	 * Set the list of error messages.
	 * @param errorMessages
	 */
	public void setErrorMessages(Collection<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}