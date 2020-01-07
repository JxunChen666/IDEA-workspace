
package com.fangjian.zhenbao.base.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("restriction")
public class FreemarkerUtil {

    // @Autowired
    // private FreeMarkerConfigurer freeMarkerConfigurer;

    private static Configuration configuration = new Configuration();

    private Template template = null;

    private InputStream asposeLicense;

    private String pdfFonts;

    public String getPdfFonts() {
        return pdfFonts;
    }

    public void setPdfFonts(String pdfFonts) {
        this.pdfFonts = pdfFonts;
    }

    public InputStream getAsposeLicense() {
        return asposeLicense;
    }

    public void setAsposeLicense(InputStream asposeLicense) {
        this.asposeLicense = asposeLicense;
    }

    public FreemarkerUtil() {
        configuration.setDefaultEncoding("utf-8");
    }

    /**
     * 根据模板包路径和模板名称获得模板
     *
     * @throws Exception
     */
    public FreemarkerUtil(Template tpl) throws Exception {

        this();
        template = tpl;
        template.setEncoding("utf-8");
    }

    /**
     * 模板从远程机器加载，获得模板的流
     *
     * @param inputStream
     * @throws Exception
     * @throws IOException
     */
    public FreemarkerUtil(InputStream inputStream) throws Exception {

        this();

        try {
            this.template = new Template("template", new InputStreamReader(inputStream, "UTF-8"), configuration);
            template.setEncoding("utf-8");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception("模板解析异常");
        }
    }

    /**
     * 导出word，存入本地路径
     *
     * @param dataMap
     * @param outPath
     * @return
     */
    public boolean createDoc(Map<String, Object> dataMap, String outPath) {

        boolean flag = false;
        File outFile = new File(outPath);
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            template.process(dataMap, writer);
            flag = true;
        }
        catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 导出word，写入response直接下载
     *
     * @param dataMap
     * @param response
     * @throws IOException
     */
    public void createDoc(Map<String, Object> dataMap, HttpServletResponse response, String fileName) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date datetemp = cal.getTime();
        String today = sdf.format(datetemp);
        fileName = fileName + "(" + today + ")";

        ByteArrayOutputStream boutput = new ByteArrayOutputStream();
        Writer out = null;
        OutputStream output = null;
        try {

            out = new BufferedWriter(new OutputStreamWriter(boutput, "utf-8"));

            template.process(dataMap, out);

            byte[] data = boutput.toByteArray();

            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".doc");
            response.setHeader("Content-Length", String.valueOf(data.length));

            output = response.getOutputStream();
            output.write(data);
            output.flush();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (out != null) {
                    out.close();
                }
                if (boutput != null) {
                    boutput.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读文件到二进制数组
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            try {
                in.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 读入文件下载
     *
     * @param response
     * @throws IOException
     */
    public static void downloadFile(HttpServletResponse response, String fileName, String path) {
        ByteArrayOutputStream boutput = new ByteArrayOutputStream();
        Writer out = null;
        OutputStream output = null;
        try {
            byte[] data = toByteArray(path);
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".pdf");
            response.setHeader("Content-Length", String.valueOf(data.length));

            output = response.getOutputStream();
            output.write(data);
            output.flush();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (out != null) {
                    out.close();
                }
                if (boutput != null) {
                    boutput.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成图片
     *
     * @param bytes
     * @return
     */
    public static String getImageBase64(byte[] bytes) {

        if (bytes == null) {
            return null;
        }
        else {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(bytes);
        }
    }

    /**
     * 把inputstream转为byte[]
     *
     * @param in
     * @return
     */
    public static byte[] streamToByteArray(InputStream in) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        try {
            while ((len = in.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    /**
     * 处理特殊字符
     *
     * @param map
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void convSpecilStr(Map<String, Object> map) {
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (map.get(key) instanceof String) {
                    String value = (String) map.get(key);
                    // value = value.trim();
                    value = value.replaceAll("&", "&amp;");
                    value = value.replaceAll("<", "&lt;");
                    value = value.replaceAll(">", "&gt;");
                    map.put(key, value);
                }
                else if (map.get(key) instanceof List) {
                    List<Map> value = (List) map.get(key);
                    for (Map m : value) {
                        convSpecilStr(m);
                    }
                }
            }
        }
    }
}
