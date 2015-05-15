package me.lucheng.xiaowei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.lucheng.xiaowei.dal.dao.CompanyDAO;
import me.lucheng.xiaowei.dal.mybatis.SpringCompanyDAO;
import me.lucheng.xiaowei.dal.param.LoginParam;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		LoginParam param = new LoginParam();
		param.setCname(request.getParameter("name_login"));
		param.setCpasswd(request.getParameter("password_login"));

		CompanyDAO dao = new SpringCompanyDAO();
		boolean result = dao.login(param) >= 1;
		out.print(result);

		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("cname", param.getCname());
			session.setAttribute("cid", dao.selectCompanyByName(param.getCname()).get(0).getId());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
