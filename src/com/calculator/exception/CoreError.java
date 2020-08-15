/**
 * 
 */
package com.calculator.exception;

/**
 * A CoreError is thrown when a class that is not part of the engine calls a method of {@code Core} component.
 * It is made an error so no try-catch blocks won't catch it. It is regarded as a system failure.
 * @author devsw
 *
 */
public class CoreError extends Error {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoreError(String msg) {
		super(msg);
	}
}
