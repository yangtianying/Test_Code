package com.webtest.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * author:lihuanzhen ������������ʧ�ܣ�����
 */

public class WebTestListener extends TestListenerAdapter {

	FreemakerTemplateEngine ft = new FreemakerTemplateEngine();
	JavaMail mail = new JavaMail();

//	@Override
//	public void onTestFailure(ITestResult tr) {
//
//		Log.error(tr.getInstance() + "-" + tr.getName() + "����ʧ�ܣ���Ҫ����");
//		BaseTest tb = (BaseTest) tr.getInstance();
//		WebDriver driver = tb.getDriver();
//		SeleniumScreenShot ss = new SeleniumScreenShot(driver);
//		ss.screenShot();

//	}

	@Override
	public void onFinish(ITestContext testContext) {

		List<ITestResult> failedList1 = this.getFailedTests();
		System.out.println("fail:" + this.getFailedTests().size());
		List<ITestResult> passedList1 = this.getPassedTests();

		List<String> failedList2 = new ArrayList();
		List<String> passedList2 = new ArrayList();
//		failedList2.add(failedList1.size().toString());
		// �õ�ʧ�ܵ������б�
		for (int i = 0; i < failedList1.size(); i++) {

//			System.out.println(failedList1.get(i).getInstanceName() + "." + failedList1.get(i).getName());

			failedList2.add(failedList1.get(i).getInstanceName() + "." + failedList1.get(i).getName());

		}
		// �õ��ɹ��������б�

		for (int i = 0; i < passedList1.size(); i++) {

			passedList2.add(passedList1.get(i).getInstanceName() + "." + passedList1.get(i).getName());

		}

		Map Result = new HashMap();
		Result.put("passedNum", passedList1.size());
		Result.put("failedNum", failedList1.size());
		Result.put("passedList2", passedList2);
		Result.put("failedList2", failedList2);
		Result.put("Num", passedList1.size() + failedList1.size());
		Result.put("curTime", new Date());// ʱ���ʽ

		// ����FreemakerTemplateEngine run���� ��result ת��ΪString ��Ϊ�ʼ�������
		try {
			String content = ft.run(Result);
			System.out.println("�ҵĲ���");
			System.out.println(content);
			mail.send(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
