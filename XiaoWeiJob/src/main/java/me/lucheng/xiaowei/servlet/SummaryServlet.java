package me.lucheng.xiaowei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dao.SummaryDAO;
import me.lucheng.xiaowei.dal.dataobject.Summary2DO;
import me.lucheng.xiaowei.dal.mybatis.SpringSummaryDAO;

/**
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		SummaryDAO summaryDAO = new SpringSummaryDAO();
		List<Summary2DO> result = summaryDAO.summarize2();
		StringBuilder sb = new StringBuilder();
		sb.append("<table id='summary' style='display:none;'><thead><th>公司名称</th><th>公司类型</th><th>公司行业</th><th>公司规模</th>"
				+ "<th>职位名称</th><th>待遇</th><th>学历要求</th><th>工作年限</th><th>工作地点</th><th>工作类型</th>"
				+ "</tr></thead><tbody>");

		for (Summary2DO summary : result) {
			sb.append("<tr><td>");

			sb.append(summary.getCname());
			sb.append("</td><td>");
			sb.append(summary.getCtype());
			sb.append("</td><td>");

			sb.append(summary.getCindustry());
			sb.append("</td><td>");
			sb.append(summary.getCscale());
			sb.append("</td><td>");

			sb.append(summary.getJname());
			sb.append("</td><td>");

			sb.append(summary.getJsalary());
			sb.append("</td><td>");
			sb.append(summary.getJdegree());
			sb.append("</td><td>");
			sb.append(summary.getJexperience());
			sb.append("</td><td>");
			sb.append(summary.getJlocation());
			sb.append("</td><td>");
			sb.append(summary.getJtype());
			sb.append("</td></tr>");
		}
		sb.append("</tbody></table>");
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
