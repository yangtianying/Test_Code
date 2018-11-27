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

		// 创建一个合适的Configration对象
		Configuration configuration = new Configuration();
		String dir = "E:\\JavaEEcode\\Test_Code\\auto2018\\ftl";
		// 从哪里加载模板文件
		configuration.setDirectoryForTemplateLoading(new File(dir));

		configuration.setDefaultEncoding("UTF-8");// 这个一定要设置，不然在生成的页面中不然会乱码

		// 获取或创建一个模版。
		Template template = null;
		try {
			template = configuration.getTemplate("freemarker.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 输出
//		Writer out = null;
//		out = new FileWriter(new File(dir + "freemarker2.html"));

		Writer out = new StringWriter();
		// 合并数据模型和模板，并将结果输出到out中
		try {
			template.process(result, out);

		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println("结果：" + out);
		// 关闭流
		out.flush();
		out.close();
		return out.toString();

	}

}
