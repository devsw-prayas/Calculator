package com.calculator.function;

/**
 * Powers the trigonometric function and manages all the radians-to-degrees and degrees-to-radians conversions as well
 * This is a Java SE 13 preview version and some features may not be implemented the way its written.
 * The preview version is only usable in 13.0.2 and cannot be used in 14.0.1 or 12.0.1 or below.
 * It is marked as preview but will have a non-preview form.
 *
 * It is marked as {@code Core} component and only the engine ay use it. It throws a {@code CoreError} iff a non engine component tries to call it.
 * This function is accessible via the threads in the {@code TrigonometricThread}
 *
 * @author devsw
 * 
 * @see Math
 */
@com.calculator.annotation.Core
@SuppressWarnings("preview")
public class Trigonometry {
    
    private Trigonometry(){} //This class cannot have an object
    
    /**
     * Base Trigonometric function
     */
    public enum TrigFunction{
        SIN, COS ,TAN
    }
    
    /**
     * Hyperbolic trigonometric function
     */
    public enum HyperbolicFunction {
        SINH , COSH , TANH
    }
    
    /**
     * Arc-Trigonometric function
     */
    public enum ArcFunction{
        ASIN , ACOS , ATAN
    }
    
    /**
     * Radians and Degrees controller
     */
    public enum Angle{
        RAD , DEG
    }
    
    /**
     * Calculates the base trigonometric functions
     * @param function The function to be executed
     * @param angle The angle
     * @param form The angle form i.e in Degrees or Radians
     * @return Returns the ratio in radians
     */
	public static Double baseRatio(com.calculator.function.Trigonometry.TrigFunction function , Double angle , com.calculator.function.Trigonometry.Angle form ) throws com.calculator.exception.CoreError {
        
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
        
        double result = 0;
      
      if(form.equals (com.calculator.function.Trigonometry.Angle.RAD)){
          switch (function){
    
              case SIN -> result = Math.sin(angle);
              case COS -> result = Math.cos (angle);
              case TAN -> result = Math.tan (angle);
          }
        }else{
          switch (function){
    
              case SIN -> result = Math.sin(Math.toRadians (angle));
              case COS -> result = Math.cos (Math.toRadians (angle));
              case TAN -> result = Math.tan (Math.toRadians (angle));
          }
      }
      return  result;
    }
    
    /**
     * Calculates the hyperbolic trigonometric functions
     * @param function The function to be executed
     * @param angle The angle
     * @param form The angle form i.e in Degrees or Radians
     * @return Returns the ratio in radians
     */
	public static Double hyperbolicRatio(com.calculator.function.Trigonometry.HyperbolicFunction function , Double angle , com.calculator.function.Trigonometry.Angle form) throws com.calculator.exception.CoreError {
        
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
        
        double result = 0.0;
        
        if(form.equals (com.calculator.function.Trigonometry.Angle.RAD)){
            switch(function){
    
                case SINH -> result = Math.sinh (angle);
                case COSH -> result = Math.cosh (angle);
                case TANH -> result = Math.tanh (angle);
            }
        }else{
            switch(function){
    
                case SINH -> result = Math.sinh (Math.toRadians (angle));
                case COSH -> result = Math.cosh (Math.toRadians (angle));
                case TANH -> result = Math.tanh (Math.toRadians (angle));
            }
        }
        return result;
    }
    
    /**
     * Calculates the arc trigonometric functions
     * @param function The function to be executed
     * @param angle The angle
     * @param form The angle form i.e in Degrees or Radians
     * @return Returns the ratio in radians
     */
    public static Double arcRatio(com.calculator.function.Trigonometry.ArcFunction function , Double angle , com.calculator.function.Trigonometry.Angle form) throws com.calculator.exception.CoreError {
    
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
        double result = 0.0;
    
        if(form.equals (com.calculator.function.Trigonometry.Angle.RAD)){
            switch(function){
            
                case ASIN -> result = Math.asin (angle);
                case ACOS -> result = Math.acos (angle);
                case ATAN -> result = Math.atan (angle);
            }
        }else{
            switch(function){
            
                case ASIN -> result = Math.asin (Math.toRadians (angle));
                case ACOS -> result = Math.acos (Math.toRadians (angle));
                case ATAN -> result = Math.atan (Math.toRadians (angle));
            }
        }
        return result;
        
        
    }
    
}
