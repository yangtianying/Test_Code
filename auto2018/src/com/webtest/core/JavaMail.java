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

		// ���������ļ�
		String toMail = ReadProperties.getPropertyValue("tomail");// �ռ��˵�������
		String frommail = ReadProperties.getPropertyValue("Sender");// �����˵�������
		String host = ReadProperties.getPropertyValue("host");// ָ�������ʼ�������Ϊ smtp.qq.comQQ�ʼ�������
		String pwd = ReadProperties.getPropertyValue("pwd");
		// ��ȡϵͳ����
		Properties properties = System.getProperties();

		// �����ʼ�������
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");

		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(frommail, pwd); // �������ʼ��û�������Ȩ��
			}
		});

		// ����Ĭ�ϵ� MimeMessage ����
		MimeMessage message = new MimeMessage(session);

		try {
			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(frommail));

			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

			// Set Subject: ͷ��ͷ�ֶ�
			message.setSubject("This is the Subject !");

			// ������Ϣ��
//			message.setText("This is actual message");
			message.setText(content);
			message.setContent(content, "text/html;charset=utf-8");

			// ������Ϣ
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
