/**
 * Copyright (c) 2012-2014, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.acm.aspects;

import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;

import com.acm.LogUtil.TrackLogger;
import com.acm.annotations.Loggable;

/**
 * Helper methods for logging.
 * 
 * @author Krzysztof Krason (Krzysztof.Krason@gmail.com)
 * @version $Id$
 */
final class LogHelper {

    private static org.slf4j.Logger logger;

    /**
     * Helper constructor.
     */
    private LogHelper() {
        // do nothing
    }

    /**
     * Log one line.
     * 
     * @param level Level of logging
     * @param log Destination log
     * @param message Message to log
     * @param params Message parameters
     * @checkstyle ParameterNumberCheck (3 lines)
     */
    public static void log(final boolean trackFlag, final int level, final Object log, final String message,
            final Object... params) {
        logger = getLogger(log, trackFlag);
        if (level == Loggable.TRACE) {
            logger.trace(message, params);
        } else if (level == Loggable.DEBUG) {
            logger.debug(message, params);
        } else if (level == Loggable.INFO) {
            logger.info(message, params);
        } else if (level == Loggable.WARN) {
            logger.warn(message, params);
        } else if (level == Loggable.ERROR) {
            logger.error(message, params);
        }
    }

    /**
     * Log level is enabled?
     * 
     * @param level Level of logging
     * @param log Destination log
     * @return TRUE if enabled
     */
    public static boolean enabled(final boolean trackFlag, final int level, final Object log) {
        boolean enabled;
        logger = getLogger(log, trackFlag);
        if (level == Loggable.TRACE) {
            enabled = logger.isTraceEnabled();
        } else if (level == Loggable.DEBUG) {
            enabled = logger.isDebugEnabled();
        } else if (level == Loggable.INFO) {
            enabled = logger.isInfoEnabled();
        } else if (level == Loggable.WARN) {
            enabled = logger.isWarnEnabled();
        } else {
            enabled = true;
        }
        return enabled;
    }

    private static org.slf4j.Logger getLogger(final Object source, boolean trackFlag) {
        final org.slf4j.Logger logger;
        if (trackFlag) {
            if (source instanceof Class) {
                logger = TrackLogger.getLogger((Class<?>) source);
            } else if (source instanceof String) {
                logger = TrackLogger.getLogger(String.class.cast(source));
            } else {
                logger = TrackLogger.getLogger(source.getClass());
            }

        } else {
            if (source instanceof Class) {
                logger = LoggerFactory.getLogger((Class<?>) source);
            } else if (source instanceof String) {
                logger = LoggerFactory.getLogger(String.class.cast(source));
            } else {
                logger = LoggerFactory.getLogger(source.getClass());
            }
        }
        return logger;
    }

    /**
     * Get the destination logger for this method.
     * 
     * @param method The method
     * @param name The Loggable annotation
     * @return The logger that will be used
     */
    public static Object logger(final Method method, final String name) {
        final Object source;
        if (name == null || name.isEmpty()) {
            source = method.getDeclaringClass();
        } else {
            source = name;
        }
        return source;
    }
}
