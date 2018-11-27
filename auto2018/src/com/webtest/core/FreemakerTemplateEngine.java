package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemakerTemplateEngine {

	public String run(Map result) throws IOException {

		// ����һ�����ʵ�Configration����
		Configuration configuration = new Configuration();
		String dir = "E:\\JavaEEcode\\Test_Code\\auto2018\\ftl";
		// ���������ģ���ļ�
		configuration.setDirectoryForTemplateLoading(new File(dir));

		configuration.setDefaultEncoding("UTF-8");// ���һ��Ҫ���ã���Ȼ�����ɵ�ҳ���в�Ȼ������

		// ��ȡ�򴴽�һ��ģ�档
		Template template = null;
		try {
			template = configuration.getTemplate("freemarker.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���
//		Writer out = null;
//		out = new FileWriter(new File(dir + "freemarker2.html"));

		Writer out = new StringWriter();
		// �ϲ�����ģ�ͺ�ģ�壬������������out��
		try {
			template.process(result, out);

		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println("�����" + out);
		// �ر���
		out.flush();
		out.close();
		return out.toString();

	}

}
