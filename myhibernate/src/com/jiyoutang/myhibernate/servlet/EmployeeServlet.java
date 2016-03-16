package com.jiyoutang.myhibernate.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiyoutang.myhibernate.bean.Employee;
import com.jiyoutang.myhibernate.session.HibernateUtil;
import com.jiyoutang.myhibernate.session.Pagination;
import com.jiyoutang.myhibernate.session.StringUtil;

public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if("add".equals(action)) {
			addEmployee(req, resp);
			return;
		}
		listEmployee(req, resp);
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		
		if(StringUtil.isNull(sort)) {
			sort = "id";
		}
		if(StringUtil.isNull(order)) {
			order = "desc";
		}
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String ageOperate = request.getParameter("ageOperate");
		
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String time = request.getParameter("time");
		String salary = request.getParameter("salary");
		String salaryOperate = request.getParameter("salaryOperate");
		String description = request.getParameter("description");
		String disabled = request.getParameter("disabled");
		String where = "";
		
		if(!StringUtil.isNull(sex)) {
			if(!StringUtil.isNull(where)){
				where += " and ";
			}
			where += "e.sex = '" + sex + "' ";
		}
		if(!StringUtil.isNull(age)) {
			if(!StringUtil.isNull(where)){
				where += " and ";
			}
			where += "e.age " + ageOperate + " " + age;
		}
		if(!StringUtil.isNull(birthday)){
			if(!StringUtil.isNull(where)) {
				where += " and ";
			}
			where += " e.birthday = '" + birthday + "' ";
		}
		if(!StringUtil.isNull(time)) {
			if(!StringUtil.isNull(where)) {
				where += " and ";
			}
			where += " (e.startTime<= '" + time + "' and e.endTime>='" + time + "') ";
		}
		if(!StringUtil.isNull(salary)) {
			if(!StringUtil.isNull(where)) {
				where += " and ";
			}
			where += " e.salary " + salaryOperate + " " + salary;
		}
		if(!StringUtil.isNull(description)) {
			if(!StringUtil.isNull(where)) {
				where += " and ";
			}
			where += " e.description like '%" + description +"%' ";
		}
		if(!StringUtil.isNull(disabled)) {
			if(!StringUtil.isNull(where)) {
				where += " and ";
			}
			where += " e.disabled = " + ("true".equals(disabled));
		}
		String hql = " from Employee e ";
		if(!StringUtil.isNull(where)) {
			hql += " where " + where;
		}
		hql += "order by e." + sort + " " + order;
		
		Query query = HibernateUtil.getSessionFactory().openSession()
				.createQuery(" select count(e) " + hql);
		Number result = (Number)query.uniqueResult();
		int count = result.intValue();
		//Pagination pagination = new Pagination(request,response);
		Pagination pagination = new Pagination();
		pagination.setRecordCount(count);
		//pagination.setRequest(request);
		
		query = HibernateUtil.getSessionFactory()
				.openSession()
				.createQuery(hql)
				.setFirstResult(pagination.getFirstResult())
				.setMaxResults(pagination.getPageSize());
		List<Employee> employeeList = query.list();
		request.setAttribute("url", StringUtil.getURL(request));
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("employeeList", employeeList);
		if(request.getAttribute("message") == null){
			request.setAttribute("message", "HQL 我们:" + hql);
		}
		request.getRequestDispatcher("/listEmployee.jsp")
		.forward(request, response);
		return;
	}

	private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee employee = StringUtil.getRandomEmployee();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tran = session.beginTransaction();
		session.persist(employee);
		tran.commit();
		session.close();
		req.setAttribute("message", 
				"已添加随机员工" + employee.getName());
		listEmployee(req,resp);
	}


}
