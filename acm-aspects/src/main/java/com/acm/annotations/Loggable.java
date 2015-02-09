package com.acm.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Loggable {

    /**
     * TRACE level of logging.
     */
    int TRACE = 0;

    /**
     * DEBUG level of logging.
     */
    int DEBUG = 1;

    /**
     * INFO level of logging.
     */
    int INFO = 2;

    /**
     * WARN level of logging.
     */
    int WARN = 3;

    /**
     * ERROR level of logging.
     */
    int ERROR = 4;

    /**
     * Level of logging.
     */
    int value() default Loggable.INFO;

    /**
     * Maximum amount allowed for this method (a warning will be issued if it
     * takes longer).
     * 
     * @since 0.0.1
     */
    int limit() default 1;

    /**
     * Time unit for the limit.
     * 
     * @since 0.0.1
     */
    TimeUnit unit() default TimeUnit.MINUTES;

    /**
     * Shall we trim long texts in order to make log lines more readable?
     * 
     * @since 0.0.1
     */
    boolean trim() default true;

    /**
     * Method entry moment should be reported as well (by default only an exit
     * moment is reported).
     * 
     * @since 0.0.1
     */
    boolean prepend() default false;

    /**
     * List of exception types, which should not be logged if thrown.
     * 
     * <p>
     * You can also mark some exception types as "always to be ignored", using
     * {@link Loggable.Quiet} annotation.
     * 
     * @since 0.0.1
     */
    Class<? extends Throwable>[] ignore() default {};

    /**
     * Skip logging of result, replacing it with dots?
     * 
     * @since 0.0.1
     */
    boolean skipResult() default false;

    /**
     * Skip logging of arguments, replacing them all with dots?
     * 
     * @since 0.0.1
     */
    boolean skipArgs() default false;

    /**
     * Add toString() result to log line.
     * 
     * @since 0.0.1
     */
    boolean logThis() default false;

    /**
     * The precision (number of fractional digits) to be used when displaying
     * the measured execution time.
     * 
     * @since 0.0.1
     */
    int precision() default 2;

    /**
     * The name of the logger to be used. If not specified, defaults to the
     * class name of the annotated class or method.
     * 
     * @since 0.0.1
     */
    String name() default "";

    /**
     * Flag of the track to be used. If not specified,defaults to 'false'
     * 
     * @since 0.0.1
     */
    boolean trackFlag() default false;

    /**
     * Identifies an exception that is never logged by {@link Loggable} if/when
     * being thrown out of an annotated method.
     * 
     * <p>
     * Sometimes exceptions are used as flow control instruments (although this
     * may be considered as a bad practice in most casts). In such situations we
     * don't want to flood log console with error messages. One of the options
     * is to use {@link Loggable#ignore()} attribute to list all exception types
     * that should be ignored. However, this {@link Loggable.Quiet} annotation
     * is more convenient when we want to ignore one specific exception type in
     * all situations.
     * 
     * @since 0.0.1
     */
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Quiet {
    }

}
