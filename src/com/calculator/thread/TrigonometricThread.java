package com.calculator.thread;

/**
 * The thread-holder for trigonometric functions , all the functions can only be accessed through these classes.
 * Dev Inside- The functions are defined in 3 different instead of 1 single method , so the functions can execute faster.
 * The "faster" indicates time in nanoseconds , the execution time takes a few nanoseconds and for faster execution it has been split into
 * 3 methods.
 *
 * This class is defined as a {@code Core} component so no non-engine classes try to call it.
 *
 * @author devsw
 * @see java.util.concurrent.Callable
 * @see Math
 * @see com.calculator.function.Trigonometry
 * @see com.calculator.annotation.Core
 */
@com.calculator.annotation.Core
public class TrigonometricThread {
    
    private TrigonometricThread(){} //It cannot have an instance
    
    @com.calculator.annotation.Core
    public static final class BaseThread implements java.util.concurrent.Callable<Double>{
    
        private final Double angle;
        private final com.calculator.function.Trigonometry.Angle form;
        private final com.calculator.function.Trigonometry.TrigFunction function;
        
        public BaseThread(Double angle , com.calculator.function.Trigonometry.Angle form, com.calculator.function.Trigonometry.TrigFunction function)
                throws com.calculator.exception.CoreError {
    
            StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
            Class<?> caller = walker.getCallerClass();
            if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
            this.angle = angle;
            this.form = form;
            this.function = function;
        }
        
        @Override
        public Double call () throws Exception {
            return com.calculator.function.Trigonometry.baseRatio (function, angle, form);
        }
    }
    
    @com.calculator.annotation.Core
    public static final class HyperbolicThread implements java.util.concurrent.Callable<Double>{
        
        private final Double angle;
        private final com.calculator.function.Trigonometry.Angle form;
        private final com.calculator.function.Trigonometry.HyperbolicFunction function;
        
        public HyperbolicThread(Double angle , com.calculator.function.Trigonometry.Angle form, com.calculator.function.Trigonometry.HyperbolicFunction function)
                throws com.calculator.exception.CoreError {
            
            StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
            Class<?> caller = walker.getCallerClass();
            if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
            
            this.angle = angle;
            this.form = form;
            this.function = function;
        }
        
        @Override
        public Double call () throws Exception {
            return com.calculator.function.Trigonometry.hyperbolicRatio (function, angle, form);
        }
    }
    
    @com.calculator.annotation.Core
    public static final class ArcThread implements java.util.concurrent.Callable<Double>{
        
        private final Double angle;
        private final com.calculator.function.Trigonometry.Angle form;
        private final com.calculator.function.Trigonometry.ArcFunction function;
        
        public ArcThread(Double angle , com.calculator.function.Trigonometry.Angle form, com.calculator.function.Trigonometry.ArcFunction function)
                throws com.calculator.exception.CoreError {
            
            StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
            Class<?> caller = walker.getCallerClass();
            if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
            
            this.angle = angle;
            this.form = form;
            this.function = function;
        }
        
        @Override
        public Double call () throws Exception {
            return com.calculator.function.Trigonometry.arcRatio (function, angle, form);
        }
    }
}
