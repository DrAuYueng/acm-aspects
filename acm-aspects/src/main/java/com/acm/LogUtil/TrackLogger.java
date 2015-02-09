package com.acm.LogUtil;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class TrackLogger implements ITrackLogger {
    private static final String DELIM_STR = "{}";
    private final Logger mLogger;

    private TrackLogger(Class<?> clz) {
        mLogger = LoggerFactory.getLogger(clz);
    }

    private TrackLogger(String name) {
        mLogger = LoggerFactory.getLogger(name);
    }

    public static TrackLogger getLogger(Class<?> clz) {
        return new TrackLogger(clz);
    }

    public static TrackLogger getLogger(String name) {
        return new TrackLogger(name);
    }

    @Override
    public String getTrackId() {
        return TrackIdUtil.getTrackId();
    }

    @Override
    public String getName() {
        return mLogger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return mLogger.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        mLogger.trace(addTrackInfo(msg), getTrackId());
    }

    @Override
    public void trace(String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void trace(String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void trace(String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.trace(trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return mLogger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        mLogger.trace(marker, addTrackInfo(msg), getTrackId());
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(marker, trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(marker, trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        String trackInfo = addTrackInfo(format);
        mLogger.trace(trackInfo, mergeArgs(trackInfo, argArray, getTrackId()));
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.trace(marker, trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isDebugEnabled() {
        return mLogger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        mLogger.debug(addTrackInfo(msg), getTrackId());
    }

    @Override
    public void debug(String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void debug(String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void debug(String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.debug(trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return mLogger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        mLogger.debug(marker, addTrackInfo(msg), getTrackId());
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(marker, trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(marker, trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.debug(marker, trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.debug(marker, trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isInfoEnabled() {
        return mLogger.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        mLogger.info(addTrackInfo(msg), getTrackId());
    }

    @Override
    public void info(String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void info(String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void info(String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.info(trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return mLogger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String msg) {
        mLogger.info(marker, addTrackInfo(msg), getTrackId());
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(marker, trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(marker, trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.info(marker, trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.info(marker, trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isWarnEnabled() {
        return mLogger.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        mLogger.warn(addTrackInfo(msg), getTrackId());
    }

    @Override
    public void warn(String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void warn(String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void warn(String msg, Throwable t) {
        mLogger.warn(addTrackInfo(msg), getTrackId(), t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return mLogger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        mLogger.warn(marker, addTrackInfo(msg), getTrackId());
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(marker, trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(marker, trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.warn(marker, trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.warn(marker, trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isErrorEnabled() {
        return mLogger.isErrorEnabled();
    }

    @Override
    public void error(String msg) {
        mLogger.error(addTrackInfo(msg), getTrackId());
    }

    @Override
    public void error(String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void error(String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void error(String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.error(trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return mLogger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        mLogger.error(marker, addTrackInfo(msg), getTrackId());
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(marker, trackInfo, mergeArgs(trackInfo, null, arg, getTrackId()));
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(marker, trackInfo, mergeArgs(trackInfo, null, arg1, arg2, getTrackId()));
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        String trackInfo = addTrackInfo(format);
        mLogger.error(marker, trackInfo, mergeArgs(trackInfo, arguments, getTrackId()));
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        String trackInfo = addTrackInfo(msg);
        mLogger.error(marker, trackInfo, mergeArgs(trackInfo, null, t, getTrackId()));
    }

    private String addTrackInfo(String formatOrMsg) {
        return formatOrMsg + ",trackId={}";
    }

    private Object[] mergeArgs(String formatOrMsg, Object[] front, Object... back) {
        Object[] objects = ArrayUtils.addAll(front, back);
        int countDelim = countDelim(formatOrMsg);
        if (countDelim == 0 || objects.length == countDelim) {
            return objects;
        }
        // 将trackId参数交换到正确的位置
        if (objects.length > countDelim) {
            Object temp = objects[countDelim - 1];
            objects[countDelim - 1] = objects[objects.length - 1];
            objects[objects.length - 1] = temp;
        }
        return objects;
    }

    private int countDelim(String formatOrMsg) {
        int count = 0;
        for (int i = 0; i < formatOrMsg.length();) {
            int index = formatOrMsg.indexOf(DELIM_STR, i);
            if (index != -1) {
                count++;
                i = index + DELIM_STR.length();
            } else {
                return count;
            }
        }
        return count;
    }

}