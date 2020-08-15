/**
 * 
 */
package com.calculator.thread;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.calculator.annotation.Core;
import com.calculator.exception.CoreError;
import com.calculator.function.Basic;
import com.calculator.function.Basic.Function;

/**
 * A holder for basic function thread access.
 * It is marked as {@code Core} , as a core engine method
 * @author devsw
 * 
 * @see BigDecimal
 * @see Basic
 * @see Callable
 * @see Core
 * @see CoreError
 * @see Double
 * @see Function
 * @see Thread
 *
 */
@com.calculator.annotation.Core
public class BasicThread {
	
	private BasicThread(){} //Can't have an instance

	/**
	 * Contains the {@code Double} version of the function
	 * @author devsw
	 *
	 */
	@com.calculator.annotation.Core
	public static final class DoubleThread implements java.util.concurrent.Callable<Double>{
		
		private final Double[] operand;
		private final com.calculator.function.Basic.Function function;
		
		public DoubleThread(com.calculator.function.Basic.Function function , Double ...operand) throws com.calculator.exception.CoreError{
			StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
			Class<?> caller = walker.getCallerClass();
			if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
			
			this.operand = operand;
			this.function = function;
		}

		@Override
		public Double call() throws Exception , Error{
			return com.calculator.function.Basic.functionEvaluate(function, operand);
		}
		
	}
	
	/**
	 * Contains the overloaded {@code BigDecimal} version of the function.
	 * @author devsw
	 *
	 */
	@com.calculator.annotation.Core
	public static final class BigDecimalThread implements java.util.concurrent.Callable<java.math.BigDecimal>{
		
		private final java.math.BigDecimal[] operand;
		private final com.calculator.function.Basic.Function function;
		
		public BigDecimalThread(com.calculator.function.Basic.Function function, java.math.BigDecimal ...operand) throws com.calculator.exception.CoreError {
			
			StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
			Class<?> caller = walker.getCallerClass();
			if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
			
			this.operand = operand;
			this.function = function;
		
		}

		@Override
		public java.math.BigDecimal call() throws Exception {
		     return com.calculator.function.Basic.functionEvaluate(function, operand);
		}
		
	}
}
