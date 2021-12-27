package cn.com.hkr.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.util.Date;
import java.util.Properties;


/**
 * @author jason
 * @date 2021/6/8-10:33
 * 发送邮件工具类
 */
@Component
public class SendEmailUtils {
    public Logger log = Logger.getLogger(SendEmailUtils.class);
    private static Properties pro = new Properties();
    private static Byte[] txt;

    private Boolean isExists(String[] files) throws FileNotFoundException {
        for(String filename :files){
            if (!new File(filename).exists()) throw new FileNotFoundException(filename);
        }
        return true;
    }


    public  void sendMail(String toUser,String subject ,String content,String[] files) throws Exception {

        if (null == toUser || toUser.equals(""))throw  new Exception("接收人不能为空!");

        if (null == subject || subject.equals(""))throw new Exception("邮件主题不能为空!");

        InputStream input = SendEmailUtils.class.getClassLoader().getResourceAsStream("mail.properties");
        pro.load(input);

        System.out.println("正常的邮箱配置--------------------------" + pro);
        Session session = Session.getDefaultInstance(pro, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication((String) pro.get("mail.from"),
                        (String) pro.get("mail.password"));
            }
        });
        //开启debug模式
        session.setDebug(true);

        /*开启连接对象*/
        Transport transport = session.getTransport();

        /*连接邮箱服务器*/
        try {
            transport.connect((String) pro.get("mail.host"),
                    (String) pro.get("mail.from"),
                    (String) pro.get("mail.password"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        /*创建一封邮件*/
        MimeMessage message = new MimeMessage(session);


        /*设置邮件发送人*/
        message.setFrom((String) pro.get("mail.user"));

        message.setRecipients(Message.RecipientType.TO, toUser);

        message.setSentDate(new Date());

        /*设置邮箱主题*/
        message.setSubject(subject);

        /*设置邮件正文*/
        message.setContent(content, "text/html");

        ////////////////////////////////发送带有html的邮件
        MimeMultipart part  = new MimeMultipart();
        ////添加邮件正文
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(content,"text/html");
        part.addBodyPart(bodyPart);

        ////添加邮件附件
        if (null != files && files.length != 0) {
            //校验每个文件是否存在
            isExists(files);
            File file;
            for (String f : files) {
                MimeBodyPart attchment = new MimeBodyPart();
                file =  new File(f);
                DataSource source = new FileDataSource(file);
                attchment.setDataHandler(new DataHandler(source));
                attchment.setFileName(MimeUtility.encodeWord(file.getName()));

                part.addBodyPart(attchment);
            }
        }
        message.setContent(part);
        //////////////////////////////////发送带有html的邮件

        /*发送邮件*/
        transport.sendMessage(message, message.getAllRecipients());

        /*关闭资源*/
        transport.close();

    }
}
