package com.calculator.function;

/**
 * The type of object passed when a function is executed.
 * The class itself has no methods , it acts as an container.
 *
 * @author devsw
 */
@com.calculator.annotation.Core
@SuppressWarnings("unused")
public class Function {
    
    private final com.calculator.function.Trigonometry.TrigFunction function;
    private final Trigonometry.ArcFunction function2;
    private final Trigonometry.HyperbolicFunction function3;
    private final Basic.Function main;
    private final com.calculator.function.Trigonometry.Angle form;
    private final String angle;
    private final java.util.ArrayList<String> operand;
    
    /**
     * Initializes a basic Trigonometric object
     * @param function The Trigonometric function
     * @param angle The angle in radians/degrees
     * @param form The value which indicates whether it is in radians or degrees
     */
    public Function(com.calculator.function.Trigonometry.TrigFunction function , com.calculator.function.Trigonometry.Angle form, String angle){
    
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
        this.function = function;
        this.form = form;
        this.angle = angle;
        
        //Non initialized values
        this.function2 = null;
        this.function3 = null;
        main = null;
        operand = null;
    }
    
    /**
     * Initializes an arc form.
     * @param function The Arc function
     * @param form The value which indicates whether it is radians or degrees
     * @param angle The angle in radians or degrees
     */
    public Function(Trigonometry.ArcFunction function, Trigonometry.Angle form, String angle){
    
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
        this.function2 = function;
        this.form = form;
        this.angle = angle;
        
        //Non initialized values
        this.function = null;
        this.function3 = null;
        operand = null;
        main = null;
    }
    
    /**
     * Initializes a Hyperbolic function
     * @param function The function to be performed
     * @param form The value which indicates whether it is in radians/degrees
     * @param angle The angle in radians/degrees
     */
    public Function(Trigonometry.HyperbolicFunction function, Trigonometry.Angle form, String angle){
    
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
        this.function3 = function;
        this.form = form;
        this.angle = angle;
        
        //Non initialized values
        this.function = null;
        this.function2 = null;
        operand = null;
        main = null;
    }
    
    /**
     * initializes a Basic function
     * @param main The function to be performed
     * @param operand The list of operands
     */
    public Function(Basic.Function main, String...operand) {
    
        StackWalker walker = StackWalker.getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> caller = walker.getCallerClass();
        if(!caller.isAnnotationPresent(com.calculator.annotation.Core.class)) throw new com.calculator.exception.CoreError("Caller Is not a Core component");
    
        this.main = main;
        this.operand = new java.util.ArrayList <String> (java.util.Arrays.asList (operand));
        
        //Non initialized values
        function = null;
        function2 = null;
        function3 = null;
        angle = null;
        form = null;
    }
    
}
