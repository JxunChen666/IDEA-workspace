package com.fangjian.zhenbao.base.utils;

import java.util.UUID;


public class IdGenerator {
    /**
     * 生成唯一ID
     *
     * @return
     */
    public static final String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
