package com.fangjian.zhenbao.base.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.server.data.provider.clients.image.ImageServerClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/11/24 0024.
 */

public class ImgUtils {
    private static final String imgUploadUrl = "http://drivetest.todaycity.cn:8011/common/upload";

    private static final String DOMAIN = ConfigUtil.get("aliyunImgServer");
    private static final String BUCKET_NAME = ConfigUtil.get("bucket.name");
    private static final String WATERMARK = ConfigUtil.get("watermark");
    private static final String WATERMARK_ICON = ConfigUtil.get("watermark_icon");


    /**
     * 图片上传工具
     *
     * @param file 图片文件
     * @param type 图片压缩类型 "1" -> 原图模式(可能压缩)  "2"-> 缩略图模式(可能压缩,可能裁剪)
     * @return List<String> 图片文件地址urls
     */
    public static List<String> uploadImages(File file, String type) {
        List<File> files = new ArrayList<File>();
        files.add(file);
        return uploadImages(files, type);
    }


    public static List<String> uploadImages(List<File> files, String type) {

        List<String> urls = new ArrayList<String>();

        HttpPost post = new HttpPost(imgUploadUrl);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();


        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addTextBody("type", type);

        for (File file : files) {
            builder.addBinaryBody("file", file);
        }

        HttpEntity entity = builder.build();
        RequestConfig config = RequestConfig.custom().setConnectTimeout(20000)
                .setSocketTimeout(50000).setCookieSpec(CookieSpecs.DEFAULT).build();
        post.setEntity(entity);
        post.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            response = HttpClients.createDefault().execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String str = EntityUtils.toString(response.getEntity());
                Iterator<Object> iterator = JSON.parseArray(str).iterator();
                while (iterator.hasNext()) {
                    String url = iterator.next().toString();
                    urls.add(url);
                }
            } else {

                return urls;
            }
        } catch (Exception e) {

            return urls;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return urls;
    }

    /**
     * <p>
     *
     * @param suffix 文件后缀名
     * @param is     文件输入流
     * @return
     * @author ChuJing, 2016年2月23日
     */
    public static String upload2ALiYun(String suffix, InputStream is, HttpServletRequest request) {
        /*String imgId=IdGenerator.uuid()+suffix;
        HttpSession session = request.getSession();
    	String flagStr = (String) session.getAttribute("flag");
    	int flag = Integer.parseInt((StringUtils.isEmpty(flagStr) || flagStr.equals("0"))? "0":"2");
        if (flag == 2){
    		String iconPath = request.getSession().getServletContext().getRealPath("/static/img/白图也不怕版水印.png");
//    		is = ImageMarkLogoUtil.markImageByIcon(iconPath, is);
        	Boolean result=ImageServerClient.upload2OSS(imgId, is, BUCKET_NAME);
        	if(result){
        		return WATERMARK+"/"+imgId+WATERMARK_ICON;
        	}else{
        		//throw new RuntimeException("图片服务器上传出错！");
        		return "";
        	}
    	} else {
        	Boolean result=ImageServerClient.upload2OSS(imgId, is, BUCKET_NAME);
        	if(result){
        		return DOMAIN+"/"+imgId;
        	}else{
        		//throw new RuntimeException("图片服务器上传出错！");
        		return "";
        	}
    	}*/
        return "";
    }


    public static String uploadNews(String suffix, InputStream is, HttpServletRequest request) {
        String newName = IdGenerator.uuid() + suffix;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateFolder = sdf.format(new Date());
        String separator = System.getProperty("file.separator");//String separator = "/";//
        String path = separator + "static" + separator + "upload" + separator + dateFolder;
        //指定上传位置
        String uploadPath = request.getSession().getServletContext().getRealPath(path);
        File saveFile = new File(uploadPath + File.separator + newName);
        try {
            FileUtils.copyInputStreamToFile(is, saveFile);
            return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + separator + "static" + separator + "upload" + separator + dateFolder + separator + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
