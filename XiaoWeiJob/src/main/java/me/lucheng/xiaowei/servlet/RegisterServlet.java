package me.lucheng.xiaowei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.CompanyDO;
import me.lucheng.xiaowei.dal.mybatis.SpringCompanyDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDO company = new CompanyDO(request.getParameter("cname"),
				request.getParameter("cpassword"), request.getParameter("cemail"),
				request.getParameter("cscale"), request.getParameter("ctype"),
				request.getParameter("cindustry"), request.getParameter("cdescription"));

		new SpringCompanyDAO().registerCompany(company);
		response.getWriter().print(true);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
