package com.calculator.thread;

import com.calculator.function.Function;

/**
 * The thread-manager , all the thread-induced I/O is performed in this class.
 *
 * @see java.util.concurrent.Executor
 * @see java.util.concurrent.Executors
 * @see java.util.concurrent.ExecutorService
 * @see java.util.concurrent.ExecutionException
 * @see java.util.concurrent.Future
 */
@com.calculator.annotation.Core
@SuppressWarnings("unused")
public class ThreadExecutor {
    
    /**
     * A shutdown thread, executed when only abnormal program termination occurs
     */
    public static final class Hook extends Thread{
        
        public Hook(){
            super("Shutdown Thread");
        }
        
        @Override
        public void run () {
            System.err.println ("Fatal Error , Thread Count is higher than available threads");
        }
    }
    
    /**
     * The thread-executor is created with an {@link java.util.concurrent.ExecutorService} and wil be used with all threads
     * instead of creating separate executors for each function call.
     */
    private final java.util.concurrent.ExecutorService executor;
    Runtime runtime = Runtime.getRuntime ();
    
    public ThreadExecutor(int threadPoolSize){
        if (threadPoolSize > runtime.availableProcessors ()){
            runtime.addShutdownHook (new com.calculator.thread.ThreadExecutor.Hook ());
            System.exit(2);
        }
        executor = java.util.concurrent.Executors.newFixedThreadPool (threadPoolSize);
    }
    
    
    
}
