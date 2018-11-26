package com.webtest.demo;

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.HashMap;
	import java.util.Map;

import org.testng.annotations.Test;

import freemarker.template.Configuration;
	
	import freemarker.template.Template;
	import freemarker.template.TemplateException;
	import freemarker.template.TemplateExceptionHandler;

	 
	public class FreemakerTest  {
	 
		private String dir = "E:\\Study\\����\\Selenium\\auto2018\\src\\com\\webtest\\demo";
	
		@Test
		public void testFreemarker() {
			Configuration cfg = new Configuration();
	 
			try {
				// ���������ģ���ļ�
				cfg.setDirectoryForTemplateLoading(new File(dir));
				
				// ����ģ���λ�ã�����·���У������FreemarkerManager���ڵ�·������ģ��
				// cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerManager.class, "templates"))
	 
				// ���ö����װ��
//				cfg.setObjectWrapper(new DefaultObjectWrapper());
	 
				// �����쳣������
				cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
	 
				// ��������ģ��
				Map root = new HashMap();
				root.put("abc", "���磬���");
	 
				// ͨ��freemarker����ģ�壬������Ҫ���Template����
				Template template = cfg.getTemplate("test.ftl");
	 
				// ����ģ��������֮������
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter(dir+"/out.txt")));
	 
				
				try {
					// ����ģ��
					template.process(root, out);
				} catch (TemplateException e) {
					e.printStackTrace();
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
