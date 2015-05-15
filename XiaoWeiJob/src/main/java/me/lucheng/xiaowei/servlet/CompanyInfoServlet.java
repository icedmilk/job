package me.lucheng.xiaowei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.CompanyDO;
import me.lucheng.xiaowei.dal.mybatis.SpringCompanyDAO;

/**
 * Servlet implementation class CompanyInfo
 */
public class CompanyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CompanyDO companyinfo = new SpringCompanyDAO()
				.selectCompanyByID(request.getParameter("id")).get(0);
		StringBuilder sb = new StringBuilder();
		sb.append("公司规模: ");
		sb.append(companyinfo.getCscale());
		sb.append("<br/>公司性质: ");
		sb.append(companyinfo.getCtype());
		sb.append("<br/>行业类型: ");
		sb.append(companyinfo.getCindustry());
		sb.append("<br/>公司描述: ");
		sb.append(companyinfo.getCdescription());
		response.getWriter().print(sb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
