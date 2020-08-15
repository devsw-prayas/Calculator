/**
 * 
 */
package com.calculator.function;

import java.math.BigDecimal;

import com.calculator.exception.CoreError;
import com.calculator.ui.UI;

/**
 * Contains basic functions for the calculator. It is accessed via the threads in the {@code com.calculator.thread}
 * package
 * @author devsw
 * 
 * @see BigDecimal
 * @see Double
 * @see Math
 * @see UI
 * @see com.calculator.thread
 * @see CoreError
 */
public class Basic {
	
	public enum Function {
		
		ADD , SUBTRACT , MULTIPLY , DIVIDE , SQRT , CBRT , POWER , MODULO;

	}
	
	/**
	 * Can't have instances of this.
	 */
	private Basic() {}
	
	/**
	 * Simple functions... Well , you don't need any description.
	 * Overloads the {@code BigDecimal} function
	 * 
	 * @param function The type of function to be executed
	 * @param operand Array consisting of the operands
	 * @return Returns the function passed by {@code function} parameter.
	 * @throws CoreError If the caller class is not part of the engine, then the CoreError is thrown
	 */
	@SuppressWarnings("preview")
	@com.calculator.annotation.Core
	public static Double functionEvaluate(com.calculator.function.Basic.Function function , Double ...operand) throws com.calculator.exception.CoreError{
		
		StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
		Class<?> caller = walker.getCallerClass();
		if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
		
		return switch (function) {
			case ADD -> operand[0] + operand[1];
			case CBRT -> Math.cbrt (operand[0]);
			case DIVIDE -> operand[0] / operand[1];
			case MULTIPLY -> operand[0] * operand[1];
			case POWER -> Math.pow (operand[0], operand[1]);
			case SQRT -> Math.sqrt (operand[0]);
			case SUBTRACT -> operand[0] - operand[1];
			case MODULO -> operand[0] % operand[1];
		};
		
	}
	
	/**
	 * Overloaded form , allows {@code BigDecimal}..
	 * 
	 * @param function The function to performed
	 * @param operand Array consisting of all the operands
	 * @return Returns the result of the function passed.
	 * @throws CoreError If the caller class is not part of the engine, then the CoreError is thrown
	 */
	@com.calculator.annotation.Core
	public static BigDecimal functionEvaluate(com.calculator.function.Basic.Function function , java.math.BigDecimal ...operand) throws com.calculator.exception.CoreError{
		
		StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
		Class<?> caller = walker.getCallerClass();
		if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
		
		java.math.BigDecimal result = null;
		int index = 0;
		
		if(function.equals(com.calculator.function.Basic.Function.POWER)) {
			double i = operand[1].doubleValue();
			index = (int)i;
		}
		
		switch (function) {
		
		case ADD: result = operand[0].add(operand[1], java.math.MathContext.UNLIMITED);
			break;
			
		case CBRT: //Not possible with BigDecimal.
			break;
			
		case DIVIDE: result = operand[0].divide(operand[1], java.math.MathContext.UNLIMITED);
			break;
			
		case MULTIPLY: result = operand[0].multiply(operand[1], java.math.MathContext.UNLIMITED);
			break;
			
		case POWER: result = operand[0].pow(index, java.math.MathContext.UNLIMITED);
			break;
			
		case SQRT: result = operand[0].sqrt(java.math.MathContext.UNLIMITED);
			break;
			
		case SUBTRACT: result = operand[0].subtract(operand[1], java.math.MathContext.UNLIMITED);
			break;
		
		case MODULO: result = operand[0].remainder(operand[1], java.math.MathContext.UNLIMITED);
			break;

		}
		
		return result;
		
	}
	

}
