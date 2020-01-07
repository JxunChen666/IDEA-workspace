package com.fangjian.zhenbao.base.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author FangJian
 * @description: BASE64加密解密工具类
 * @date 2018-12-21 11:26
 */
public class BASE64 {
    //private static final Logger logger = LoggerFactory.getLogger(BASE64.class);
    private static final Logger logger = LogManager.getLogger(BASE64.class);

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * BASE64编码
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String doBASE64(String content) {
        String base64Content;
        try {
            byte[] b2;
            b2 = content.getBytes("utf-8");
            base64Content = BASE64.encryptBASE64(b2);
            return base64Content;
        } catch (Exception e) {
            logger.error("BASE64转码失败");
            e.printStackTrace();
        }
        return content;
    }

    /**
     * BASE64解码
     *
     * @param base64Content
     * @return
     * @throws Exception
     */
    public static String unBASE64(String base64Content) {
        String content;
        try {
            byte[] b2;
            b2 = BASE64.decryptBASE64(base64Content);
            content = new String(b2, "utf-8");
            return content;
        } catch (Exception e) {
            logger.error("BASE64解码失败");
            e.printStackTrace();
        }
        return base64Content;
    }

}