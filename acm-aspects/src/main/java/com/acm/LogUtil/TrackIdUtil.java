package com.acm.LogUtil;

/**
 * 任务跟踪id工具类
 * 
 * @author sunzq
 * @date: 2015年1月9日 下午3:55:28
 * @version 1.0
 * @since JDK 1.7
 */
public class TrackIdUtil {

    /**
     * 存储当前线程的trackId
     */
    private static ThreadLocal<String> threadTrackId = new ThreadLocal<>();

    /**
     * 为当前线程生成一个跟踪id
     * 
     * @return
     */
    public static String genTrackId() {
        String trackId = GenerateSequenceUtils.generateSequence();
        threadTrackId.set(trackId);
        return trackId;
    }

    /**
     * 获得当前线相关的一个任务跟踪id，如果不存在，则生成一个，并设置到线程上。
     * 
     * @return
     */
    public static String getTrackId() {
        String trackId = threadTrackId.get();
        if (trackId == null) {
            trackId = genTrackId();
        }
        return trackId;
    }

    /**
     * 设置当前线程相关的一个任务跟踪id
     * 
     * @param trackId
     */
    public static void setTrackId(String trackId) {
        threadTrackId.set(trackId);
    }
}