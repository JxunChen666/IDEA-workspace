package com.fangjian.zhenbao.base.utils;

import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * <p>
 * 控制执行命令的输入输出线程.
 * </p>
 *
 * @author mumu@yfyang
 * @version 1.0 2013-09-06 4:55 PM
 * @since JDK 1.5
 */
public class StreamGobbler extends Thread {
    /**
     * 错误类型
     */
    public static final String ERROR_TYPE = "ERROR";
    /**
     * 输出
     */
    public static final String OUTPUT_TYPE = "OUTPUT";
    private final InputStream is;
    @SuppressWarnings("unused")
    private final String type;
    /**
     * 进程UUID
     */
    private final String uuid;
    private final Map<String, String> result_map = Maps.newHashMap();


    public StreamGobbler(InputStream is, String type, String uuid) {
        this.is = is;
        this.type = type;
        this.uuid = uuid;

    }

    @Override
    public void run() {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(is);
            final BufferedReader br = new BufferedReader(isr);
            String line;
            String lastResult = null;
            while ((line = br.readLine()) != null) {
                lastResult = line;
            }
            this.result_map.put(this.uuid, lastResult);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getResult() {
        String result = result_map.get(this.uuid);
        result_map.remove(this.uuid);
        return result;
    }
}
