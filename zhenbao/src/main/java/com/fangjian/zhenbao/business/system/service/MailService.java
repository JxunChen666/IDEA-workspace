package com.fangjian.zhenbao.business.system.service;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author zyyang3
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     * 发送纯文本形式的email
     *
     * @param toEmail 收件人邮箱
     * @param title   邮件标题
     * @param content 邮件内容
     */
    public void sendTextMail(String[] toEmail, String title, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("alarm@todaycity.cn");
        msg.setTo(toEmail);
        msg.setSubject(title);
        msg.setText(content);
        sender.send(msg);
    }

    /**
     * 发送带有html的内容
     * @throws MessagingException
     */
    public void sendHtmlMail(String[] toEmail, String title, String htmlContent)
        throws MessagingException {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, false, "utf-8");
        helper.setFrom("alarm@todaycity.cn");
        helper.setTo(toEmail);
        helper.setSubject(title);
        helper.setText(htmlContent, true);
        sender.send(msg);
    }

    /**
     * 添加附件的email发送
     *
     * @param toEmail    收件人地址
     * @param title      邮件标题
     * @param content    文本内容
     * @param aboutFiles 附件信息 每个子项都是一个文件相关信息的map
     *                   Map<String,String>:
     *                   1.filePath   2.fileName
     * @throws Exception 异常
     */
    public void sendAttachmentMail(String[] toEmail, String title, String content,
        List<Map<String, String>> aboutFiles) throws Exception {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
        helper.setFrom("alarm@todaycity.cn");
        helper.setTo(toEmail);
        helper.setSubject(title);
        helper.setText(content);
        Resource resource = null;
        for (Map<String, String> file : aboutFiles) {
            resource = new FileSystemResource(file.get("filePath"));
            if (resource.exists()) {//是否存在资源
                File attachmentFile = resource.getFile();
                helper.addAttachment(file.get("fileName"), attachmentFile);
            }
        }
        sender.send(msg);
    }



    /**
     * 使用freemarker模板进行发送
     *
     * @param toEmail            收件人邮箱
     * @param title              标题
     * @param templateName       模板名称 模板都放在类路径下的mailtemp下
     * @param templateNameParams 模板中的参数，其中${key} 要使用map去进行替换
     * @throws MessagingException 异常
     */
    public void sendTemplateMail(String[] toEmail, String[] toCC, String title, String templateName,
        Map<String, Object> templateNameParams) throws MessagingException {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, false, "utf-8");
        helper.setFrom("alarm@todaycity.cn");
        helper.setTo(toEmail);
        if (toCC != null) {
            helper.setCc(toCC);
        }
        helper.setSubject(title);
        String htmlText = getMailText(templateName, templateNameParams);
        helper.setText(htmlText, true);
        sender.send(msg);
    }


    /**
     * 使用freemarker模板+附件进行发送
     *
     * @param toEmail            收件人邮箱
     * @param title              标题
     * @param templateName       模板名称 模板都放在类路径下的mailtemp下
     * @param templateNameParams 模板中的参数，其中${key} 要使用map去进行替换
     * @param aboutFiles         附件信息 每个子项都是一个文件相关信息的map
     *                           Map<String,String>:
     *                           1.filePath   2.fileName
     * @throws Exception 异常
     */
    public void sendTemplateMail(String[] toEmail, String title, String templateName,
        Map<String, Object> templateNameParams, List<Map<String, String>> aboutFiles)
        throws Exception {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
        helper.setFrom("alarm@todaycity.cn");
        helper.setTo(toEmail);
        helper.setSubject(title);
        String htmlText = getMailText(templateName, templateNameParams);
        Resource resource = null;
        for (Map<String, String> file : aboutFiles) {
            resource = new FileSystemResource(file.get("filePath"));
            if (resource.exists()) {//是否存在资源
                File attachmentFile = resource.getFile();
                helper.addAttachment(file.get("fileName"), attachmentFile);
            }
        }
        helper.setText(htmlText, true);
        sender.send(msg);
    }

    /**
     * 获取模板信息并且替换
     *
     * @param userId
     * @return
     */
    private String getMailText(String templateName, Map<String, Object> templateNameParams) {
        String htmlText = null;
        try {
            Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, templateNameParams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return htmlText;
    }

    /**
     * 获取模板信息
     *
     * @param templateName 模板名称
     * @return
     */
    public Template getTemplate(String templateName) {
        Template tpl = null;
        try {
            tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tpl;
    }



    /**
     * 发送带有图片内容的邮件 不建议使用这个  使用模板的那个就ok了、
     *
     * @throws MessagingException
     */
    @Deprecated
    public void sendInMIMEMail() throws MessagingException {
        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
        helper.setFrom("px_miniportal@126.com");
        helper.setTo("masterspring3@gmail.com");
        helper.setSubject("注册成功");
        String htmlText = "<html><head>"
            + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">"
            + "</head><body>" + "欢迎访问xxx论坛！</hr>"
            + "<div><img src=\"cid:img01 \"></img></div>" // 特殊标示 cid:...
            + "</body></html>";
        helper.setText(htmlText, true);
        ClassPathResource img = new ClassPathResource("bbt.gif");
        helper.addInline("img01 ", img);
        sender.send(msg);
    }
}
