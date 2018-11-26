package com.webtest.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerDemo {
	@Test
	public void test() throws TemplateException, IOException {

		Configuration conf = new Configuration();
		// ģ��·��
		String dir = "E:\\Java SourceCode\\JavaEECode\\auto2018\\ftl";
		// ����ģ��Ŀ¼
		conf.setDirectoryForTemplateLoading(new File(dir));
		// ��ȡģ��
		Template template = conf.getTemplate("freemarker.html");

		// ����
		Map root = new HashMap();
		root.put("world", "�������");

		// list ��������
		List<String> persons = new ArrayList<String>();
		persons.add("С��1");
		persons.add("С��2");
		persons.add("С��3");
		root.put("persons", persons);

		// map ��������
		Map mx = new HashMap();
		mx.put("С��1", "С��1");
		mx.put("С��2", "С��2");
		mx.put("xm3", "С��3");
		root.put("mx", mx);

		// list<map>����
		List<Map> listMap = new ArrayList<Map>();
		Map mx1 = new HashMap();
		Map mx2 = new HashMap();
		mx1.put("С��1", "С��1");
		mx1.put("С��2", "С��2");
		mx2.put("xm3", "С��3");
		listMap.add(mx1);
		listMap.add(mx2);
		root.put("listMap", listMap);

		// ʱ���ʽ
		root.put("curTime", new Date());
		// null��ʽ
		root.put("testNull", null);

		// ���
		Writer out = new FileWriter(new File(dir + "hello.html"));

		// ���ɿ�ʼ
		template.process(root, out);
		// �ر���
		out.flush();
		out.close();

		System.out.println("������");

	}
}
