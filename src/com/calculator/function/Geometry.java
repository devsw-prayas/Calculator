package com.calculator.function;

/**
 * A geometric calculation class, Supports a broad variety of shapes.
 * All the function can only be called by the {@link com.calculator.thread.ThreadExecutor}.
 * It is not multi-threaded but the executors provide a workaround.
 */
@com.calculator.annotation.Core
public final class Geometry {
    
    private Geometry(){}// This class cannot be instantiated
    
    /**
     * Contains the shapes that can be calculated, visualizations are possible
     */
    @com.calculator.annotation.Core
    public enum Shape2D{
        SQUARE,
        RECTANGLE,
        TRIANGLE,
        PARALLELOGRAM,
        TRAPEZIUM,
        RHOMBUS,
        CIRCLE;
    }
    
    /**
     * Contains 3D versions of shapes, with possible visualizations
     */
    @com.calculator.annotation.Core
    public enum Shape3D{
        ARBITRARY,
        CUBE,
        CUBOID,
        HEMISPHERE,
        SPHERE,
        PRISM,
        PYRAMID;
    }
    
    public static String[] evaluateShape(Shape2D shape){
    
        return null;
    }
    
    
    public static String[] evaluateShape(Shape3D shape){
        
        return null;
    }
}
