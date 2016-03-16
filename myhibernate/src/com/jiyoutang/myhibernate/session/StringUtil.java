package com.jiyoutang.myhibernate.session;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.jiyoutang.myhibernate.bean.Employee;

public class StringUtil {

	private static Random random = new Random();
	public static Employee getRandomEmployee() {
		String name = "";
		for(int i = 0, n = 2 + (random.nextInt(8) == 0?0:1);i<n;i++) {
			try{
				name += getChineseCharacter(System.currentTimeMillis() + i);
			}catch(Exception e){
				
			}
		}
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(20 + random.nextInt(40));
		int year = 1950 + random.nextInt(40);
		int month = 1 + random.nextInt(12);
		int day = 1 + random.nextInt(31);
		
		employee.setBirthday(Date.valueOf(year + "-" + 
		month + "-" + day));
		employee.setDateCreated(new java.util.Date());
		employee.setDescription("");
		employee.setDisabled(random.nextInt(10) == 9);
		employee.setSex(random.nextInt(3) == 2 ? "男" : "女");
		int hh = 7 + random.nextInt(2);
		int mm = random.nextInt(60);
		int ss = random.nextInt(60);
		employee.setStartTime(Time.valueOf(hh+":"+mm+":"+ss));
		int hhh = 16 + random.nextInt(2);
		employee.setEndTime(Time.valueOf(hhh+":"+mm+":"+ss));
		double salary = 1000 + random.nextDouble() * 5000;
		employee.setSalary(salary);
		return employee;
	}
	private static String getChineseCharacter(long l) throws UnsupportedEncodingException {
		String str = null;
		int highPos,lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));
		byte[] b = new byte[2];
		b[0] = (new Integer(highPos).byteValue());
		b[1] = (new Integer(lowPos).byteValue());
		str = new String(b, "GBK");
		return str;
	}
	public static String getURL(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		String url = requestURI + "?" + filterQueryString(queryString);
		if(!url.endsWith("?")) {
			url += "&";
		}
		return url;
	}
	public static String filterQueryString(String queryString) {
		//正则表达式去掉不要的字符
		if(queryString == null) {
			return "";
		}
		queryString = queryString.replaceAll("[^&]*sort=[^&]*", "");
		queryString = queryString.replaceAll("[^&]*order=[^&]*", "");
		queryString = queryString.replaceAll("[^&]*action=[^&]*", "");
		queryString = queryString.replaceAll("&{2,}", "");
		queryString = queryString.replaceAll("^&", "");
		queryString = queryString.replaceAll("&$", "");
		return queryString;
	}
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean isNull(String obj) {
		return obj == null || obj.trim().length() == 0;
	}
}
