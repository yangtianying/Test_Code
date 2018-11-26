package com.webtest.core;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.webtest.utils.ReadProperties;

public class JavaMail {

	public void send(String content) throws IOException {

		// 加载属性文件
		String toMail = ReadProperties.getPropertyValue("tomail");// 收件人电子邮箱
		String frommail = ReadProperties.getPropertyValue("Sender");// 发件人电子邮箱
		String host = ReadProperties.getPropertyValue("host");// 指定发送邮件的主机为 smtp.qq.comQQ邮件服务器
		String pwd = ReadProperties.getPropertyValue("pwd");
		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");

		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(frommail, pwd); // 发件人邮件用户名、授权码
			}
		});

		// 创建默认的 MimeMessage 对象
		MimeMessage message = new MimeMessage(session);

		try {
			// Set From: 头部头字段
			message.setFrom(new InternetAddress(frommail));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

			// Set Subject: 头部头字段
			message.setSubject("This is the Subject !");

			// 设置消息体
//			message.setText("This is actual message");
			message.setText(content);
			message.setContent(content, "text/html;charset=utf-8");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
